package sg.com.issbank.dao;

import java.sql.SQLException;

import sg.com.issbank.dto.SavingsAccount;

public interface SavingsAccountDao {
	public void deleteSavingAcc(String acc);
	
	public SavingsAccount findSavingAccount(String acc);

	public void insertSavingAcc(String accountId, double minimumBalance);

	public SavingsAccount getminimumBalancebyAccID(String accountId) throws SQLException;
	public void openconnection() throws SQLException;
	public void closeconnection() throws SQLException;
}
