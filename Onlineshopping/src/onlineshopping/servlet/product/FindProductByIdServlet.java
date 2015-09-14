package onlineshopping.servlet.product;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlineshopping.bean.Product;
import onlineshopping.dao.productDAO;


@SuppressWarnings("serial")
public class FindProductByIdServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		int pid = Integer.parseInt(request.getParameter("productId"));
		productDAO productdao = new productDAO();
		Product product = productdao.findById(pid);
		request.setAttribute("product", product);
		request.getRequestDispatcher("/bootstrap/product.jsp").forward(request, response);
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
