package sg.com.issbank.biz;

import java.sql.SQLException;
import java.util.ArrayList;


import sg.com.issbank.dao.BankAccountDao;
import sg.com.issbank.dao.BankAccountDetailDao;
import sg.com.issbank.dao.BankBranchDao;
import sg.com.issbank.dao.CheckingAccountDao;
import sg.com.issbank.dao.CustomerDao;
import sg.com.issbank.dao.SavingsAccountDao;
import sg.com.issbank.dao.TransactionDao;
import sg.com.issbank.dao.mysql.BankAccountDaoImpl;
import sg.com.issbank.dao.mysql.BankAccountDetailDaoImpl;
import sg.com.issbank.dao.mysql.BankBranchDaoImpl;
import sg.com.issbank.dao.mysql.CheckingAccountDaoImpl;
import sg.com.issbank.dao.mysql.CustomerDaoImpl;
import sg.com.issbank.dao.mysql.SavingsAccountDaoImpl;
import sg.com.issbank.dao.mysql.TransactionDaoImpl;
import sg.com.issbank.dto.BankAccount;
import sg.com.issbank.dto.BankBranch;
import sg.com.issbank.dto.Customer;
import sg.com.issbank.dto.Transaction;

public class AdminManager {
	private BankAccountDao bankAccDAO;
	private BankAccountDetailDao bankAccDetailDAO;
	private BankBranchDao bankBranchDAO;
	private CustomerDao customerDAO;
	private CheckingAccountDao checkAcc;
	private SavingsAccountDao saveAcc;
	private TransactionDao transDao;

	public AdminManager() {
		this.customerDAO = new CustomerDaoImpl();
		this.bankBranchDAO=new BankBranchDaoImpl();
		this.bankAccDAO=new BankAccountDaoImpl();
		this.checkAcc=new CheckingAccountDaoImpl();
		this.saveAcc=new SavingsAccountDaoImpl();
		this.bankAccDetailDAO=new BankAccountDetailDaoImpl();
		this.transDao=new TransactionDaoImpl();
	}
	
	public ArrayList<Customer> getCustomers(){
		ArrayList<Customer> customers=new ArrayList<Customer>();
		customers=customerDAO.getCustomers();
		
		return customers;
	}
	
	public void insertCustomer(Customer c) {
    		customerDAO.insertCustomer(c);
    }
	
	public void updateCustomer(Customer c) {
		customerDAO.updateCustomer(c);
	}
	
	public ArrayList<BankBranch> getBankBranches(){
		ArrayList<BankBranch> bankbranches=new ArrayList<BankBranch>();
		bankbranches=bankBranchDAO.getBankbranch();
		
		return bankbranches;
	}
	
	public void insertBankBranch(BankBranch bb) {
		bankBranchDAO.insertBankBranch(bb);
    }
	
	public void updateBankBranch(BankBranch bb) {
		bankBranchDAO.updateBankBranch(bb);
	}
	
	public ArrayList<BankAccount> getBankAccByCustomer(String nric){
		return bankAccDAO.findByCustomer(nric);
	}
	
	public void insertBankAccount(BankAccount acc){
		bankAccDAO.insertBankAcc(acc);
	}
	
	public void updateBankAccount(BankAccount acc){
		bankAccDAO.updateBankAcc(acc);
	}
	
	public Customer findCustomer(String nric){
		return customerDAO.findCustomer(nric);
	}

	public void deleteRelatedAcc(String acc) {
		checkAcc.deleteCheckingAcc(acc);
		saveAcc.deleteSavingAcc(acc);
	}

	public void insertCheckingAcc(String accountId, double overDraftAmount) {
		checkAcc.insertCheckingAcc(accountId, overDraftAmount);
	}

	public void insertSavingAcc(String accountId, double minimumBalance) {
		saveAcc.insertSavingAcc(accountId, minimumBalance);
	}

	public void insertBankAccountDetail(String nric, String accountId) {
		bankAccDetailDAO.insertAccDetail(nric,accountId);
	}

	public void deleteBankAccountDetail(String nric, String accountId) {
		bankAccDetailDAO.deleteAccDetail(nric,accountId);
	}

	public BankAccount findAccountById(String accountId) {
		return bankAccDAO.findBankAcc(accountId);
	}

	public BankBranch findByBBID(String BBID) {
		return bankBranchDAO.findBranch(BBID);
	}

	public ArrayList<Transaction> findTransactionByAccountId(String accountId) {
		return transDao.findTransactionByAccountId(accountId);
	}

	public ArrayList<Customer> findCustomers(String keyword) {
		return customerDAO.findCustomerByNRIC(keyword);
	}

	public ArrayList<Customer> findCustomerByAccountId(String accountId) {
		return customerDAO.findCustomersByAccountId(accountId);
	}
	

}
