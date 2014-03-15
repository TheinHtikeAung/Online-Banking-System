package sg.com.issbank.dao;


import java.util.ArrayList;

import sg.com.issbank.dto.BankAccount;

import java.sql.SQLException;



public interface BankAccountDao {

	public ArrayList<BankAccount> findByCustomer(String nric);
	
	public void insertBankAcc(BankAccount acc);
	
	public void updateBankAcc(BankAccount acc);
	
	public BankAccount findBankAcc(String accountId);

	public ArrayList<BankAccount> findaccountbyCustID(String nric) throws SQLException;
	public BankAccount findOneAccountByNRIC(String nric) throws SQLException;
	public BankAccount getBalancebyAccID(String accountId) throws SQLException;
	
	public boolean deposit(String accId, double amount);
	public void openconnection();
	public int updateBalance(double bal, String accountId)throws SQLException;
	public boolean checkcustomer(String accountId, int pIN)throws SQLException;

	public void updatePIN(String accountId, int newPIN);

	public double getMaximumBalanceForCheckingAccount(String accountId);

	public double getMaximumBalanceForSavingAccount(String accountId);

	public void withdraw(String accountId, double withdrawAmt);


}
