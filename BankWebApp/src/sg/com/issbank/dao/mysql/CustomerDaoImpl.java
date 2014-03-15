package sg.com.issbank.dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Util;

import sg.com.issbank.dao.CustomerDao;
import sg.com.issbank.dto.BankAccountDetail;
import sg.com.issbank.dto.CheckingAccount;
import sg.com.issbank.dto.Customer;
import sg.com.issbank.dto.SavingsAccount;
import sg.com.issbank.util.Kitool;

public class CustomerDaoImpl implements CustomerDao {

	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	String query, error;

	
	@Override
	public ArrayList<Customer> getCustomers() {

		ArrayList<Customer> customers = new ArrayList<Customer>();
		query = "select * from customer";

		connection = MySQL.getConnection();

		try {

			statement = connection.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing retrieve: " + query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				Customer c = new Customer(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getDate(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getDate(9));
				customers.add(c);
			}

		} catch (SQLException e) {
			error = "Error in Retrieve :" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		} finally {
			close();
		}

		return customers;
	}

	@Override
	public Customer getCustomersByIdPwd(String userId, String pwd)
			throws SQLException {

		Customer c = new Customer();
		// query="select * from customer where userid='"+userId+"' and password='"+pwd+"'";
		String sql = "select * from customer where userid=? and password=?;";

		connection = MySQL.getConnection();
		ps = connection.prepareStatement(sql);
		ps.setString(1, userId);
		ps.setString(2, pwd);
		rs = ps.executeQuery();

		if (rs.next()) {
			c.setNric(rs.getString("nric"));
			c.setName(rs.getString("name"));
			c.setAddress(rs.getString("address"));
			c.setDateOfBirth(rs.getDate("dateOfBirth"));
			c.setNationality(rs.getString("nationality"));
			c.setGender(rs.getString("gender"));
			c.setUserid(rs.getString("userid"));
			c.setPassword(rs.getString("password"));
			c.setDateOfJoining(rs.getDate("dateOfJoining"));
		}
		// connection.commit();
		close();

		return c;
	}

	public void insertCustomer(Customer c) {
		connection = MySQL.getConnection();
		query = "insert into customer values (?,?,?,?,?,?,?,?,?)";

		try {
			connection.setAutoCommit(false);

			ps = connection.prepareStatement(query);

			ps.setString(1, c.getNric());
			ps.setString(2, c.getName());
			ps.setString(3, c.getAddress());
			ps.setDate(4, Kitool.parseSQLDate(c.getDateOfBirth()));
			ps.setString(5, c.getNationality());
			ps.setString(6, c.getGender());
			ps.setString(7, c.getUserid());
			ps.setString(8, c.getPassword());
			ps.setDate(9, Kitool.parseSQLDate(c.getDateOfJoining()));

			ps.executeUpdate();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing insert: " + query);

			connection.commit();

		} catch (SQLException e) {
			error = "Error in Insert Customer :" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		} finally {
			close();
		}
	}

	public void updateCustomer(Customer c) {
		connection = MySQL.getConnection();
		query = "update customer SET name=?, address=?, dateOfBirth=?, nationality=?, gender=?,"
				+ "userid=?, password=?, dateOfJoining=? where nric=?";

		try {
			connection.setAutoCommit(false);

			ps = connection.prepareStatement(query);

			ps.setString(9, c.getNric());
			ps.setString(1, c.getName());
			ps.setString(2, c.getAddress());
			ps.setDate(3, Kitool.parseSQLDate(c.getDateOfBirth()));
			ps.setString(4, c.getNationality());
			ps.setString(5, c.getGender());
			ps.setString(6, c.getUserid());
			ps.setString(7, c.getPassword());
			ps.setDate(8, Kitool.parseSQLDate(c.getDateOfJoining()));

			ps.executeUpdate();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing update: " + query);

			connection.commit();

		} catch (SQLException e) {
			error = "Error in Update Customer :" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		} finally {
			close();
		}
	}

	
	public Customer findCustomer(String nric){
		query="select * from customer where nric='"+nric+"'";
		connection=MySQL.getConnection();
		
		Customer c=new Customer();
		

		try {

			statement=connection.createStatement();
			rs = statement.executeQuery(query);
			
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing select: " + query);

			while (rs.next()) {
				c = new Customer(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getDate(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getDate(9));
			}

		}catch (SQLException e) {
			error="Error in selecting customer :" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		} finally {
			close();
		}

		return c;
	}

	public ArrayList<BankAccountDetail> getAccountDetailByCustomerID(String nric)
			throws SQLException {
		// BankAccountDetail bankAccountDetail = null;
		ArrayList<BankAccountDetail> accounts = new ArrayList<BankAccountDetail>();
		connection = MySQL.getConnection();
		String sql = "select * from bankaccountdetail where nric=?";
		ps = connection.prepareStatement(sql);
		ps.setString(1, nric);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			BankAccountDetail bAD = new BankAccountDetail();
			bAD.setAccountId(rs.getString("accountId"));
			bAD.setNric(rs.getString("nric"));
			accounts.add(bAD);
		}

		close();
		return accounts;
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}

		} catch (Exception e) {

		}
	}

	@Override
	public ArrayList<String> getAccountIDByNric(String nric)
			throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<String> aidlist = new ArrayList<String>();
		connection = MySQL.getConnection();
		String sql = "SELECT accountid FROM bankaccountdetail where nric=?;";
		ps = connection.prepareStatement(sql);
		ps.setString(1, nric);
		rs = ps.executeQuery();
		while (rs.next()) {
			String r = rs.getString("accountid");
			aidlist.add(r);
		}
		return aidlist;
	}

	public ArrayList<BankAccountDetail> accountNoIsExist(String accountId)
			throws SQLException {
		// BankAccountDetail bankAccountDetail = null;
		ArrayList<BankAccountDetail> accounts = new ArrayList<BankAccountDetail>();
		connection = MySQL.getConnection();
		String sql = "select * from bankaccountdetail where accountId=?";
		ps = connection.prepareStatement(sql);
		ps.setString(1, accountId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			BankAccountDetail bAD = new BankAccountDetail();
			bAD.setAccountId(rs.getString("accountId"));
			bAD.setNric(rs.getString("nric"));
			accounts.add(bAD);
		}

		close();
		return accounts;
	}

	public ArrayList<CheckingAccount> getOverDraftAmount(String accountId)
			throws SQLException {
		// BankAccountDetail bankAccountDetail = null;
		ArrayList<CheckingAccount> accounts = new ArrayList<CheckingAccount>();
		connection = MySQL.getConnection();
		String sql = "select * from checkingaccount where accountId=?";
		ps = connection.prepareStatement(sql);
		ps.setString(1, accountId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			CheckingAccount bAD=new CheckingAccount(rs.getString("accountId"),rs.getDouble("overDraftAmount"));
			/*CheckingAccount bAD = new CheckingAccount(
					rs.getString("accountId"), Double.valueOf(rs
							.getString("overDraftAmount")));*/
			accounts.add(bAD);
		}

		close();
		return accounts;
	}

	public ArrayList<SavingsAccount> getSavingAccount(String accountId)
			throws SQLException {
		// BankAccountDetail bankAccountDetail = null;
		ArrayList<SavingsAccount> accounts = new ArrayList<SavingsAccount>();
		connection = MySQL.getConnection();
		String sql = "select * from savingsaccount where accountId=?";
		ps = connection.prepareStatement(sql);
		ps.setString(1, accountId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			/*SavingsAccount bAD = new SavingsAccount(rs.getString("accountId"),
					Double.valueOf(rs.getString("minimumbalance")));*/
			
			SavingsAccount bAD=new SavingsAccount(rs.getString("accountId"),rs.getDouble("minimumBalance"));
			accounts.add(bAD);
		}

		close();
		return accounts;
	}

	public void subAmount(double amount, String accountId) throws SQLException {

		connection = MySQL.getConnection();
		// TODO:这个写法不一定能够执行，就是将账户的金额扣除
		String sql = "update bankaccount  set balance =balance-? where accountId=?";
		ps = connection.prepareStatement(sql);
		ps.setDouble(1, amount);
		ps.setString(2, accountId);
		ps.execute();

		close();
	}

	public void subCheckingAccountAmount(double amount, String accountId)
			throws SQLException {

		connection = MySQL.getConnection();
		// TODO:
		String sql = "update checkingaccount  set overDraftAmount =overDraftAmount-? where accountId=?";
		ps = connection.prepareStatement(sql);
		ps.setDouble(1, amount);
		ps.setString(2, accountId);
		ps.execute();
	
		close();
	}

	public void addAmount(double amount, String accountNo) throws SQLException {

		connection = MySQL.getConnection();
		// TODO:
		String sql = "update bankaccount  set balance =balance+? where accountId=?";
		ps = connection.prepareStatement(sql);
		ps.setDouble(1, amount);
		ps.setString(2, accountNo);
		ps.execute();
	

		close();
	}

	public double getBalanceByAccountID(String accountId) throws SQLException {
		double balance = 0;
		connection = MySQL.getConnection();
		String sql = "select balance from bankAccount where accountId=?";

		ps = connection.prepareStatement(sql);
		ps.setString(1, accountId);
		rs=ps.executeQuery();
		if(rs.next()){
			balance=rs.getDouble("balance");
		}

		return balance;
	}


	@Override
	public ArrayList<Customer> findCustomerByNRIC(String keyword) {
		query="select * from customer where nric LIKE'"+keyword+"%'";
		connection=MySQL.getConnection();
		
		ArrayList<Customer> customers=new ArrayList<Customer>();
		
		try {
			statement=connection.createStatement();
			rs = statement.executeQuery(query);
			
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing select: " + query);
			
			while (rs.next()) {
				Customer c=new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getDate(9));
				customers.add(c);
			}
			
		}catch (SQLException e) {
			error="Error in selecting customer by NRIC :" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		}finally{
			close();
		}
		return customers;
	}

	@Override
	public ArrayList<Customer> findCustomersByAccountId(String accountId) {
		ArrayList<Customer> customers=new ArrayList<Customer>();
		query="select c.* from customer c, bankaccount a, bankaccountdetail d " +
				"where c.nric=d.nric and d.accountId=a.accountId and a.accountId='"+accountId+"'";
		
		connection=MySQL.getConnection();
		
		try {
			
			statement = connection.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing retrieve: " + query);
			rs = statement.executeQuery(query);
			
			while (rs.next()) {
				Customer c=new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getDate(9));
				customers.add(c);
			}
			
		}catch (SQLException e) {
			error="Error in Retrieve customers by Bank Account Id:" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		}finally{
			close();
		}
		
		return customers;
	}


	@Override
	public  String getCustomerAccountIdByUserID(String userId, String pin) {
		String accId=null;
		connection=MySQL.getConnection();
		try {
			ps=connection.prepareStatement("select ba.accountId from customer c"
												+" join bankaccountdetail bad on c.nric = bad.nric and c.userid=?" 
												+" join bankaccount ba on bad.accountId = ba.accountId and ba.pin=?");
			ps.setString(1, userId);
			ps.setString(2, pin);
			rs=ps.executeQuery();
			while(rs.next()){
				accId=rs.getString("accountId");
				System.out.println("Account ID: "+accId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accId;
	}
	
	public boolean checkPIN(String accountId, String PIN){
		
		connection=MySQL.getConnection();
		try{
			ps=connection.prepareStatement("select * from bankaccount where accountId=? AND PIN=?");
			
			ps.setString(1, accountId);
			ps.setString(2, PIN);
			rs=ps.executeQuery();
			while(rs.next()){
				return true;
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateAddress(String nric, String address) {
		connection=MySQL.getConnection();
		query="update customer SET address=? where nric=?";
		
		try {
			connection.setAutoCommit(false);
			
			ps=connection.prepareStatement(query);
			
			ps.setString(1, address);
			ps.setString(2, nric);
			
			ps.executeUpdate();
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing update: " + query);
			
			connection.commit();
			
		} catch (SQLException e) {
			error="Error in Update Customer address :" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		}finally{
			close();
		}
	}

}
