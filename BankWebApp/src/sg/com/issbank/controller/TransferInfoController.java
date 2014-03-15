package sg.com.issbank.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;

import sg.com.issbank.biz.BankBranchManager;
import sg.com.issbank.biz.CustomerManager;
import sg.com.issbank.dao.mysql.CustomerDaoImpl;
import sg.com.issbank.dao.mysql.MySQL;
import sg.com.issbank.dto.BankAccountDetail;
import sg.com.issbank.dto.BankBranch;
import sg.com.issbank.dto.CheckingAccount;
import sg.com.issbank.dto.Customer;
import sg.com.issbank.dto.SavingsAccount;
import sg.com.issbank.exception.BelowMinimumBalanceException;
import sg.com.issbank.exception.OverDraftLimitExceededException;

@WebServlet("/transferInfoController")
public class TransferInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public TransferInfoController() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		
		String path = "";
		// get data from page
		String accountType = request.getParameter("accountType111");
		request.setAttribute("accountType111", accountType);
		
		System.out.println("accountType   :   "+accountType);
		String branch = request.getParameter("branch");
		System.out.println("branch   :   "+branch);

		String name = request.getParameter("name");
		/*String fromAcc = request.getParameter("fromAcc");*/
		String toAcc = request.getParameter("toAcc");

		String email = request.getParameter("email");
		Double amount = Double.valueOf(request.getParameter("amount"));

		System.out.println("*************99999999*************");
		// TODO:
		String accountId = (String) session.getAttribute("accountId");

		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();

		// TODO: check.

		ArrayList<BankAccountDetail> aidlist = new ArrayList<BankAccountDetail>();
		ArrayList<CheckingAccount> chAList = new ArrayList<CheckingAccount>();
		ArrayList<SavingsAccount> sAList = new ArrayList<SavingsAccount>();

		try {
			//
			aidlist = customerDaoImpl.accountNoIsExist(toAcc);
			System.out.println("size:   "+aidlist.size());

			//
			if (aidlist == null || aidlist.size() == 0) {
				System.out.println(toAcc);
				System.out.println("Account Not Exist**************************************");
				// ******throw execption or jump to error.jsp*************
				request.setAttribute("error", "Account Number is wrong");
				path="/pages/client/errorMessage.jsp";
				
			} else {
				// TODO:
				System.out.println("**********find account**11111********");
				System.out.println(accountType);
				if ("Checking Account".equals(accountType)) {
					chAList = customerDaoImpl.getOverDraftAmount(accountId);

					//
					CheckingAccount checkingAccount = chAList.get(0);

		 		System.out.println("**********find account**222********");
					if (checkingAccount.getOverDraftAmount()
							- Double.valueOf(amount)+customerDaoImpl
							.getBalanceByAccountID(accountId) >= 0) {
						// TODO:
						path = "/pages/client/ConfirmationTransfer.jsp";
					} else {
						System.out.println("overDraftAmount is not enough  ");
						
						request.setAttribute("error","Your transfer amount exceed than Over draft amount limit.");
						throw new OverDraftLimitExceededException();
					}
				}

				// TODO:
				if ("Saving Account".equals(accountType)) {
					sAList = customerDaoImpl.getSavingAccount(accountId);
					SavingsAccount savingsAccount = sAList.get(0);
					double account = customerDaoImpl
							.getBalanceByAccountID(accountId);
					// TODO:获取登录账户的余额应该在登录的时候就存入session

					/*Double d=(account - Double.valueOf(amount)) - savingsAccount.getB;*/
					
					//Double.parseDouble(savingsAccount.getBalance().toString())
					
					if ((account - Double.valueOf(amount)) < savingsAccount.getMinimumBalance()) {
						System.out.println("insufficient balance");
						
						request.setAttribute("error","Transfer amount exceed than minimum balance.");
						throw new BelowMinimumBalanceException();
						
					} else {
						// TODO:jump to confirmation page
						path = "/pages/client/ConfirmationTransfer.jsp";
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
