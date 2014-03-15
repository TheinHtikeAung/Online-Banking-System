package sg.com.issbank.biz;

import java.sql.SQLException;
import java.util.ArrayList;

import sg.com.issbank.dao.DaoFactory;
import sg.com.issbank.dto.BankBranch;

public class BankBranchManager {
	
	public ArrayList<BankBranch> findAllBankBranch() {
		ArrayList<BankBranch> allBb=new ArrayList<BankBranch>();
		try {
			allBb=DaoFactory.getBankBranchDao().getAllBankBranch();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return allBb;
		
	}

}
