package onlineshopping.servlet.category;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlineshopping.bean.Category;
import onlineshopping.dao.categoryDAO;



public class FindAllCategorysServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		categoryDAO categorydao = new categoryDAO();
		List<Category> categorys = categorydao.findAll();
		request.setAttribute("categorys", categorys);
		request.getRequestDispatcher("/bootstrap/index.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
