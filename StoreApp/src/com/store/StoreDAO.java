package com.store;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

public class StoreDAO {
	static Connection currentCon = null;
    static ResultSet rs = null;  
	static int count =4; 
	
	
    public static Customer login(Customer bean) {
	
       //preparing some objects for connection 
       Statement stmt = null;    
	
       String username = bean.getCustomerName();    
       String password = bean.getCustomerPassword();   
	    
       String searchQuery =
             "select * from Customer where CustomerName='"
                      + username
                      + "' AND CustomerPassword='"
                      + password
                      + "'";
	    
    // "System.out.println" prints in the console; Normally used to trace the process
    System.out.println("Your user name is " + username);          
  //  System.out.println("Your password is " + password);
    System.out.println("Query: "+searchQuery);
	    
    try 
    {
       //connect to DB 
       currentCon =  DatabaseConnection.getConnection();
       stmt=currentCon.createStatement();
       rs = stmt.executeQuery(searchQuery);	        
       boolean more = rs.next();
	       
       // if user does not exist set the isValid variable to false
       if (!more) 
       {
          System.out.println("Sorry, you are not a registered user! Please sign up first");
          bean.setIsValid(false);
       } 
	        
       //if user exists set the isValid variable to true
       else if (more) 
       {
          String firstName = rs.getString("CustomerName");
          //String lastName = rs.getString("LastName");
          String pass = rs.getString("CustomerPassword");
          System.out.println("Welcome " + firstName);
          bean.setCustomerName(firstName);
         bean.setCustomerPassword(pass);
          bean.setIsValid(true);
       }
    } 

    catch (Exception ex) 
    {
       System.out.println("Log In failed: An Exception has occurred! " + ex);
    } 
    return bean;    
}
  
    public static int getPrice(String bean) {
    	
        //preparing some objects for connection 
        Statement stmt = null;    
 	
          
 	    
        String searchQuery =
              "select Price from Products where ProductId='"
                       + bean
                     
                       + "'";
 	    
     // "System.out.println" prints in the console; Normally used to trace the process
     System.out.println("Your user name is " + bean);          
   //  System.out.println("Your password is " + password);
     System.out.println("Query: "+searchQuery);
 	    int price = 0;
     try 
     {
        //connect to DB 
        currentCon =  DatabaseConnection.getConnection();
        stmt=currentCon.createStatement();
        rs = stmt.executeQuery(searchQuery);
        while (rs.next()) {
         price = rs.getInt(1);
        }
         System.out.println("PRICE"+price);
     }
       // boolean more = rs.next();
     catch (Exception ex) 
     {
        System.out.println("Log In failed: An Exception has occurred! " + ex);
     }       
       
     return price;    
 }
    
public static String getDesignation(String firstName,String password) {
    	
        //preparing some objects for connection 
        Statement stmt = null;    
 	
          
      //  String username = bean.getCustomerName();    
        //String password = bean.getCustomerPassword();   
        String searchQuery =
              "select Designation from Employee where FirstName='"
            		  + firstName
                      + "' AND Password='"
                      + password
                      + "'";
 	    
     // "System.out.println" prints in the console; Normally used to trace the process
     System.out.println("Your user name is " + firstName);          
   //  System.out.println("Your password is " + password);
     System.out.println("Query: "+searchQuery);
 	    String designation = "";
     try 
     {
        //connect to DB 
        currentCon =  DatabaseConnection.getConnection();
        stmt=currentCon.createStatement();
        rs = stmt.executeQuery(searchQuery);
        while (rs.next()) {
        	designation = rs.getString(1);
        }
     }
       // boolean more = rs.next();
     catch (Exception ex) 
     {
        System.out.println("Log In failed: An Exception has occurred! " + ex);
     }       
       System.out.println("DESIGNATION INSIDE"+designation);
     return designation;    
 }

    public static Customer insert(Customer bean) {
    	
        //preparing some objects for connection 
    	java.sql.PreparedStatement  stmt = null;    
 	
        String username = bean.getCustomerName();    
        String password = bean.getCustomerPassword();   
        String address = bean.getAddress();    
        String emailid = bean.getEmailID();  
        int contactno = bean.getContactNumber();    
        //String password = bean.getCustomerPassword();  
        String type = "MEMBER";
        
        String searchQuery =
              "insert into Customer(CustomerID, CustomerName, CustomerPassword, CustomerType, Address,  EmailID,ContactNumber) values("+count+",?,?, '" + type + "',?,?,?)";
                       count++;
 	    
     // "System.out.println" prints in the console; Normally used to trace the process
     System.out.println("Your user name is " + username);          
   //  System.out.println("Your password is " + password);
     System.out.println("Query: "+searchQuery);
 	    
     try 
     {
        //connect to DB 
        currentCon =  DatabaseConnection.getConnection();
        stmt=currentCon.prepareStatement (searchQuery);
        stmt.setString(1,bean.getCustomerName());  
        stmt.setString(2,bean.getCustomerPassword());  
        stmt.setString(3,bean.getAddress());  
        stmt.setString(4,bean.getEmailID());  
        stmt.setLong(5,bean.getContactNumber()); 
        
        int status=stmt.executeUpdate(); 
 	       
        // if user does not exist set the isValid variable to false
        if (status<=0) 
        {
           System.out.println("Sorry, you are not a registered user! Please sign up first");
           bean.setIsValid(false);
        } 
 	        
        //if user exists set the isValid variable to true
        else  
        {
           System.out.println("Awesome");
           bean.setIsValid(true);
        }
     } 

     catch (Exception ex) 
     {
        System.out.println("Log In failed: An Exception has occurred! " + ex);
     } 
     return bean;    
 }
    
 public static Products insertProducts(Products bean) {
    	
        //preparing some objects for connection 
    	java.sql.PreparedStatement  stmt = null;    
 	
      //  String username = bean.getCustomerName();    
        //String password = bean.getCustomerPassword();   
        //String address = bean.getAddress();    
            
        //String password = bean.getCustomerPassword();  
       // String type = "GUEST";
        
        String searchQuery =
              "insert into Products(ProductId,ProductCode,DepartmentId,Brand,Name,ProductType,Price,ExpirationDate, Discount, ManufacturingDate) values(?,?,?,?,?,?,?,?,?,?)";
                       count++;
 	    
     // "System.out.println" prints in the console; Normally used to trace the process
    // System.out.println("Your user name is " + username);          
   //  System.out.println("Your password is " + password);
     System.out.println("Query: "+searchQuery);
 	    
     try 
     {
        //connect to DB 
        currentCon =  DatabaseConnection.getConnection();
        stmt=currentCon.prepareStatement (searchQuery);
        stmt.setString(1,bean.getProductId());  
        stmt.setString(2,bean.getProductCode());  
        stmt.setString(3,bean.getDepartmentId());  
        stmt.setString(4,bean.getBrand());  
        stmt.setString(5,bean.getName()); 
       stmt.setString(6, bean.getProductCode());
       stmt.setInt(7, bean.getPrice());
       stmt.setDate(8, new java.sql.Date(bean.getExpirationDate().getTime()));
       stmt.setString(9, bean.getDiscount());
       stmt.setDate(10,new java.sql.Date(bean.getManufacturingDate().getTime()));
        
        int status=stmt.executeUpdate(); 
 	       
        // if user does not exist set the isValid variable to false
        if (status<=0) 
        {
           System.out.println("Sorry, you are not a registered user! Please sign up first");
           bean.setIsValid(false);
        } 
 	        
        //if user exists set the isValid variable to true
        else  
        {
           System.out.println("Awesome");
           bean.setIsValid(true);
        }
     } 

     catch (Exception ex) 
     {
        System.out.println("Log In failed: An Exception has occurred! " + ex);
     } 
     return bean;    
 }
 
 
 public static String deleteProducts(String productID) {
 	
     //preparing some objects for connection 
 	java.sql.PreparedStatement  stmt = null;    
	
   
     
     String searchQuery =
           "delete from Products where ProductId = ?";
                    
	    
  // "System.out.println" prints in the console; Normally used to trace the process
 // System.out.println("Your user name is " + username);          
//  System.out.println("Your password is " + password);
  System.out.println("Query: "+searchQuery);
	    
  try 
  {
     //connect to DB 
     currentCon =  DatabaseConnection.getConnection();
     stmt=currentCon.prepareStatement (searchQuery);
     stmt.setString(1,productID);  
     
     
     int status=stmt.executeUpdate(); 
	       
     // if user does not exist set the isValid variable to false
     if (status<=0) 
     {
        System.out.println("Sorry, you are not a registered user! Please sign up first");
        return "notdeleted";
     } 
	        
     //if user exists set the isValid variable to true
     else  
     {
        System.out.println("Awesome");
        return "deleted";
     }
     
  } 

  catch (Exception ex) 
  {
     System.out.println("Log In failed: An Exception has occurred! " + ex);
  } 
  return null;    
}
 
 public static Products updateProducts(Products bean) {
 	
     //preparing some objects for connection 
 	java.sql.PreparedStatement  stmt = null;    
	
   //  String username = bean.getCustomerName();    
     //String password = bean.getCustomerPassword();   
     //String address = bean.getAddress();    
         
     //String password = bean.getCustomerPassword();  
    // String type = "GUEST";
     
     String searchQuery =
           "update Products set ProductCode = ? ,DepartmentId = ? ,Brand = ?,Name = ?,ProductType = ?,Price = ?,ExpirationDate = ?, Discount = ?, ManufacturingDate = ? where ProductId = ?";
                    
	    
  // "System.out.println" prints in the console; Normally used to trace the process
 // System.out.println("Your user name is " + username);          
//  System.out.println("Your password is " + password);
  System.out.println("Query: "+searchQuery);
	    
  try 
  {
     //connect to DB 
     currentCon =  DatabaseConnection.getConnection();
     stmt=currentCon.prepareStatement (searchQuery);
      
     stmt.setString(1,bean.getProductCode());  
     stmt.setString(2,bean.getDepartmentId());  
     stmt.setString(3,bean.getBrand());  
     stmt.setString(4,bean.getName()); 
    stmt.setString(5, bean.getProductCode());
    stmt.setInt(6, bean.getPrice());
    stmt.setDate(7, new java.sql.Date(bean.getExpirationDate().getTime()));
    stmt.setString(8, bean.getDiscount());
    stmt.setDate(9,new java.sql.Date(bean.getManufacturingDate().getTime()));
    stmt.setString(10,bean.getProductId()); 
     int status=stmt.executeUpdate(); 
	       
     // if user does not exist set the isValid variable to false
     if (status<=0) 
     {
        System.out.println("Sorry, you are not a registered user! Please sign up first");
        bean.setIsValid(false);
     } 
	        
     //if user exists set the isValid variable to true
     else  
     {
        System.out.println("Awesome");
        bean.setIsValid(true);
     }
  } 

  catch (Exception ex) 
  {
     System.out.println("Log In failed: An Exception has occurred! " + ex);
  } 
  return bean;    
}
 
public static Order insertOrder(Order bean) {
    	
        //preparing some objects for connection 
    	java.sql.PreparedStatement  stmt = null;    
 	
        String username = bean.getCustomerID();    
        String password = bean.getProductID();   
        //String address = bean.getOrderID();    
         
        //String password = bean.getCustomerPassword();  
        String type = "GUEST";
        
        String searchQuery =
              "insert into orders(OrderID,CustomerID,ProductID,DateOfOrder,BillingAmount) values("+count+",?,?,?,?)";
                       count++;
 	    
     // "System.out.println" prints in the console; Normally used to trace the process
     System.out.println("Your user name is " + username);          
   //  System.out.println("Your password is " + password);
     System.out.println("Query: "+searchQuery);
 	    
     try 
     {
        //connect to DB 
        currentCon =  DatabaseConnection.getConnection();
        stmt=currentCon.prepareStatement (searchQuery);
        stmt.setString(1,bean.getCustomerID());  
        stmt.setString(2,bean.getProductID());  
       
        stmt.setDate(3,bean.getTodayDate()); 
        stmt.setInt(4, bean.getPrice());
        
        int status=stmt.executeUpdate(); 
 	       
        // if user does not exist set the isValid variable to false
        if (status<=0) 
        {
           System.out.println("Sorry, you are not a registered user! Please sign up first");
           bean.setIsValid(false);
        } 
 	        
        //if user exists set the isValid variable to true
        else  
        {
           System.out.println("Awesome");
           bean.setIsValid(true);
        }
     } 

     catch (Exception ex) 
     {
        System.out.println("Log In failed: An Exception has occurred! " + ex);
     } 
     return bean;    
 }

    public static Employee empLogin(Employee bean) {
    	
        //preparing some objects for connection 
        Statement stmt = null;    
 	
        String username = bean.getFirstName();    
        String password = bean.getPassword();   
 	    
        String searchQuery =
              "select * from Employee where FirstName='"
                       + username
                       + "' AND Password='"
                       + password
                       + "'";
 	    
     // "System.out.println" prints in the console; Normally used to trace the process
     System.out.println("Your user name is " + username);          
   //  System.out.println("Your password is " + password);
     System.out.println("Query: "+searchQuery);
 	    
     try 
     {
        //connect to DB 
        currentCon =  DatabaseConnection.getConnection();
        stmt=currentCon.createStatement();
        rs = stmt.executeQuery(searchQuery);	        
        boolean more = rs.next();
 	       
        // if user does not exist set the isValid variable to false
        if (!more) 
        {
           System.out.println("Sorry, you are not a registered user! Please sign up first");
           bean.setIsValid(false);
        } 
 	        
        //if user exists set the isValid variable to true
        else if (more) 
        {
           String firstName = rs.getString("FirstName");
           //String lastName = rs.getString("LastName");
           String pass = rs.getString("Password");
           System.out.println("Welcome " + firstName);
           bean.setFirstName(firstName);
          bean.setPassword(pass);
           bean.setIsValid(true);
        }
     } 

     catch (Exception ex) 
     {
        System.out.println("Log In failed: An Exception has occurred! " + ex);
     } 
     return bean;    
 }
   
    
public static EmployeeInsert updateEmployee(EmployeeInsert bean) {
    	
        //preparing some objects for connection 
    	java.sql.PreparedStatement  stmt = null;
        String searchQuery =
              "update employee set FirstName = ? ,MiddleName = ?,LastName = ?,Password = ?, SSN = ?, DOB = ?, JoiningDate = ?, Designation = ?, Salary =?, ContactNum =?, EmailId=?, Address=? where EmployeeId = ?";
                       
   	 
     System.out.println("Query: "+searchQuery);
   	    
     try 
     {
        //connect to DB 
    	 currentCon =  DatabaseConnection.getConnection();
         stmt=currentCon.prepareStatement (searchQuery);
          
         stmt.setString(1,bean.getFirstName());  
         stmt.setString(2,bean.getMiddleName());  
         stmt.setString(3,bean.getLastName());  
         stmt.setString(4,bean.getPassword()); 
         stmt.setString(5,bean.getSSN());  
         //stmt.setDate(7,bean.getDOB()); 
         //stmt.setDate(7, new java.sql.Date(DOB.getTime()));
         stmt.setDate(6, new java.sql.Date(bean.getDOB().getTime()));
         stmt.setDate(7, new java.sql.Date(bean.getJoiningDate().getTime()));
         //stmt.setDate(8,bean.getJoiningDate());  
         stmt.setString(8,bean.getDesignation());  
         stmt.setInt(9,bean.getSalary());
         stmt.setLong(10,bean.getContactNum());  
         stmt.setString(11,bean.getEmailId());  
         stmt.setString(12,bean.getAddress());
         stmt.setString(13,bean.getEmployeeId()); 
        int status=stmt.executeUpdate(); 
   	       
        // if user does not exist set the isValid variable to false
        if (status<=0) 
        {
           System.out.println("Sorry, you are not a registered user! Please sign up first");
           bean.setIsValid(false);
        } 
   	        
        //if user exists set the isValid variable to true
        else  
        {
           System.out.println("Awesome");
           bean.setIsValid(true);
        }
     } 

     catch (Exception ex) 
     {
        System.out.println("Log In failed: An Exception has occurred! " + ex);
     } 
     return bean;    
   }

    
    
    public static String deleteEmployee(String EmployeeId) {
     	
        //preparing some objects for connection 
    	java.sql.PreparedStatement  stmt = null;    
   	
      
        
        String searchQuery =
              "delete from Employee where EmployeeId = ?";
                       
   	    
     // "System.out.println" prints in the console; Normally used to trace the process
    // System.out.println("Your user name is " + username);          
   //  System.out.println("Your password is " + password);
     System.out.println("Query: "+searchQuery);
   	    
     try 
     {
        //connect to DB 
        currentCon =  DatabaseConnection.getConnection();
        stmt=currentCon.prepareStatement (searchQuery);
        stmt.setString(1,EmployeeId);  
        
        
        int status=stmt.executeUpdate(); 
   	       
        // if user does not exist set the isValid variable to false
        if (status<=0) 
        {
           System.out.println("Sorry, The Employee with the ID doesn't exist");
           return "notdeleted";
        } 
   	        
        //if user exists set the isValid variable to true
        else  
        {
           System.out.println("Awesome");
           return "deleted";
        }
        
     } 

     catch (Exception ex) 
     {
        System.out.println("Log In failed: An Exception has occurred! " + ex);
     } 
     return null;    
   }
    public static EmployeeInsert insertEmployee(EmployeeInsert bean)
    {
    	
    	java.sql.PreparedStatement  stmt = null; 
    	String EmployeeId = bean.getEmployeeId();
    	String FirstName = bean.getFirstName();
    	String MiddleName = bean.getMiddleName();
    	String LastName = bean.getLastName();
    	String Password = bean.getPassword();
    	String SSN = bean.getSSN();
    	Date DOB = bean.getDOB();
    	Date JoiningDate = bean.getJoiningDate();
    	String Designation = bean.getDesignation();
    	Integer Salary = bean.getSalary();
    	Long ContactNum= bean.getContactNum();
    	String EmailId = bean.getEmailId();
    	String Address = bean.getAddress();
    	
    	//String EmpID= "EM"+"count";
    	
    	String searchQuery =
                "insert into Employee(EmployeeId,FirstName,MiddleName,LastName,Password, SSN, DOB, JoiningDate, Designation, Salary, ContactNum, EmailId, Address) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                         count++;
                         
                         try 
                         {
                            //connect to DB 
                            currentCon =  DatabaseConnection.getConnection();
                            stmt=currentCon.prepareStatement (searchQuery);
                            stmt.setString(1,bean.getEmployeeId());  
                            stmt.setString(2,bean.getFirstName());  
                            stmt.setString(3,bean.getMiddleName());  
                            stmt.setString(4,bean.getLastName());  
                            stmt.setString(5,bean.getPassword()); 
                            stmt.setString(6,bean.getSSN());  
                            //stmt.setDate(7,bean.getDOB()); 
                            stmt.setDate(7, new java.sql.Date(DOB.getTime()));
                            stmt.setDate(8, new java.sql.Date(JoiningDate.getTime()));
                            //stmt.setDate(8,bean.getJoiningDate());  
                            stmt.setString(9,bean.getDesignation());  
                            stmt.setInt(10,bean.getSalary());
                            stmt.setLong(11,bean.getContactNum());  
                            stmt.setString(12,bean.getEmailId());  
                            stmt.setString(13,bean.getAddress());  
                            
                            int status=stmt.executeUpdate(); 
                     	       
                            // if user does not exist set the isValid variable to false
                            if (status<=0) 
                            {
                               System.out.println("Sorry, employee failed to add into database");
                               bean.setIsValid(false);
                            } 
                     	        
                            //if user exists set the isValid variable to true
                            else  
                            {
                               System.out.println("Awesome");
                               bean.setIsValid(true);
                            }
                         } 

                         catch (Exception ex) 
                         {
                            System.out.println("Log In failed: An Exception has occurred! " + ex);
                         } 
                         return bean;
    }

    
}
