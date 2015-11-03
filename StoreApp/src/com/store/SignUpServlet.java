package com.store;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer details = new Customer();
        details.setCustomerName((request.getParameter("CustomerName")));
        details.setCustomerPassword((request.getParameter("CustomerPassword")));
        details.setAddress((request.getParameter("Address")));
        details.setEmailID((request.getParameter("EmailID")));
        details.setContactNumber(Integer.parseInt((request.getParameter("ContactNumber"))));
       // details.setCustomerPassword((request.getParameter("CustomerPassword")));
        details = StoreDAO.insert(details);
        
        if (details.isValid())
        {
   	        
             HttpSession session = request.getSession(true);	    
             session.setAttribute("currentSessionUser",details);           
             //response.sendRedirect("Login.jsp"); //logged-in page
             
             PrintWriter out = response.getWriter();  
             response.setContentType("text/html");  
             out.println("<script type=\"text/javascript\">");  
             out.println("if (window.confirm('Sign Up Successfull!')) window.location='/StoreApp/Main.jsp';"); 
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
