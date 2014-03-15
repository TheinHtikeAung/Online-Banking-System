package sg.com.issbank.dao;


import java.sql.Timestamp;
import java.util.ArrayList;

import sg.com.issbank.dto.Transaction;


import java.util.Date;


public interface TransactionDao {
	
	public int insertTransaction(Transaction transaction);
	
	public Transaction insertWithdraw(Transaction transaction);
	
	public ArrayList<Transaction> getTransactionByDate(Date from, Date to, String accountId);
	public ArrayList<Transaction> getAllTransactions(String accId);

	public ArrayList<Transaction> findTransactionByAccountId(String accountId);

}
