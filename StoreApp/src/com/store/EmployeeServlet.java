package com.store;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = new Employee();
		String first = request.getParameter("FirstName").toString();
		String pass = request.getParameter("Password").toString();
		emp.setFirstName((request.getParameter("FirstName")));
		emp.setPassword((request.getParameter("Password")));
		//String des = request.getParameter("Destination").toString();
		
		emp = StoreDAO.empLogin(emp);
		String Designation = StoreDAO.getDesignation(first,pass);
        System.out.println("Destintaion"+Designation);
        if (emp.isValid())
        {
        	 HttpSession session = request.getSession(true);
   	        if(Designation.equals("SalesEmployee")){
            	    
             session.setAttribute("currentSessionUser",emp); 
             response.sendRedirect("SalesEmployee.jsp"); //logged-in page  
   	        }
   	        else if(Designation.equals("InventoryManager")){
   	        	response.sendRedirect("listInventory.jsp");
   	        }
   	     else if(Designation.equals("Manager")){
   	    	 
	        	response.sendRedirect("Manager.jsp");
	        }
   	     else{ session.setAttribute("currentSessionUser",emp); 
         response.sendRedirect("EmployeeLogged.jsp"); 
   	    	 System.out.println("Wrong Destination");
   	     }
        }
   	        
        else 
             response.sendRedirect("invalidLogin.jsp"); //error page 
       // request.setAttribute("details", details);
        //getServletContext().getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
	//	System.out.println("HAEL");
    

    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
