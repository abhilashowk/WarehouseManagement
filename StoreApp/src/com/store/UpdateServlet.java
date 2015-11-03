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
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		
		Products details = new Products();
	    details.setProductId(request.getParameter("ProductId"));
	    details.setProductCode(request.getParameter("ProductCode"));
	    details.setDepartmentId(request.getParameter("CustomerName"));
	    details.setBrand(request.getParameter("Brand"));
	    details.setName(request.getParameter("Name"));
	    details.setProductType(request.getParameter("ProductType"));
	    details.setPrice(Integer.parseInt(request.getParameter("Price")));
	    try {
            Date edate = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("ExpirationDate"));//CheckThis
            System.out.println("rrrrrrrrrrr"+ edate);
            details.setExpirationDate(edate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
	    details.setDiscount(request.getParameter("Discount"));
        try {
            Date mdate = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("ManufacturingDate"));//Check This
            System.out.println("rrrrrrrrrrr"+ mdate);
            details.setManufacturingDate(mdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
	    
		
       // details.setCustomerPassword((request.getParameter("CustomerPassword")));
        details = StoreDAO.updateProducts(details);
        
        if (details.isValid())
        {
   	        
            // HttpSession session = request.getSession(true);	    
            // session.setAttribute("currentSessionUser",details); 
            // response.sendRedirect("userLogged.jsp"); //logged-in page 
             PrintWriter out = response.getWriter();  
             response.setContentType("text/html");  
             out.println("<script type=\"text/javascript\">");  
             out.println("alert('Updated this product into database');");  
             out.println("</script>");
             response.sendRedirect("listInventory.jsp"); 
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
