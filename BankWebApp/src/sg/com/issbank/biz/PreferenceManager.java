package sg.com.issbank.biz;

import sg.com.issbank.dao.BankAccountDao;
import sg.com.issbank.dao.CustomerDao;
import sg.com.issbank.dao.mysql.BankAccountDaoImpl;
import sg.com.issbank.dao.mysql.CustomerDaoImpl;

public class PreferenceManager {
	private BankAccountDao bankAccDAO;
	private CustomerDao customerDAO;

	public PreferenceManager() {
		this.bankAccDAO = new BankAccountDaoImpl();
		this.customerDAO=new CustomerDaoImpl();
	}

	public boolean checkPIN(int oldPIN, String accountId) {
		
		if(bankAccDAO.findBankAcc(accountId).getPIN()==oldPIN){return true;}
		
		return false;
	}

	public void updatePIN(String accountId, int newPIN) {
		
		bankAccDAO.updatePIN(accountId,newPIN);
		
	}

	public void updateAddress(String nric, String address) {
		
		customerDAO.updateAddress(nric,address);
		
	}
	
	
	
}
