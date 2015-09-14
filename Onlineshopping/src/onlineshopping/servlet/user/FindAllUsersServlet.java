package onlineshopping.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlineshopping.bean.User;
import onlineshopping.dao.userDAO;


public class FindAllUsersServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		userDAO  customerdao = new userDAO();
		List<User> customers = customerdao.findAll();
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("/background/customerList.jsp").forward(request, response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
		}
}


