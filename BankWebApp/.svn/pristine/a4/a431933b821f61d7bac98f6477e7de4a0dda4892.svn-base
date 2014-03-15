package sg.com.issbank.dao.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import sg.com.issbank.dao.CheckingAccountDao;
import sg.com.issbank.dto.CheckingAccount;


public class CheckingAccountDaoImpl implements CheckingAccountDao {

	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	PreparedStatement ps=null;
	
	String query,error;
	
	public void test(){
	}
	
	@Override
	public CheckingAccount findCheckingAccount(String acc) {
		
		query="select * from checkingaccount where accountId='"+acc+"'";
		connection=MySQL.getConnection();
		
		CheckingAccount checkAcc=new CheckingAccount();
		
		try{
			statement=connection.createStatement();
			rs = statement.executeQuery(query);
			
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing select: " + query);
			
			while (rs.next()) {
				checkAcc=new CheckingAccount(rs.getString(1), rs.getDouble(2));
			}
			
		}catch(SQLException e){
			error="Error in selecting Checking Account :" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		}finally{
			close();
		}
				
		return checkAcc;
	}


	@Override
	public void deleteCheckingAcc(String acc) {
		query="delete from checkingaccount where accountId='"+acc+"'";
		connection=MySQL.getConnection();
		
		try {
			statement=connection.createStatement();
			statement.executeUpdate(query);
			
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Deleting Checking account : " + query);
			
		}catch (SQLException e) {
			error="Error in deleting Checking account :" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		}finally{
			close();
		}
	}
	
	@Override
	public void insertCheckingAcc(String accountId, double overDraftAmount) {
		connection=MySQL.getConnection();
		query="insert into checkingaccount values (?,?)";
		
		try {
			connection.setAutoCommit(false);
			
			ps=connection.prepareStatement(query);
			
			ps.setString(1, accountId);
			ps.setDouble(2, overDraftAmount);
			
			ps.executeUpdate();
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing insert: " + query);
			
			connection.commit();
			
		} catch (SQLException e) {
			error="Error in Insert Checking Account :" + e;
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

	private static final String url="jdbc:mysql://localhost:3306/team16";
	private static final String username="root";
	private static final String password="root";
	
	Connection conn;
	PreparedStatement ppst=null;
	public void openconnection() throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		conn=DriverManager.getConnection(url,username,password);
		}catch(SQLException e)
		{	
			e.printStackTrace();
		}
	}
	
	private void closeconnection() throws SQLException
	{
		conn.close();
	}
	
	public CheckingAccount getoverDraftAmountbyAccID(String accountId) throws SQLException
	{
		openconnection();
		CheckingAccount ca=new CheckingAccount(accountId);
		String sql="SELECT ca.overDraftAmount " +
				"FROM team16.bankaccount as b,team16.checkingaccount as ca " +
				"WHERE b.accountId =ca.accountId AND b.accountId=?;";
		
		ppst=conn.prepareStatement(sql);
		ppst.setString(1, accountId);
		ResultSet rs=ppst.executeQuery();
		if(rs.next()){
			ca.setOverDraftAmount(rs.getDouble("OverDraftAmount"));
			}
		closeconnection();
		ppst.close();
		return ca;
	}
	public int updateoverDraftAmount(double credit, String accountId)throws SQLException
	{
		openconnection();
		int result;
		String sql="UPDATE checkingaccount SET overDraftAmount =? WHERE accountId=?;";
		ppst=conn.prepareStatement(sql);
		ppst.setDouble(1, credit);
		ppst.setString(2, accountId);
		result=ppst.executeUpdate();
		closeconnection();
		ppst.close();
		return result;
		
	}



}
