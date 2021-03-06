package onlineshopping.utli;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AuthFilter implements Filter {

	public void destroy() {
		System.out.println("authfilter destroy");
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// System.out.println("authfilter dofilter");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession(false);

		if (session == null || (String) session.getAttribute("user") == null
				|| !((String) session.getAttribute("user")).equals("user")) {
			System.out.println(request.getContextPath() + "/bootstrap/index.jsp");
			response.sendRedirect(request.getContextPath() + "/bootstrap/index.jsp");
			return;
		}
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig config) throws ServletException {
		System.out.println("authfilter init");
	}


}