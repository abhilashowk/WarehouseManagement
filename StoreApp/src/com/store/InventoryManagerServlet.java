package com.store;
 
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
/*import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*///****What do we do with these?*****//
 






import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.ProductsDAO;
import com.store.Products;
 
public class InventoryManagerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/listInventory.jsp";
    private static String LIST_PRODUCTS = "/listInventoryManager.jsp";
    private ProductsDAO dao;
 
    public InventoryManagerServlet() throws ClassNotFoundException, SQLException {
        super();
        dao = new ProductsDAO();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
    System.out.println("ACKNOWLEDGE ACTION"+action);
        if (action.equalsIgnoreCase("delete")){
            String productId = request.getParameter("ProductId");
            dao.deleteProduct(productId);
            forward = LIST_PRODUCTS;
            request.setAttribute("products", dao.getAllProducts());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            String productId = request.getParameter("ProductId");
            Products products = dao.getProductById(productId);
            request.setAttribute("product", products);
        } else if (action.equalsIgnoreCase("listInventoryManager")){
            forward = LIST_PRODUCTS;
            request.setAttribute("products", dao.getAllProducts());
        } else {
            forward = INSERT_OR_EDIT;
        }
 
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
        System.out.println("ACKNOWLEDGE ACTION"+action);
    	
    	Products products = new Products();
        products.setProductId(request.getParameter("ProductId"));
        products.setProductCode(request.getParameter("ProductCode"));
        products.setProductId(request.getParameter("DepartmentId"));
        products.setBrand(request.getParameter("Brand"));
        products.setName(request.getParameter("Name"));
        products.setProductType(request.getParameter("ProductType"));
        products.setPrice(Integer.parseInt(request.getParameter("Price")));
        try {
            Date edate = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("ExpirationDate"));//CheckThis
            System.out.println("rrrrrrrrrrr"+ edate);
           products.setExpirationDate(edate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        products.setDiscount(request.getParameter("Discount"));
        try {
            Date mdate = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("ManufacturingDate"));//Check This
            System.out.println("rrrrrrrrrrr"+ mdate);
          products.setManufacturingDate(mdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String productId = request.getParameter("ProductId");
        if(productId == null || productId.isEmpty())
        {
           // dao.addUser(products);
            dao.addProduct(products);
        }
        else
        {
            products.setProductId(productId);
            dao.checkProducts(products);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_PRODUCTS);
        request.setAttribute("products", dao.getAllProducts());
        view.forward(request, response);
    }
}