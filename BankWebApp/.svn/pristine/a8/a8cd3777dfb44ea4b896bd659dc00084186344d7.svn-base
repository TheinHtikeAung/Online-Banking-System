package sg.com.issbank.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import sg.com.issbank.dto.BankAccountDetail;
import sg.com.issbank.dto.Customer;

public interface CustomerDao {
	public ArrayList<Customer> getCustomers();
	
	public void insertCustomer(Customer c);
	
	public void updateCustomer(Customer c);


	public Customer getCustomersByIdPwd(String userId, String pwd)
			throws SQLException;
	
	public ArrayList<BankAccountDetail> getAccountDetailByCustomerID(String nric) 
			throws SQLException;
	
	public ArrayList<String> getAccountIDByNric(String nric)
	         throws SQLException;

	
	public Customer findCustomer(String nric);



	public ArrayList<Customer> findCustomerByNRIC(String keyword);

	public ArrayList<Customer> findCustomersByAccountId(String accountId);

	public String getCustomerAccountIdByUserID(String userId, String pin);
	
	public boolean checkPIN(String accountId, String PIN);

	public void updateAddress(String nric, String address);

}
