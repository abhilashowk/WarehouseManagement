package com.store;

import java.io.IOException;
import java.io.PrintWriter;

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



/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order details = new Order();
		//details.setCustomerID();
		
		HttpSession session = request.getSession(true);
        String ID = (String) session.getAttribute("key");
        String pID = request.getParameter("ProductId").toString();
        details.setCustomerID(ID);
        details.setProductID((request.getParameter("ProductId")));
        
        
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
        
        System.out.println("CUSTOMER ID PRINTED FRM ORDER"+ ID);
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
             
             response.sendRedirect("order.jsp"); //logged-in page      		
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
