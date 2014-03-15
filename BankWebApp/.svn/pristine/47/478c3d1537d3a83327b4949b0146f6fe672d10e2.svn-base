

package sg.com.issbank.dao;

import sg.com.issbank.dao.mysql.CheckingAccountDaoImpl;
import sg.com.issbank.dao.mysql.CustomerDaoImpl;
import sg.com.issbank.dao.mysql.SavingsAccountDaoImpl;

import sg.com.issbank.dao.mysql.BankAccountDaoImpl;

import sg.com.issbank.dao.mysql.BankBranchDaoImpl;



import sg.com.issbank.dao.mysql.TransactionDaoImpl;

public class DaoFactory {
	public static TransactionDao getTransactionDao(){
		return new TransactionDaoImpl();
	}

	
	public static CustomerDao getCustomerDao(){
		return new CustomerDaoImpl();
	}

	public static BankAccountDao getbankaccountDAO()
	{
		return new BankAccountDaoImpl();
	}
	public static CustomerDao getCustomerDaoObject(){
		return new CustomerDaoImpl();
	}
	public static BankBranchDao getBankBranchDao(){
		return new BankBranchDaoImpl();
	}

	public static SavingsAccountDao getsavingaccount()
	{
		return new SavingsAccountDaoImpl();
	}
	
	public static CheckingAccountDao getcheckingaccount()
	{
		return new CheckingAccountDaoImpl();
	}


}
