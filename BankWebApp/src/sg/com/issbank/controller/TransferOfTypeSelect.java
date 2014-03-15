package sg.com.issbank.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sg.com.issbank.biz.BankBranchManager;
import sg.com.issbank.dto.BankBranch;

/**
 * Servlet implementation class TransferOfTypeSelect
 */
@WebServlet("/transferOfTypeSelect")
public class TransferOfTypeSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferOfTypeSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forwardurl="";
		ArrayList<BankBranch> bball=new ArrayList<BankBranch>();
		bball=new BankBranchManager().findAllBankBranch();
		request.getSession().setAttribute("bankBranchName", bball);
		forwardurl="/pages/client/TransferInfo.jsp";
		request.getRequestDispatcher(forwardurl).forward(request, response);
	}

}
