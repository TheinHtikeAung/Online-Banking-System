package sg.com.issbank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sg.com.issbank.biz.PreferenceManager;
import sg.com.issbank.dao.mysql.CustomerDaoImpl;
import sg.com.issbank.dto.Customer;

/**
 * Servlet implementation class updateAddress
 */
@WebServlet("/updateAddress")
public class updateAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		
		Customer customer=(Customer) session.getAttribute("loginuser");
		
		PreferenceManager mgr=new PreferenceManager();
		
		mgr.updateAddress(customer.getNric(),request.getParameter("address"));
		request.setAttribute("success", "Your address is successfully updated");
		
		session.setAttribute("loginuser",new CustomerDaoImpl().findCustomer(customer.getNric()));
		
		request.getRequestDispatcher("pages/client/successMessage.jsp").forward(request, response);
	}

}
