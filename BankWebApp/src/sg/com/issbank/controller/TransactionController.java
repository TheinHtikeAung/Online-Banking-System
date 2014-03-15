package sg.com.issbank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sg.com.issbank.biz.TransactionManager;
import sg.com.issbank.dto.Transaction;

/**
 * Servlet implementation class TransactionController
 */
@WebServlet("/trans")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    ArrayList<Transaction> fullTransList=null;
    ArrayList<Transaction> transList=null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session=request.getSession(true);
		String accountId=(String) session.getAttribute("accountId");
		
		/*String accId=request.getParameter("AccID");*/
		TransactionManager mgr=new TransactionManager();
		fullTransList=mgr.getAllTransactions(accountId);
		request.setAttribute("FullTransList", fullTransList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/client/transactiondetails.jsp");
		dispatcher.forward(request, response);	
	
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session=request.getSession(true);
		
		TransactionManager mgr=new TransactionManager();
		String fromDate=request.getParameter("FromDate");
		String toDate=request.getParameter("ToDate");
		String accountId=(String) session.getAttribute("accountId");
		String errorMsg="Please enter the date..";
		if(fromDate!=null && fromDate!="" && toDate!=null && toDate!=""){
			transList = mgr.getTransaction(fromDate,toDate,accountId);
			request.setAttribute("FullTransList", transList);
		}
		else{
			
			request.setAttribute("FullTransList", fullTransList);
			
			String accId=request.getParameter("AccID");
			fullTransList=mgr.getAllTransactions(accId);
			request.setAttribute("error", errorMsg);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/client/transactiondetails.jsp");
		dispatcher.forward(request, response);	
	
	}
	
	/*protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		TransactionManager mgr=new TransactionManager();
//		fullTransList=mgr.getAllTransactions(accId);
//		request.setAttribute("FullTransList", fullTransList);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/client/transactiondetails.jsp");
//		dispatcher.forward(request, response);	
		String fromDate=request.getParameter("FromDate");
		String toDate=request.getParameter("ToDate");
		String errorMsg="Please enter the date..";
//		System.out.println(fromDate+","+toDate);
		
//		TransactionManager mgr=new TransactionManager();
		if(fromDate!=null && fromDate!="" && toDate!=null && toDate!=""){
			transList = mgr.getTransaction(fromDate,
					toDate);
			request.setAttribute("FullTransList", transList);
		}
		else{
			request.setAttribute("error", errorMsg);
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/client/transactiondetails.jsp");
		dispatcher.forward(request, response);	
	
	}*/
	
	
	
}
