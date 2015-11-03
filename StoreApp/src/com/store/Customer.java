package com.store;

public class Customer {
 String customerName,customerPassword,emailID,address;
 int contactNumber;
 Boolean isValid;
 public String getCustomerName(){
	 return customerName;
 }
 public void setCustomerName(String customerName){
	 this.customerName = customerName;
 }
 
 public String getCustomerPassword(){
	 return customerPassword;
 }
 public void setCustomerPassword(String customerPassword){
	 this.customerPassword = customerPassword;
 }
 
 public String getEmailID(){
	 return emailID;
 }
 public void setEmailID(String emailID){
	 this.emailID = emailID;
 }
 
 public String getAddress(){
	 return address;
 }
 public void setAddress(String address){
	 this.address = address;
 }
 
 public int getContactNumber(){
	 return contactNumber;
 }
 public void setContactNumber(int contactNumber){
	 this.contactNumber = contactNumber;
 }
 
 public Boolean isValid(){
	 return isValid;
 }
 public void setIsValid(Boolean isValid){
	 this.isValid = isValid;
 }
 
}
