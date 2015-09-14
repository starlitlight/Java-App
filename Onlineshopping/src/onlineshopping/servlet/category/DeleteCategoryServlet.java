package onlineshopping.servlet.category;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlineshopping.dao.categoryDAO;

public class DeleteCategoryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		categoryDAO categorydao = new categoryDAO();
		
		String msg = "Failed";
		if (categorydao.delete(categoryId)) {
			msg = "Successful";
		}
		//提示消息
		request.setAttribute("msg", "The customer can not be uesd（DELETE）" + msg);
		//返回路径
		request.setAttribute("returnPath", "/FindAllCustomerServlet");
		
		request.getRequestDispatcher("/bootstrap/admin.jsp").forward(request, response);
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
