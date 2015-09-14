package onlineshopping.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlineshopping.bean.User;
import onlineshopping.dao.userDAO;


public class SaveUserServlet extends HttpServlet {

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
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		User user= new User(name, password, email, address);

		userDAO userdao = new userDAO();
		
		String msg = "FAILED";
		String returnPath = "/bootstrap/saveCustomer.jsp";
		if (userdao.save(user)) {
			//msg = "SUCCESSFUL";
			//returnPath = "/FindAllCustomerServlet";
			System.out.println("save succeed");
		}
		//提示消息
		request.setAttribute("msg", "ADD NEW PRODUCT'S INFORMATION " + msg);
		//返回路径
		request.setAttribute("user", user);
		request.getRequestDispatcher("/bootstrap/index.jsp").forward(request, response);
		
		
	}

}
