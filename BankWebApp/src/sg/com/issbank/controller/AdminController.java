package sg.com.issbank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sg.com.issbank.biz.AdminManager;
import sg.com.issbank.dto.BankAccount;
import sg.com.issbank.dto.BankBranch;
import sg.com.issbank.dto.Customer;
import sg.com.issbank.util.Kitool;

/**
 * Servlet implementation class AdminController
 */
@WebServlet(description = "For Web App Backend", urlPatterns = { "/admin/*" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String folderPath="/pages/admin/";
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userPath = getURL(request.getRequestURI().toString());
		AdminManager mgr=new AdminManager();
		
		PrintWriter out=response.getWriter();
		out.println(request.getParameter("d"));
		
		out.println(userPath);
		
		if (userPath.equals("customerMaintenance") || userPath.equals("admin")) {
			
			request.setAttribute("customers", mgr.getCustomers());
			userPath="customerMaintenance.jsp";
		
		}else if (userPath.equals("bankbranchMaintenance")){
			
			request.setAttribute("bankbranches", mgr.getBankBranches());
			userPath="bankbranchMaintenance.jsp";
			
		}else if (userPath.equals("accountMaintenance")){
			
			session = request.getSession(true);  
			session.setAttribute("customer", mgr.findCustomer(request.getParameter("nric")));
			
			request.setAttribute("bankaccounts", mgr.getBankAccByCustomer(request.getParameter("nric")));
			userPath="accountMaintenance.jsp";
		}
		
		
		/*else{
			request.setAttribute("customers", mgr.getCustomers());
			userPath="customerMaintenance.jsp";
		}*/
		
		forward(userPath, request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userPath = getURL(request.getRequestURI().toString());
		AdminManager mgr=new AdminManager();

		PrintWriter out=response.getWriter();
		out.println(request.getParameter("d"));
		
		out.println(userPath);
		
		if (userPath.equals("customerProcess")) {
			
			Customer c=new Customer(request.getParameter("nric"),
					request.getParameter("name"), request.getParameter("address"), 
					Kitool.parseDate(request.getParameter("dateOfBirth")), 
					request.getParameter("nationality"), 
					request.getParameter("gender"),request.getParameter("userid"), 
					request.getParameter("password"),
					Kitool.parseDate(request.getParameter("dateOfJoining")));
			
			String insert=request.getParameter("insert");
			
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Customer Insert Flag: "+ insert);
			
			if(insert.equalsIgnoreCase("true")){
				mgr.insertCustomer(c);
			}else{
				mgr.updateCustomer(c);
			}
			
			request.setAttribute("customers", mgr.getCustomers());
			userPath="customerMaintenance.jsp";
			
		}else if (userPath.equals("bankbranchProcess")){
			
			BankBranch bb=new BankBranch(Integer.parseInt(request.getParameter("BBID")), request.getParameter("location"), 
										request.getParameter("name"), request.getParameter("description"));
			
			String insert=request.getParameter("insert");
			
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Bank branch Insert Flag: "+ insert);
			
			if(insert.equalsIgnoreCase("true")){
				mgr.insertBankBranch(bb);
			}else{
				mgr.updateBankBranch(bb);
			}
			
			request.setAttribute("bankbranches", mgr.getBankBranches());
			userPath="bankbranchMaintenance.jsp";
			
		}else if (userPath.equals("bankaccountProcess") && request.getParameter("action").equals("submit")){
			
			String accType=request.getParameter("accountType");
			String accountId=request.getParameter("accountId");
			String BBID=request.getParameter("BBID");
			
			BankAccount acc=new BankAccount(request.getParameter("accountId"),Integer.parseInt(request.getParameter("PIN")),
					BBID, accType, new BigDecimal(request.getParameter("balance")));
			
			String insert=request.getParameter("insert");
			
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Bank Account Insert Flag: "+ insert);
			if(insert.equalsIgnoreCase("true")){
				mgr.insertBankAccount(acc);
				
				session = request.getSession(true);  
				Customer c=(Customer)session.getAttribute("customer");
				mgr.insertBankAccountDetail(c.getNric(), acc.getAccountId());
				
			}else{
				mgr.updateBankAccount(acc);
				
			}
			
			/*1. Delete all acount 2.Create related one*/
			mgr.deleteRelatedAcc(acc.getAccountId());
			if(accType.equalsIgnoreCase("Checking Account")){
				mgr.insertCheckingAcc(acc.getAccountId(),Double.parseDouble(request.getParameter("overDraftAmount")));
			}else{
				mgr.insertSavingAcc(acc.getAccountId(),Double.parseDouble(request.getParameter("minimumBalance")));
			}
			
			String accMgr=request.getParameter("accountManager");
			if(accMgr!=null && accMgr.equals("true")){  //checking request come from Bank account search page
				
				request.setAttribute("account", mgr.findAccountById(accountId));
				request.setAttribute("branch", mgr.findByBBID(BBID));
				request.setAttribute("customers", mgr.findCustomerByAccountId(accountId));
				request.setAttribute("accountId", accountId);
				
				userPath="accountManager.jsp";
				
			}else{  // then must be from Customer Account set up page
				
				session = request.getSession(true);  
				Customer c=(Customer)session.getAttribute("customer");
				request.setAttribute("bankaccounts", mgr.getBankAccByCustomer(c.getNric())); 
				userPath="accountMaintenance.jsp";
			}
			
			
		}else if (userPath.equals("jointProcess") && request.getParameter("action").equals("Joint Account")){
			
			session = request.getSession(true);  
			Customer c=(Customer)session.getAttribute("customer");
			mgr.insertBankAccountDetail(c.getNric(),request.getParameter("accountId"));
			
			request.setAttribute("bankaccounts", mgr.getBankAccByCustomer(c.getNric())); 
			userPath="accountMaintenance.jsp";
			
		}else if (userPath.equals("bankaccountProcess") && request.getParameter("action").equals("disjoint")){
			
			session = request.getSession(true); 
			Customer c=(Customer)session.getAttribute("customer");
			mgr.deleteBankAccountDetail(c.getNric(),request.getParameter("accountId"));
			
			request.setAttribute("bankaccounts", mgr.getBankAccByCustomer(c.getNric())); 
			userPath="accountMaintenance.jsp";
			
		}else if (userPath.equals("jointProcess") && request.getParameter("action").equals("check")){
			
			BankAccount account= mgr.findAccountById(request.getParameter("accountId"));
			BankBranch bb=mgr.findByBBID(account.getBBID());
			
			request.setAttribute("account", account);
			request.setAttribute("bb", bb);
			
			try{
				account.getAccountId().equals(null);
			}catch(NullPointerException exception){
				request.setAttribute("error", "Bank Account ID is wrong");
			}
			
			userPath="accountJoint.jsp";
			
		}else if (userPath.equals("transactionProcess")){
			
			String accountId=(String)request.getParameter("accountId");
			
			request.setAttribute("accountId", accountId);
			request.setAttribute("transactions", mgr.findTransactionByAccountId(accountId));
			
			userPath="transactionHistory.jsp";
			
		}else if (userPath.equals("searchCustomer")){	
			
			String keyword=(String)request.getParameter("keyword");
			request.setAttribute("customers", mgr.findCustomers(keyword));
			request.setAttribute("keyword", keyword);
			
			userPath="customerMaintenance.jsp";
			
		}else if (userPath.equals("searchBankAcc")){
			
			String accountId=(String)request.getParameter("accountId");
			
			BankAccount account=mgr.findAccountById(accountId);
			request.setAttribute("account", account);
			request.setAttribute("branch", mgr.findByBBID(account.getBBID()));
			request.setAttribute("customers", mgr.findCustomerByAccountId(accountId));
			request.setAttribute("accountId", accountId);
			
			userPath="accountManager.jsp";
		}
		
		
		
		
		forward(userPath, request, response);
	}
	
	
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
