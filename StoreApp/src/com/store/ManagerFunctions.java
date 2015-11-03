package com.store;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Date;
//import java.text.DateFormat;
//import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//import java.text.SimpleDateFormat;
import java.util.Date;


//import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/ManagerFunctions")
public class ManagerFunctions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerFunctions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeInsert details = new EmployeeInsert();
        details.setEmployeeId((request.getParameter("EmployeeId")));
        details.setFirstName((request.getParameter("FirstName")));
        details.setMiddleName((request.getParameter("MiddleName")));
        details.setLastName((request.getParameter("LastName")));
        details.setPassword((request.getParameter("Password")));
        details.setSSN((request.getParameter("SSN")));
        try {
            Date DOB = (Date) new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("DOB"));//CheckThis
            System.out.println("rrrrrrrrrrr"+ DOB);
            details.setDOB(DOB);
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
        details = StoreDAO.insertEmployee(details);
        
        if (details.isValid())
        {
   	        
            // HttpSession session = request.getSession(true);	    
            // session.setAttribute("currentSessionUser",details); 
            // response.sendRedirect("userLogged.jsp"); //logged-in page 
        	PrintWriter out = response.getWriter();  
            response.setContentType("text/html");  
            out.println("<script type=\"text/javascript\">");  
            out.println("if (window.confirm('Added the employee into database')) window.location='/StoreApp/Manager.jsp';"); 
           out.println("</script>");
             
        }
   	        
        else 
             response.sendRedirect("invalidLogin.jsp"); //error page 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
