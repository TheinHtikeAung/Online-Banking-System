package sg.com.issbank.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sg.com.issbank.biz.AccountManager;
import sg.com.issbank.dto.BankAccount;
import sg.com.issbank.dto.Transaction;
import sg.com.issbank.exception.BelowMinimumBalanceException;
import sg.com.issbank.exception.OverDraftLimitExceededException;
import sg.com.issbank.util.Kitool;

/**
 * Servlet implementation class withdrawsuccess
 */
@WebServlet("/wsuccess")
public class Withdrawresult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Withdrawresult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		session=request.getSession();
		 
	/*	AccountManager mgr = new AccountManager();
		BankAccount bacc = new BankAccount();
		BigDecimal amount = new BigDecimal(request.getParameter("amount"));
		int PIN = Integer.parseInt(request.getParameter("pin"));
		String Id = request.getParameter("accountId");
		if (mgr.checkcustomer(Id, PIN)) {
			if (mgr.withdraw(Id, amount) > 0) {
				bacc = mgr.getBalance(Id);
				request.setAttribute("Bank", bacc);
				RequestDispatcher rd = request.getRequestDispatcher("pages/client/successful.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("error", "Withdraw amount exceed amount of withdrawal!");
				RequestDispatcher rd = request.getRequestDispatcher("pages/client/withdraw.jsp");
				rd.forward(request, response);
			}
		} else {
			request.setAttribute("error", "Wrong Pin Number!");
			RequestDispatcher rd = request.getRequestDispatcher("pages/client/errorMessage.jsp");
			rd.forward(request, response);
		}*/
		

		
		// TODO: Withdraw Algorithm
		/* Withdraw Test Code */
		AccountManager mgr = new AccountManager(); 

		String accountId = (String) session.getAttribute("accountId"); // will get from session
		String accountType = request.getParameter("accountType"); // will get from parameter
		int PIN=Integer.parseInt(request.getParameter("pin"));
		
		double withdrawAmt = Double.parseDouble(request.getParameter("amount"));

		boolean result = false;
		
		if(mgr.checkcustomer(accountId, PIN)){
			if (accountType.equalsIgnoreCase("Checking Account")) {
	
				if (withdrawAmt <= mgr.getMaximumBalanceForCheckingAccount(accountId)) {
	
					result = true;
	
				} else {
	
					request.setAttribute("error","Withdraw amount is over account overdraft limit !");
					throw new OverDraftLimitExceededException("Withdraw amount is over account overdraft limit !");
				}
	
			} else {
	
				if (withdrawAmt <= mgr.getMaximumBalanceForSavingAccount(accountId)) {
	
					result = true;
	
				} else {
	
					request.setAttribute("error","Withdraw amount is minimum balance limit !");
					throw new BelowMinimumBalanceException("Withdraw amount is minimum balance limit !");
				}
	
			}
	
			if (result) {
				mgr.withdrawProcess(accountId, withdrawAmt);
	
				Transaction trans = new Transaction(0, accountId, "Withdraw",withdrawAmt, "", Kitool.currentTimeStamp());
				mgr.insertTransaction(trans);
	
				request.setAttribute("Bank", mgr.findBankAcc(accountId));
				request.setAttribute("success", "Withdraw process is successful !");
				request.getRequestDispatcher("pages/client/successful.jsp").forward(request, response);
			}
		}else{
			
			request.setAttribute("error", "Wrong Pin Number!");
			request.getRequestDispatcher("pages/client/errorMessage.jsp").forward(request, response);
		}
		/* Withdraw Test Code */
	}

}
