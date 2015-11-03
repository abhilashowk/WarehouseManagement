package com.store;

//import java.sql.Date;
import java.util.Date;
public class EmployeeInsert {
 public String EmployeeId, FirstName, MiddleName, LastName, Password;Boolean isValid;
 public String  SSN, Designation, EmailId, Address; 
 public Integer Salary;
 public Long ContactNum;
 public Date  DOB, JoiningDate;
 
 public String getEmployeeId(){
	 return EmployeeId;
 }
 public void setEmployeeId(String EmployeeId){
	 this.EmployeeId = EmployeeId;
 }
 public String getFirstName(){
	 return FirstName;
 }
 public void setFirstName(String FirstName){
	 this.FirstName = FirstName;
 }
 public String getMiddleName(){
	 return MiddleName;
 }
 public void setMiddleName(String MiddleName){
	 this.MiddleName = MiddleName;
 }
 public String getLastName(){
	 return LastName;
 }
 public void setLastName(String LastName){
	 this.LastName = LastName;
 }
 public String getPassword(){
	 return Password;
 }
 public void setPassword(String Password){
	 this.Password = Password;
 }
 public Boolean isValid(){
	 return isValid;
 }
 public void setIsValid(Boolean isValid){
	 this.isValid = isValid;
 }
 public String getSSN(){
	 return SSN;
 }
 public void setSSN(String SSN){
	 this.SSN = SSN;
 }
 public Date getDOB(){
	 return DOB;
 }
 public void setDOB(Date DOB){
	 this.DOB = DOB;
 }
 public Date getJoiningDate(){
	 return JoiningDate;
 }
 public void setJoiningDate(Date JoiningDate){
	 this.JoiningDate = JoiningDate;
 }
 public String getDesignation(){
	 return Designation;
 }
 public void setDesignation(String Designation){
	 this.Designation = Designation;
 }
 public Integer getSalary(){
	 return Salary;
 }
 public void setSalary(Integer Salary){
	 this.Salary = Salary;
 }
 public Long getContactNum(){
	 return ContactNum;
 }
 public void setContactNum(Long ContactNum){
	 this.ContactNum = ContactNum;
 }
 public String getEmailId(){
	 return EmailId;
 }
 public void setEmailId(String EmailId){
	 this.EmailId = EmailId;
 }
 public String getAddress(){
	 return Address;
 }
 public void setAddress(String Address){
	 this.Address = Address;
 }
 
 
}
