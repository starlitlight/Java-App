package onlineshopping.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlineshopping.bean.User;
import onlineshopping.dao.userDAO;


public class UpdateUserServlet extends HttpServlet {

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
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println(password);
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		
		User user = new User(userId, name, password, email, address);
		userDAO userdao = new userDAO();
		
		String msg = "FAILED";
		//String returnPath = "/FindCustomerByIdServlet?productId=" + productId;
		if (userdao.update(user)) {
			msg = "SUCCESSFUL";
			System.out.println(msg);
			request.getRequestDispatcher("/bootstrap/index.jsp").forward(request, response);
		}
//		//提示消息
//		request.setAttribute("msg", "MODEFY THE CUSTOMER INFORMATION " + msg);
//		//返回路径
//		request.setAttribute("returnPath", returnPath);
//		request.getRequestDispatcher("/background/message.jsp").forward(request, response);
		
		
	}

}
