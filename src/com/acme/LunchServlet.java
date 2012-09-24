package com.acme;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LunchServlet
 */
public class LunchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String eventName;
	private Date occuresDate;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LunchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	    
	    Date now = new Date();
	    
	    HttpSession session = request.getSession();
	    String id = session.getId();
	    
	    Long minutes = (occuresDate.getTime() - now.getTime()) / 60000;
        response.getWriter().println("Árvíztűrő tükörfúrógép");
        
        response.getWriter().println("<h1>" + eventName + "</h1>");
        response.getWriter().println("<br/><div style=\"color:green; border: 2px solid pink\">");
        response.getWriter().println("Minutes left:" + minutes);
        response.getWriter().println("</div>");
        response.getWriter().println("<hr/>sesionid=" + id);
        
	}

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        eventName = getInitParameter("eventName");
        String occures = getInitParameter("occures");
        try {
            occuresDate = sdf.parse(occures);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
    }

}
