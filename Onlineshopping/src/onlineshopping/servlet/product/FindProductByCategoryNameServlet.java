package onlineshopping.servlet.product;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlineshopping.bean.Product;
import onlineshopping.dao.productDAO;



@SuppressWarnings("serial")
public class FindProductByCategoryNameServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cname = request.getParameter("categoryName");
		productDAO productdao = new productDAO();
		List<Product> products = productdao.findByCategoryName(cname);
		request.setAttribute("product", products);
		request.getRequestDispatcher("/bootstrap/productList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
