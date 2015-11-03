package com.store;

import java.sql.Date;

public class Order {

	public String customerID;
	public String productID;
	public String orderID; Date todayDate;int price;
	public Boolean isValid;
	
	public void setCustomerID(String customerID){
		this.customerID = customerID;
	}
	
	public void setProductID(String productID){
		this.productID = productID;
	}
	
	public void setOrderID(String orderID){
		this.orderID = orderID;
	}
	
	 public Boolean isValid(){
		 return isValid;
	 }
	 public void setIsValid(Boolean isValid){
		 this.isValid = isValid;
	 }
	 
	 public String getCustomerID(){
		 return customerID;
	 }
	 public String getOrderID(){
		 return orderID;
	 }
	 public String getProductID(){
		 return productID;
	 }
	 
	 public Date getTodayDate(){
		 return todayDate;
	 }
	 public void setTodayDate(java.util.Date date){
		 this.todayDate = (Date) date;
	 }
	
	 public int getPrice(){
		 return price;
	 }
	 public void setPrice(int price){
		 this.price = price;
	 }
	 
	 
	 
}
