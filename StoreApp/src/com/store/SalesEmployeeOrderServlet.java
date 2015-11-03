package com.store;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class SalesEmployeeOrderServlet
 */
@WebServlet("/SalesEmployeeOrderServlet")
public class SalesEmployeeOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesEmployeeOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Order details = new Order();
		//details.setCustomerID();
		
		HttpSession session = request.getSession(true);
        //String ID = (String) session.getAttribute("key");
        String pID = request.getParameter("ProductIdE").toString();
        details.setCustomerID(request.getParameter("CustomerIdE"));
        details.setProductID((request.getParameter("ProductIdE")));
        
        
        int price = StoreDAO.getPrice(pID);
        details.setPrice(price);
         System.out.println("PRICDE"+price);
        
      //  details.setOrderID((request.getParameter("OrderID")));
       // Date dt = new Date();
        Calendar c = new GregorianCalendar();
	    c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
	    c.set(Calendar.MINUTE, 0);
	    c.set(Calendar.SECOND, 0);
	    Date d1 = c.getTime();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");String s= sdf.format(d1);
	    Date date = null;
		try {
			date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        details.setTodayDate( new java.sql.Date(new java.util.Date().getTime()));
        
      //  System.out.println("CUSTOMER ID PRINTED FRM ORDER"+ ID);
       // details.setCustomerPassword((request.getParameter("CustomerPassword")));
        details = StoreDAO.insertOrder(details);
        
        if (details.isValid())
        {
   	        
            
             session.setAttribute("currentSession",details); 
             int totalPrice = 0;
             if(session.getAttribute("Price")!=null)
              totalPrice = ( (Integer)session.getAttribute("Price"));
             totalPrice = totalPrice+price;
             session.setAttribute("Price", totalPrice);
             PrintWriter out = response.getWriter();  
             response.setContentType("text/html");  
             out.println("<script type=\"text/javascript\">");  
             out.println("alert('Added this product into database');"+price);  
             out.println("</script>");
             
             response.sendRedirect("SalesEmployeeOrder.jsp"); //logged-in page      		
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
