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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/EmployeeUpdate")
public class EmployeeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.println("ACTION IS"+action);
		
		EmployeeInsert details = new EmployeeInsert();
        details.setEmployeeId((request.getParameter("EmployeeId")));
        details.setFirstName((request.getParameter("FirstName")));
        details.setMiddleName((request.getParameter("MiddleName")));
        details.setLastName((request.getParameter("LastName")));
        details.setPassword((request.getParameter("Password")));
        details.setSSN((request.getParameter("SSN")));
        try {
            Date edate = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("DOB"));//CheckThis
            System.out.println("rrrrrrrrrrr"+ edate);
            details.setDOB(edate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Date JoiningDate = (Date) new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("JoiningDate"));//CheckThis
            System.out.println("rrrrrrrrrrr"+ JoiningDate);
            details.setJoiningDate(JoiningDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        details.setDesignation((request.getParameter("Designation")));
        details.setSalary(Integer.parseInt((request.getParameter("Salary"))));
        details.setContactNum(Long.parseLong((request.getParameter("ContactNum"))));
        details.setEmailId((request.getParameter("EmailId")));
        details.setAddress((request.getParameter("Address")));
        // details.setCustomerPassword((request.getParameter("CustomerPassword")));
        details = StoreDAO.updateEmployee(details);
        
        if (details.isValid())
        {
   	        
            // HttpSession session = request.getSession(true);	    
            // session.setAttribute("currentSessionUser",details); 
            // response.sendRedirect("userLogged.jsp"); //logged-in page 
        	PrintWriter out = response.getWriter();  
            response.setContentType("text/html");  
            out.println("<script type=\"text/javascript\">");  
            out.println("if (window.confirm('updated employee details')) window.location='/StoreApp/Manager.jsp';"); 
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
