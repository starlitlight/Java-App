package onlineshopping.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlineshopping.bean.User;
import onlineshopping.dao.userDAO;


public class DeleteUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		userDAO userdao = new userDAO();
		
		String msg = "FAILED";
		String returnPath = "/bootstrap/saveCustomer.jsp";
		if (userdao.delete(userId)) {
			//msg = "SUCCESSFUL";
			//returnPath = "/FindAllCustomerServlet";
			msg = "Successful";
		}
		//提示消息
		request.setAttribute("msg", "The user can not be uesd（DELETE） " + msg);
		//返回路径
		request.getRequestDispatcher("/bootstrap/admin.jsp").forward(request, response);
		
		
	}

}
