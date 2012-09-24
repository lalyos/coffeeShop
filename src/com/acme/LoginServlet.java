package com.acme;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 * @param <V>
 */
public class LoginServlet<V> extends BaseServlet<V> {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		HttpSession session = request.getSession(true);
		session.setAttribute("username", username);
		
		getChoppingCart().put(username, new ShoppingCart());
		response.getWriter().println("You are logged in as: " + username);
		response.getWriter().println("<br/><a href='" + getServletContext().getContextPath()  + "'> home </a>");
		
	}

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        super.init(config);
        Map<String, ShoppingCart> shoppingCarts = new ConcurrentHashMap<String, ShoppingCart>();
        config.getServletContext().setAttribute("shoppingCarts", shoppingCarts);
    }


}
