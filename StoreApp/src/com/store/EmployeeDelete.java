package com.store;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/EmployeeDelete")
public class EmployeeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("ACTION IS"+action);
		
		
	    String EmployeeId = request.getParameter("EmployeeId");
	    
	    
		
       // details.setCustomerPassword((request.getParameter("CustomerPassword")));
        String details = StoreDAO.deleteEmployee(EmployeeId);
        
        if (details.equals("deleted"))
        {
   	        
            // HttpSession session = request.getSession(true);	    
            // session.setAttribute("currentSessionUser",details); 
            // response.sendRedirect("userLogged.jsp"); //logged-in page 
        	PrintWriter out = response.getWriter();  
            response.setContentType("text/html");  
            out.println("<script type=\"text/javascript\">");  
            out.println("if (window.confirm('Deleted employee from database')) window.location='/StoreApp/Manager.jsp';"); 
           out.println("</script>");
        }
   	        
        else 
             response.sendRedirect("invalidLogin.jsp"); //error page 
       // request.setAttribute("details", details);
        //getServletContext().getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
		System.out.println("HAEL");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
