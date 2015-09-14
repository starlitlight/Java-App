package onlineshopping.servlet.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlineshopping.bean.Cart;
import onlineshopping.bean.User;
import onlineshopping.dao.cartDAO;


public class SaveCartServlet extends HttpServlet {

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
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		
		Cart cart= new Cart(productId, amount, userId);

		cartDAO cartdao = new cartDAO();
		
		String msg = "FAILED";
		String returnPath = "/bootstrap/saveCustomer.jsp";
		if (cartdao.save(cart)) {
			//msg = "SUCCESSFUL";
			//returnPath = "/FindAllCustomerServlet";
			System.out.println("save succeed");
		}
		//提示消息
		request.setAttribute("msg", "ADD NEW PRODUCT'S INFORMATION " + msg);
		//返回路径
		request.setAttribute("cart", cart);
		request.getRequestDispatcher("/bootstrap/shoppingCart.jsp").forward(request, response);
		
		
	}

}
