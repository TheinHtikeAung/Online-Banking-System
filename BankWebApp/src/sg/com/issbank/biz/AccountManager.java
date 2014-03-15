package sg.com.issbank.biz;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

import sg.com.issbank.dao.BankAccountDao;
import sg.com.issbank.dao.CheckingAccountDao;
import sg.com.issbank.dao.DaoFactory;
import sg.com.issbank.dao.mysql.BankAccountDaoImpl;
import sg.com.issbank.dao.mysql.TransactionDaoImpl;

import sg.com.issbank.dao.SavingsAccountDao;
import sg.com.issbank.dao.TransactionDao;

import sg.com.issbank.dto.BankAccount;
import sg.com.issbank.dto.CheckingAccount;
import sg.com.issbank.dto.SavingsAccount;
import sg.com.issbank.dto.Transaction;
import sg.com.issbank.exception.OverDraftLimitExceededException;

public class AccountManager{
	BankAccountDao bankAccountDao;
	TransactionDao transDao;
	
	public AccountManager(){
		bankAccountDao=new BankAccountDaoImpl();
		transDao=new TransactionDaoImpl();
	}
	
	Connection conn;
	
	public BankAccount getBalance(String accountID)
	{
		//double balance=0;
		BankAccount ba=new BankAccount();
		DaoFactory factory=new DaoFactory();
		BankAccountDao dao= factory.getbankaccountDAO();
		try {
			dao.openconnection();
			ba=dao.getBalancebyAccID(accountID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return ba;
	}
	
	public boolean checkcustomer(String accountId, int PIN) throws SQLException {

		BankAccountDao dao = DaoFactory.getbankaccountDAO();
		
		if (dao.checkcustomer(accountId, PIN)) {
			return true;
		} else {
			return false;
		}
				
	}
	
	public int withdraw(String accountId, BigDecimal amount) throws SQLException, OverDraftLimitExceededException
	{
		int update=0;
				
		BankAccountDao dao= DaoFactory.getbankaccountDAO();
		CheckingAccountDao chkdao=DaoFactory.getcheckingaccount();
		SavingsAccountDao svdao=DaoFactory.getsavingaccount();
		Transaction tran=new Transaction();
		TransactionDao trandao=DaoFactory.getTransactionDao();
		
		CheckingAccount ca;
		SavingsAccount sa;
		
		dao.openconnection();
		
		BankAccount BankAcc=dao.getBalancebyAccID(accountId);
		
		double amt=Double.parseDouble((amount.toString()));
		double balance=Double.parseDouble((BankAcc.getBalance().toString()));
					
				if(BankAcc.getAccountType().equals("Saving Account"))
				{ 
					double bal=svdao.getminimumBalancebyAccID(accountId).getMinimumBalance();
					sa=svdao.getminimumBalancebyAccID(accountId);
					double availbal=balance-bal;
					
						if(availbal>=amt)
							{
								balance=balance-amt;
								successfulwithdraw(amount, balance);
								System.out.println(bal);
								System.out.println(availbal);
								update=dao.updateBalance(balance,accountId);
								insertTransaction(accountId, tran, trandao, amt);
								return update;
							}
							else
							{
								failwithdraw();
							}
				}
				else if(BankAcc.getAccountType().equals("Checking Account"))
					{
						ca=chkdao.getoverDraftAmountbyAccID(accountId);
						if(balance>=amt)
						{
							balance=balance-amt;
							successfulwithdraw(amount, balance);
							update=dao.updateBalance(balance,accountId);
							insertTransaction(accountId, tran, trandao, amt);
							return update;
						}					
						else if(ca.getOverDraftAmount()>=(amt-balance))
						{
							double credit=(balance-amt);
							creditwithdraw(ca, credit);
							update=dao.updateBalance(credit,accountId);
							insertTransaction(accountId, tran, trandao, amt);
							return update;
						}
					}
				else{
				
					failwithdraw();
				}
			
	return update;
	}

	private void insertTransaction(String accountId, Transaction tran,
			TransactionDao trandao, double amt) {
		tran.setAccountId(accountId);
		tran.setTransactionType("Withdraw");
		tran.setTransactionAmount(amt);
		tran.setTransactionTime(time());
		trandao.insertWithdraw(tran);
	}


	public String failwithdraw() {
		String msg = "Overdraftamount is not enough for withdrawal";
		System.out.println(msg);
		return msg;
	}

	public String creditwithdraw(CheckingAccount ca, double credit) {
		String msg = "Withdraw amount is overdrafted and your credit is "
				+ credit + ".";
		System.out.println(ca.getOverDraftAmount());
		System.out.println(msg);
		return msg;
	}

	public String successfulwithdraw(BigDecimal amount, double balance) {
		String msg = "Withdraw is successful " + amount + " is deducted";
		System.out.println(balance);
		System.out.println(msg);
		return msg;
	}
	
	public Timestamp time() {
	    
	        Calendar calendar = Calendar.getInstance();
	        Date now = calendar.getTime();
	    	Timestamp time=new Timestamp(now.getTime());
	        return time;
	    }
	public ArrayList<BankAccount> findaccountbyCustID(String nric)
	{
		
		DaoFactory factory=new DaoFactory();
		BankAccountDao dao=factory.getbankaccountDAO();
		
		ArrayList<BankAccount> list=new ArrayList<BankAccount>();
		try {
			list = dao.findaccountbyCustID(nric);
			System.out.println(list);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public double getMaximumBalanceForCheckingAccount(String accountId) {
		
		return bankAccountDao.getMaximumBalanceForCheckingAccount(accountId);
	}

	public double getMaximumBalanceForSavingAccount(String accountId) {
		
		return bankAccountDao.getMaximumBalanceForSavingAccount(accountId);
	}

	public void withdrawProcess(String accountId, double withdrawAmt) {
		bankAccountDao.withdraw(accountId,withdrawAmt);
	}

	public void insertTransaction(Transaction trans) {
		
		transDao.insertTransaction(trans);
	}

	public void deposit(String transferId, double transferAmt) {
		
		bankAccountDao.deposit(transferId, transferAmt);
	}

	public BankAccount findBankAcc(String accountId) {
		return bankAccountDao.findBankAcc(accountId);
	}
	
	
	
	}

