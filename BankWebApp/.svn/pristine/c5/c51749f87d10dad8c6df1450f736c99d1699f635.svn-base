package sg.com.issbank.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import sg.com.issbank.dao.BankAccountDetailDao;
import sg.com.issbank.util.Kitool;

public class BankAccountDetailDaoImpl implements BankAccountDetailDao {

	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	PreparedStatement ps=null;
	
	String query,error;
	
	@Override
	public void insertAccDetail(String nric, String accountId) {
		connection=MySQL.getConnection();
		query="insert into bankaccountdetail values (?,?)";
		
		try {
			connection.setAutoCommit(false);
			
			ps=connection.prepareStatement(query);
			
			ps.setString(1, accountId);
			ps.setString(2, nric);
			
			ps.executeUpdate();
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing insert: " + query);
			
			connection.commit();
			
		} catch (SQLException e) {
			error="Error in Insert Bank Account Detail :" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		}finally{
			close();
		}
	}
	
	@Override
	public void deleteAccDetail(String nric, String accountId) {
		query="delete from bankaccountdetail where accountId='"+accountId+"'";
		connection=MySQL.getConnection();
		
		try {
			statement=connection.createStatement();
			statement.executeUpdate(query);
			
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Deleting Bank account detail : " + query);
			
		}catch (SQLException e) {
			error="Error in deleting Bank account detail :" + e;
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
	
}
