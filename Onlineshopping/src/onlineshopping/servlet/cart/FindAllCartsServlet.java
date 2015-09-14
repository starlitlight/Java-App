package onlineshopping.servlet.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlineshopping.bean.Cart;
import onlineshopping.dao.cartDAO;



public class FindAllCartsServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cartDAO cartdao = new cartDAO();
		List<Cart> carts = cartdao.findAll();
		request.setAttribute("carts", carts);
		request.getRequestDispatcher("/bootstrap/admin.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
