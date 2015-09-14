package onlineshopping.servlet.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlineshopping.bean.Product;
import onlineshopping.bean.User;
import onlineshopping.dao.productDAO;
import onlineshopping.dao.userDAO;


public class SaveProductServelt extends HttpServlet {

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
		
		String productName = request.getParameter("productName");
		int price = Integer.parseInt(request.getParameter("price"));
		String context = request.getParameter("context");
		String image = request.getParameter("image");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String categoryName = request.getParameter("categoryName");
		
		Product product= new Product(productName, price, context, image, quantity, categoryName);
		

		productDAO productdao = new productDAO();
		
		String msg = "FAILED";
		String returnPath = "/bootstrap/addProduct.jsp";
		if (productdao.save(product)) {
			//msg = "SUCCESSFUL";
			//returnPath = "/FindAllCustomerServlet";
			System.out.println("save succeed");
		}
		//提示消息
		request.setAttribute("msg", "ADD NEW PRODUCT'S INFORMATION " + msg);
		//返回路径
		request.setAttribute("product", product);
		request.getRequestDispatcher("/bootstrap/admin.jsp").forward(request, response);
		
		
	}

}
