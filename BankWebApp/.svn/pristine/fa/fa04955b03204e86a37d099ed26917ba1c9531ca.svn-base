package sg.com.issbank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sg.com.issbank.biz.AccountManager;
import sg.com.issbank.dao.BankAccountDao;
import sg.com.issbank.dao.DaoFactory;
import sg.com.issbank.dao.TransactionDao;
import sg.com.issbank.dto.Transaction;
import sg.com.issbank.exception.BelowMinimumBalanceException;
import sg.com.issbank.exception.OverDraftLimitExceededException;
import sg.com.issbank.util.Kitool;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(description = "For Web App FrontEnd", urlPatterns = { "/Testing" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String folderPath="/pages/client/";
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		// TODO: Transfer Algorithm
		/*Transfer Test Code*/
			AccountManager mgr=new AccountManager();
		
			String accountId="1111"; //will get from session
			String transferId="2222";
			String accountType="Checking Account";  //will get from parameter
			double transferAmt=Double.parseDouble(request.getParameter("amount"));
			int PIN = Integer.parseInt(request.getParameter("pin"));
			
			boolean result=false;
			
			if (mgr.checkcustomer(accountId, PIN)) {
			
				if(accountType.equalsIgnoreCase("Checking Account")){
					
					if(transferAmt<=mgr.getMaximumBalanceForCheckingAccount(accountId)){
						
						result=true;
						
					}else{
						
						request.setAttribute("error", "Transfer amount is over account overdraft limit !");
						throw new OverDraftLimitExceededException("Transfer amount is over account overdraft limit !");
					}
					
				}else{
					
					if(transferAmt<=mgr.getMaximumBalanceForSavingAccount(accountId)){
						
						result=true;
						
					}else{
						
						request.setAttribute("error", "Transfer amount is minimum balance limit !");
						throw new BelowMinimumBalanceException("Transfer amount is minimum balance limit !");
					}
					
				}
				
				if(result){
					mgr.withdrawProcess(accountId,transferAmt);
					mgr.deposit(transferId,transferAmt);
					
					Transaction trans=new Transaction(0,accountId,"Account Transfer",transferAmt,transferId,Kitool.currentTimeStamp());
					mgr.insertTransaction(trans);
					
					request.setAttribute("success", "Account transfer is successful.");
					RequestDispatcher rd = request.getRequestDispatcher("pages/client/success.jsp");
					rd.forward(request,response);
				}
			}
		}
		/*Transfer Test Code*/
			
		
		/*forward(userPath, request, response);*/
	
	
	private void forward(String userPath,HttpServletRequest request, HttpServletResponse response){
		try {
            String url=folderPath+userPath; 
			
			request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	private String getURL(String url){
		String[] requestURL=url.split("/");
		
		if(requestURL.length==3){ 
			return requestURL[2];
		}
		else{ 
			return requestURL[3];
		}
	}
}
