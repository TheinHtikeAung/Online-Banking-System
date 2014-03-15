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
import sg.com.issbank.exception.OverDraftLimitExceededException;

import javax.servlet.RequestDispatcher;

import sg.com.issbank.biz.CustomerManager;
import sg.com.issbank.dao.BankAccountDao;
import sg.com.issbank.dao.CustomerDao;
import sg.com.issbank.dao.mysql.BankAccountDaoImpl;
import sg.com.issbank.dao.mysql.CustomerDaoImpl;
import sg.com.issbank.dao.mysql.MySQL;
import sg.com.issbank.dto.BankAccountDetail;
import sg.com.issbank.dto.Customer;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	HttpSession session;
    
    /**
     * @see HttpServlet#HttpServlet()
     */


	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(true);
		String logout=request.getParameter("logout");
		String accountId=request.getParameter("accountId");
		
		if(logout!=null && logout.equalsIgnoreCase("true")){
			
			session.invalidate();
			
			response.sendRedirect("./");
		}else{
			
			session.setAttribute("accountId",accountId);
			response.sendRedirect("./balance");
			
		}
		
		
		/*throw new OverDraftLimitExceededException();*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = "";
		// boolean result = false;
		String name = request.getParameter("id");
		String password = request.getParameter("pwd");
		CustomerManager mgr = new CustomerManager();
		// PrintWriter out=response.getWriter();
		Customer c = new Customer();
		// System.out.println(c);
		System.out.println("************1111**************");
		c = mgr.getCustomerById(name, password);
		System.out.println("*************2222*************");
		System.out.println(c);
		ArrayList<BankAccountDetail> aidlist = new ArrayList<BankAccountDetail>();

		try {
			aidlist = new CustomerDaoImpl().getAccountDetailByCustomerID(c
					.getNric());
			System.out.println("aidlist.size()==" + aidlist.size());

			if (c.getUserid() != null && c.getPassword() != null
					&& aidlist.size() >= 2) {
				System.out.println("******>2******");
				path = "pages/client/Accountselect.jsp";
				System.out.println("******path******");
				request.getSession().setAttribute("aidlist", aidlist);
				request.getSession().setAttribute("c", c);
				
				/*Store in session*/
				CustomerDao customerDao=new CustomerDaoImpl();
				Customer customer=customerDao.getCustomersByIdPwd(c.getUserid(), c.getPassword());
				
				request.getSession().setAttribute("loginuser",customer);

			} else if (c.getUserid() != null && c.getPassword() != null
					&& aidlist.size() < 2) {
				
				path = "/balance";
				
				request.getSession().setAttribute("c", c);
				
				/*Store in session*/
				CustomerDao customerDao=new CustomerDaoImpl();
				BankAccountDao accountDao=new BankAccountDaoImpl();
				Customer customer=customerDao.getCustomersByIdPwd(c.getUserid(), c.getPassword());
				
				request.getSession().setAttribute("accountId",accountDao.findOneAccountByNRIC(customer.getNric()).getAccountId());
				request.getSession().setAttribute("loginuser",customer);

			} else {
				path = "/pages/client/login.jsp";
				request.setAttribute("message",
						"Invalid user name and password");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
