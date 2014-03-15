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

import sg.com.issbank.biz.AccountManager;
import sg.com.issbank.biz.CustomerManager;
import sg.com.issbank.dao.mysql.CustomerDaoImpl;
import sg.com.issbank.dao.mysql.MySQL;
import sg.com.issbank.dto.BankAccountDetail;
import sg.com.issbank.dto.CheckingAccount;
import sg.com.issbank.dto.Customer;
import sg.com.issbank.dto.SavingsAccount;
import sg.com.issbank.dto.Transaction;
import sg.com.issbank.util.Kitool;

@WebServlet("/transferConfirmController")
public class TransferConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public TransferConfirmController() {
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
		// 
		/*String fromAcc = request.getParameter("fromAcc");*/
		String fromAcc=(String) session.getAttribute("accountId");
		String toAcc = request.getParameter("toAcc");
		String amount = request.getParameter("amount");
		String accountType=request.getParameter("accountType111");
		
		// TODO: 
		
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		

		try {
			
			//sub checking account 
			if (accountType.equals("Checking Account")){
				
				/*customerDaoImpl.subCheckingAccountAmount(Double.valueOf(amount),fromAcc);*/
				customerDaoImpl.subAmount(Double.valueOf(amount),fromAcc);
				customerDaoImpl.addAmount((Double.valueOf(amount)),toAcc);
				
			}
			//sub saving account
			else if(accountType.equals("Saving Account")){
				
				customerDaoImpl.subAmount(Double.valueOf(amount),fromAcc);
				customerDaoImpl.addAmount(Double.valueOf(amount),toAcc);
				
			}else{
				path="/test.jsp";
			}
			
			AccountManager mgr = new AccountManager(); 
			Transaction trans = new Transaction(0,  fromAcc, "Fund Transfer", Double.valueOf(amount), toAcc , Kitool.currentTimeStamp());
			mgr.insertTransaction(trans);
				
			// add money to  toAcc
			
			request.setAttribute("success", "Successfully transfer");
			path="/pages/client/successMessage.jsp";

		} catch (SQLException e) {
			request.setAttribute("message", "error");
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
