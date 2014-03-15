package sg.com.issbank.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import sg.com.issbank.dao.SavingsAccountDao;
import sg.com.issbank.dto.SavingsAccount;

public class SavingsAccountDaoImpl implements SavingsAccountDao {
	
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	PreparedStatement ps=null;
	
	String query,error;

	@Override
	public SavingsAccount findSavingAccount(String acc) {
		query="select * from savingsaccount where accountId='"+acc+"'";
		connection=MySQL.getConnection();
		
		SavingsAccount savingAcc=new SavingsAccount();
		
		try{
			statement=connection.createStatement();
			rs = statement.executeQuery(query);
			
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing select: " + query);
			
			while (rs.next()) {
				savingAcc=new SavingsAccount(rs.getString(1), rs.getDouble(2));
			}
			
		}catch(SQLException e){
			error="Error in selecting Saving Account :" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		}finally{
			close();
		}
		
		return savingAcc;
	}
	
	@Override
	public void deleteSavingAcc(String acc) {
		
		query="delete from savingsaccount where accountId='"+acc+"'";
		connection=MySQL.getConnection();
		
		try {
			statement=connection.createStatement();
			statement.executeUpdate(query);
			
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Deleting Saving account : " + query);
			
		}catch (SQLException e) {
			error="Error in deleting Saving account :" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		}finally{
			close();
		}
	}
	
	@Override
	public void insertSavingAcc(String accountId, double minimumBalance) {
		connection=MySQL.getConnection();
		query="insert into savingsaccount values (?,?)";
		
		try {
			connection.setAutoCommit(false);
			
			ps=connection.prepareStatement(query);
			
			ps.setString(1, accountId);
			ps.setDouble(2, minimumBalance);
			
			ps.executeUpdate();
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing insert: " + query);
			
			connection.commit();
			
		} catch (SQLException e) {
			error="Error in Insert Saving Account :" + e;
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
	
	public void closeconnection() throws SQLException
	{
		conn.close();
	}
	
	public SavingsAccount getminimumBalancebyAccID(String accountId) throws SQLException
	{
		openconnection();
		SavingsAccount sa=new SavingsAccount(accountId);
		String sql="SELECT sa.minimumBalance " +
				"FROM team16.bankaccount as b,team16.savingsaccount as sa " +
				"WHERE b.accountId =sa.accountId AND b.accountId=?;";
		
		ppst=conn.prepareStatement(sql);
		ppst.setString(1, accountId);
		
		ResultSet rs=ppst.executeQuery();
		if(rs.next()){
				sa.setMinimumbalance(rs.getDouble("minimumBalance"));
			}
		closeconnection();
		ppst.close();
		return sa;
	}
	
}
