package onlineshopping.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlineshopping.bean.User;
import onlineshopping.dao.userDAO;

public class LoginServlet extends HttpServlet {

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

		String username = request.getParameter("username");
		System.out.println(username);
		String password = request.getParameter("password");
		
		userDAO userdao = new userDAO();
		List<User> users = userdao.findAll();
		
		String msg = "FAILED";
		String returnPath = "/bootstrap/error.jsp";

		for (User user : users) {
			System.out.println(user.getName());
			if (username.equalsIgnoreCase("admin")
					&& password.equalsIgnoreCase("admin")) {
				returnPath = "/bootstrap/admin.jsp";			
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher(returnPath).forward(request,
						response);
				System.out.println("admin login succeed!!!");
			} else {
				if (user.getName().equals(username)
						&& user.getPassword().equals(password)) {
					returnPath = "/bootstrap/index.jsp";
					request.getSession().setAttribute("user", user);
					request.getRequestDispatcher(returnPath).forward(request,
							response);
					System.out.println("user login succeed!!!");
					return;
				}
			}

		}

	}

}
