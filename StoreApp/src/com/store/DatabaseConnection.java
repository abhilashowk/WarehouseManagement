package com.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DatabaseConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/warehouse_management?user=root&password=123456");
            java.sql.PreparedStatement preparedStatement = con.prepareStatement("select * from Customer");
          //  preparedStatement.setString(1, userId);
        //    Customer c = new Customer();
          //  ResultSet rs = preparedStatement.executeQuery();
          //  int i = 1;
      //    while(i<5){
      //      if (rs.next()) {
     //           c.setCustomerName((rs.getString("CustomerName")));
                
     //       }
      //      i++;
      //    }
          return con;
    }
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		DatabaseConnection.getConnection();
		System.out.println("Hello");
	}
}
