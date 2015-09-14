package onlineshopping.servlet.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlineshopping.bean.Product;
import onlineshopping.dao.productDAO;




public class UpdateProductServlet extends HttpServlet {

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
		String productName = request.getParameter("productName");
		float price = Float.parseFloat(request.getParameter("price"));
		String context = request.getParameter("context");
		String image = request.getParameter("image");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String categoryName = request.getParameter("categoryName");
		
		
		Product products = new Product(productId, productName, price, context, image, quantity, categoryName);
		productDAO productdao = new productDAO();
		String msg = "FAILED";
		//String returnPath = "/FindCustomerByIdServlet?productId=" + productId;
		if (productdao.update(products)) {
			msg = "SUCCESSFUL";
			System.out.println(msg);
			request.setAttribute("product", products);
			request.getRequestDispatcher("/bootstrap/admin.jsp").forward(request, response);
		}
//		//提示消息
//		request.setAttribute("msg", "MODEFY THE CUSTOMER INFORMATION " + msg);
//		//返回路径
//		request.setAttribute("returnPath", returnPath);
//		request.getRequestDispatcher("/background/message.jsp").forward(request, response);
		
		
	}

}
