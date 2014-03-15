package sg.com.issbank.dao.mysql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;

import sg.com.issbank.dto.BankAccount;
import sg.com.issbank.dao.BankAccountDao;

public class BankAccountDaoImpl implements BankAccountDao {
	private static final String url="jdbc:mysql://localhost:3306/team16";
	private static final String username="root";
	private static final String password="root";
	
	Connection conn;
	PreparedStatement ppst=null;
	
	public BankAccount getBalancebyAccID(String accountId) throws SQLException
	{
		openconnection();
		BankAccount ba = new BankAccount();
		String sql="SELECT * FROM bankaccount WHERE accountId=?;";
		
		ppst=conn.prepareStatement(sql);
		ppst.setString(1, accountId);
		ResultSet rs=ppst.executeQuery();
		while(rs.next()){
			ba.setAccountID(rs.getString("accountId"));
			ba.setAccountType(rs.getString("accountType"));
			ba.setBalance(rs.getBigDecimal("balance"));
			ba.setBBID(rs.getString("BBID"));
			}
		closeconnection();
		ppst.close();
		return ba;
	}
	
	public ArrayList<BankAccount> findaccountbyCustID(String nric) throws SQLException {
		ArrayList<BankAccount> AccList=new ArrayList<BankAccount>();
					openconnection();
					
			String sql="SELECT b.accountId,b.accountType,b.balance " +
					"FROM team16.bankaccount as b WHERE b.accountId IN" +
					"(SELECT bd.accountId FROM team16.bankaccountdetail as bd WHERE bd.nric IN " +
					"(SELECT c.nric FROM team16.customer as C WHERE c.nric=?));";
			ppst=conn.prepareStatement(sql);
			ppst.setString(1, nric);
			ResultSet rs=ppst.executeQuery();
			while(rs.next())
			{
				BankAccount ba=new BankAccount(rs.getString("accountId"), rs.getInt("PIN"), rs.getString("BBID"), rs.getString("accountType"), rs.getBigDecimal("balance"));
				AccList.add(ba);
			}
			closeconnection();
			return AccList;	
	}
	
	public BankAccount findOneAccountByNRIC(String nric) throws SQLException {
			
			BankAccount acc=new BankAccount();
			conn=MySQL.getConnection();
					
			String sql="select b.* from bankaccount b, bankaccountdetail d, customer c where c.nric=d.nric and d.accountId=b.accountId and c.NRIC=+'"+nric+"'";
			
			statement=conn.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				acc=new BankAccount(rs.getString("accountId"), rs.getInt("PIN"), rs.getString("BBID"), rs.getString("accountType"), rs.getBigDecimal("balance"));
				
			}
			closeconnection();
			return acc;	
	}
	
	public boolean successfulPIN() throws SQLException
	{
		return false;
	}


	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	PreparedStatement ps=null;
	
	String query,error;
	
	@Override
	public ArrayList<BankAccount> findByCustomer(String nric) {
		
		query="select a.* from bankaccount a, customer c, bankaccountdetail d " +
				  "where c.nric=? and c.nric=d.nric and d.accountId=a.accountId";
		connection=MySQL.getConnection();
		
		
		ArrayList<BankAccount> bankAcc=new ArrayList<BankAccount>();

		try{
			ps=connection.prepareStatement(query);
			
			ps.setString(1, nric);
			rs=ps.executeQuery();
			
			while (rs.next()) {
				bankAcc.add(new BankAccount(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBigDecimal(5)));
			}
			
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing select: +query");
			
		}catch(SQLException e){
			error="Error in selecting bank account :"+e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE,error);
		}finally{
			close();
		}
		
		return bankAcc;
	}
	
	@Override
	public void insertBankAcc(BankAccount acc) {
		connection=MySQL.getConnection();
		query="insert into bankaccount values (?,?,?,?,?)";
		
		try {
			connection.setAutoCommit(false);
			
			ps=connection.prepareStatement(query);
			
			ps.setString(1, acc.getAccountId());
			ps.setInt(2, acc.getPIN());
			ps.setString(3, acc.getBBID());
			ps.setString(4, acc.getAccountType());
			ps.setBigDecimal(5,acc.getBalance());
			
			ps.executeUpdate();
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing insert: " + query);
			
			connection.commit();
			
		} catch (SQLException e) {
			error="Error in Insert Bank Account :" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		}finally{
			close();
		}
		
	}
	public int updateBalance(double bal, String accountId)throws SQLException
	{
		openconnection();
		int result;
		String sql="UPDATE bankaccount SET balance =? WHERE accountId=?;";
		ppst=conn.prepareStatement(sql);
		ppst.setDouble(1, bal);
		ppst.setString(2, accountId);
		result=ppst.executeUpdate();
		closeconnection();
		
		return result;
		
	}

	@Override
	public void updateBankAcc(BankAccount acc) {
		connection=MySQL.getConnection();
		query="update bankaccount SET PIN=?, BBID=?, accountType=?, balance=? where accountId=?";
		
		try {
			connection.setAutoCommit(false);
			
			ps=connection.prepareStatement(query);
			
			ps.setString(5, acc.getAccountId());
			ps.setInt(1, acc.getPIN());
			ps.setString(2, acc.getBBID());
			ps.setString(3, acc.getAccountType());
			ps.setBigDecimal(4,acc.getBalance());
			
			ps.executeUpdate();
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing update: " + query);
			
			connection.commit();
			
		} catch (SQLException e) {
			error="Error in Update Bank Account :" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		}finally{
			close();
		}
	}

	
	public void close(){
		try {
			if (rs!=null) {
				rs.close();
			}
			
			if(statement!=null){
				statement.close();
			}
			
			if(connection!=null) {
				connection.close();
			}
			
		} catch (Exception e) {
			
		}
	}

	@Override
	public BankAccount findBankAcc(String accountId) {
		query="select * from bankaccount where accountId='"+accountId+"'";
		connection=MySQL.getConnection();
		
		BankAccount bankAcc=new BankAccount();

		try{
			statement=connection.createStatement();
			rs=statement.executeQuery(query);
			
			while (rs.next()) {
				bankAcc=new BankAccount(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBigDecimal(5));
			}
			
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing select: +query");
			
		}catch(SQLException e){
			error="Error in selecting bank account :"+e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE,error);
		}finally{
			close();
		}
		
		return bankAcc;
	}

	public void openconnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/team16","root","root");
		}catch(SQLException e)
		{	
			e.printStackTrace();
		}
	}
	
	private void closeconnection() throws SQLException
	{
		conn.close();
	}

	@Override
	public boolean deposit(String accId, double amount) {
		openconnection();
		try {
			ppst=conn.prepareStatement("update bankaccount set balance=balance+? where accountId=?");
			ppst.setDouble(1, amount);
			ppst.setString(2, accId);
			int update=ppst.executeUpdate();
			if(update>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updatePIN(String accountId, int newPIN) {
		connection=MySQL.getConnection();
		query="update bankaccount SET PIN=? where accountId=?";
		
		try {
			connection.setAutoCommit(false);
			
			ps=connection.prepareStatement(query);
			
			ps.setInt(1, newPIN);
			ps.setString(2, accountId);
			
			ps.executeUpdate();
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing update: " + query);
			
			connection.commit();
			
		} catch (SQLException e) {
			error="Error in Update Bank Account PIN :" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		}finally{
			close();
		}
	}

	@Override
	public double getMaximumBalanceForCheckingAccount(String accountId) {
		query="SELECT (b.balance+c.overDraftAmount) FROM bankaccount b, checkingaccount c " +
				"where b.accountId=c.accountId and b.accountId=?";
		connection=MySQL.getConnection();
		
		double result=0;

		try{
			ps=connection.prepareStatement(query);
			
			ps.setString(1, accountId);
			rs=ps.executeQuery();
			
			while (rs.next()) {
				result=rs.getDouble(1);
			}
			
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing select b.balance+c.overDraftAmount: +query");
			
		}catch(SQLException e){
			error="Error in selecting bank account b.balance+c.overDraftAmount :"+e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE,error);
		}finally{
			close();
		}
		
		return result;
	}

	@Override
	public double getMaximumBalanceForSavingAccount(String accountId) {
		query="SELECT (b.balance-s.minimumBalance) FROM bankaccount b, savingsaccount s " +
				"where b.accountId=s.accountId and b.accountId=?";
		
		connection=MySQL.getConnection();
		
		double result=0;

		try{
			ps=connection.prepareStatement(query);
			
			ps.setString(1, accountId);
			rs=ps.executeQuery();
			
			while (rs.next()) {
				result=rs.getDouble(1);
			}
			
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing select b.balance-s.minimumBalance : +query");
			
		}catch(SQLException e){
			error="Error in selecting bank account b.balance-s.minimumBalance :"+e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE,error);
		}finally{
			close();
		}
		
		return result;
	}

	@Override
	public boolean checkcustomer(String accountId, int pIN) throws SQLException {
		// TODO Auto-generated method stub
		openconnection();
		BankAccount ba = new BankAccount();
	
		String sql="SELECT * FROM bankaccount WHERE accountId=? AND PIN=?;";
		ppst=conn.prepareStatement(sql);
		ppst.setString(1, accountId);
		ppst.setInt(2, pIN);
		
		ResultSet rs=ppst.executeQuery();
		if(rs.next()){
			ba.setAccountId(rs.getString("accountId"));
			ba.setAccountType(rs.getString("accountType"));
			ba.setBalance(rs.getBigDecimal("balance"));
			return true;			
			}
		else
		{
			return false;
		}	
		
	}

	@Override
	public void withdraw(String accountId, double withdrawAmt) {
		openconnection();
		try {
			ppst=conn.prepareStatement("update bankaccount set balance=balance-? where accountId=?");
			ppst.setDouble(1, withdrawAmt);
			ppst.setString(2, accountId);
			ppst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}

