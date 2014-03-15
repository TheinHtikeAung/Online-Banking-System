package sg.com.issbank.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import sg.com.issbank.dao.BankBranchDao;

import sg.com.issbank.dto.BankBranch;
import sg.com.issbank.dto.Customer;
import sg.com.issbank.util.Kitool;


public class BankBranchDaoImpl implements BankBranchDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	
	
	@Override
	public ArrayList<BankBranch> getAllBankBranch() {
		// TODO Auto-generated method stub
		ArrayList<BankBranch> bball=new ArrayList<BankBranch>();
		
		conn=MySQL.getConnection();
		String sql="select * from bankbranch;";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				BankBranch bb=new BankBranch(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				bball.add(bb);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MySQL.closeResource(conn, pstmt, rs);
		}
		
		
		return bball;
	}

	Connection connection = null;
	Statement statement = null;
	PreparedStatement ps=null;
	
	String query,error;
	
	@Override
	public ArrayList<BankBranch> getBankbranch() {
		
		ArrayList<BankBranch> bankbranches=new ArrayList<BankBranch>();
		query="select * from bankbranch";
		
		connection=MySQL.getConnection();
		
		try{
			statement = connection.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing retrieve: " + query);
			rs = statement.executeQuery(query);
			
			while (rs.next()) {
				BankBranch bb=new BankBranch(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				bankbranches.add(bb);
			}
			
		}catch(SQLException e){
			error="Error in Retrieve :"+e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE,error);
		}finally{
			close();
		}
		
		return bankbranches;
	}

	@Override
	public void insertBankBranch(BankBranch bb) {
		connection=MySQL.getConnection();
		query="insert into bankbranch values (?,?,?,?)";
		
		try {
			connection.setAutoCommit(false);
			
			ps=connection.prepareStatement(query);
			
			ps.setInt(1, bb.getBBID());
			ps.setString(2, bb.getLocation());
			ps.setString(3,bb.getName());
			ps.setString(4, bb.getDescription());
			
			ps.executeUpdate();
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing insert: " + query);
			
			connection.commit();
			
		} catch (SQLException e) {
			error="Error in Insert Bank Branch :" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		}finally{
			close();
		}
		
	}

	@Override
	public void updateBankBranch(BankBranch bb) {
		connection=MySQL.getConnection();
		query="update bankbranch SET location=?, name=?, description=? where BBID=?";
		
		try {
			connection.setAutoCommit(false);
			
			ps=connection.prepareStatement(query);
			
			ps.setInt(4, bb.getBBID());
			ps.setString(1, bb.getLocation());
			ps.setString(2,bb.getName());
			ps.setString(3, bb.getDescription());		
			
			ps.executeUpdate();
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing update: " + query);
			
			connection.commit();
			
		} catch (SQLException e) {
			error="Error in Update Customer :" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		}finally{
			close();
		}
	}
	
	public BankBranch findBranch(String BBID){
		BankBranch bb=new BankBranch();
		query="select * from bankbranch where BBID='"+BBID+"'";
		
		connection=MySQL.getConnection();
		
		try{
			statement = connection.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing retrieve: " + query);
			rs = statement.executeQuery(query);
			
			while (rs.next()) {
				bb=new BankBranch(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			
		}catch(SQLException e){
			error="Error in Retrieve :"+e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE,error);
		}finally{
			close();
		}
		
		return bb;
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
