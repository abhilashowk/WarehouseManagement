package com.store;

import java.sql.*;
import java.util.*;

import com.store.Products;
import com.store.DatabaseConnection;
import com.mysql.jdbc.PreparedStatement;
 
public class ProductsDAO {
 
    private  Connection connection;
 
    public ProductsDAO() throws ClassNotFoundException, SQLException {
    	connection = DatabaseConnection.getConnection(); //****Please check*****/
    }
 
    public void checkProducts(Products product) {
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement("select ProductId from Products where ProductId = ?");
            ps.setString(1, product.getProductId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                updateProducts(product);
            } else {
                addProduct(product);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
    }
    public  void addProduct(Products product) {
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("insert into Products (ProductId,ProductCode, DepartmentId, Brand,Name, ProductType, Price, ExpirationDate, Discount, ManufacturingDate) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, product.getProductId());
            preparedStatement.setString(2, product.getProductCode());
            preparedStatement.setString(3, product.getDepartmentId());
            preparedStatement.setString(4, product.getBrand());
            preparedStatement.setString(5, product.getName());
            preparedStatement.setString(6, product.getProductType()); 
            preparedStatement.setInt(7, product.getPrice());
         preparedStatement.setDate(8, new java.sql.Date(product.getExpirationDate().getTime()));
            preparedStatement.setString(9, product.getDiscount());
           preparedStatement.setDate(10,new java.sql.Date(product.getManufacturingDate().getTime()));
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void deleteProduct(String productId) {
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("delete from Products where ProductId=?");
            // Parameters start with 1
            preparedStatement.setString(1, productId);
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void updateProducts(Products product) {
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("update Products set ProductId=?, ProductCode=?, DepartmentId=?, Brand=?, Name=?, ProducType=?, Price=?, Expirationdate=?, Discount=?, ManufacutringDate=?"
                    + "where ProductId=?");
            // Parameters start with 1
            //System.out.println(new java.sql.Date(product.getRegisteredon().getTime()));
            preparedStatement.setString(1, product.getProductId());
            preparedStatement.setString(2, product.getProductCode());
            preparedStatement.setString(3, product.getDepartmentId());
            preparedStatement.setString(4, product.getBrand());
            preparedStatement.setString(5, product.getName());
            preparedStatement.setString(6, product.getProductType()); 
            preparedStatement.setInt(7, product.getPrice());
            preparedStatement.setDate(8, new java.sql.Date(product.getExpirationDate().getTime()));
            preparedStatement.setString(9, product.getDiscount());
          preparedStatement.setDate(10,new java.sql.Date(product.getManufacturingDate().getTime()));
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public List<Products> getAllProducts() {
        List<Products> products = new ArrayList<Products>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from products");
            while (rs.next()) {
            	System.out.println("Display products");
                Products product = new Products();
                product.setProductId(rs.getString("ProductId"));
                product.setProductCode(rs.getString("ProductCode"));
                product.setDepartmentId(rs.getString("DepartmentId"));
                product.setBrand(rs.getString("Brand"));
                product.setName(rs.getString("Name"));
                product.setProductType(rs.getString("ProductType"));
                product.setPrice(rs.getInt("Price"));
             product.setExpirationDate(rs.getDate("ExpirationDate"));
                product.setDiscount(rs.getString("Discount"));
            product.setManufacturingDate(rs.getDate("ManufacturingDate"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return products;
    }
 
    public Products getProductById(String productId) {
        Products products = new Products();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("select * from Products where ProductId=?");
            preparedStatement.setString(1, products.getProductId());
            preparedStatement.setString(2, products.getProductCode());
            preparedStatement.setString(3, products.getDepartmentId());
            preparedStatement.setString(4, products.getBrand());
            preparedStatement.setString(5, products.getName());
            preparedStatement.setString(6, products.getProductType()); 
            preparedStatement.setInt(7, products.getPrice());
         //   preparedStatement.setDate(8, new java.sql.Date(products.getExpirationDate().getTime()));
            preparedStatement.setString(9, products.getDiscount());
           // preparedStatement.setDate(10,new java.sql.Date(products.getManufacturingDate().getTime()));
            
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
                products.setProductCode(rs.getString("ProductCode"));
                products.setDepartmentId(rs.getString("DepartmentId"));
                products.setBrand(rs.getString("Brand"));
                products.setName(rs.getString("Name"));
                products.setProductType(rs.getString("ProductType"));
                products.setPrice(rs.getInt("Price"));
              //  products.setExpirationDate(rs.getDate("ExpirationDate"));
                products.setDiscount(rs.getString("Discount"));
               // products.setManufacturingDate(rs.getDate("ManufacturingDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return products;
    }
}