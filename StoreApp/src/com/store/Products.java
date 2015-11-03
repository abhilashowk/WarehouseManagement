package com.store;
import java.util.Date;

public class Products {
		 String ProductId,ProductCode,DepartmentId,Brand,Name,ProductType,Discount;
		 //int contactNumber;
		 int Price;
		 Date ExpirationDate, ManufacturingDate;
		 Boolean isValid;
		 
		 public String getProductId(){
			 return ProductId;
		 }
		 public void setProductId(String ProductId){
			 this.ProductId = ProductId;
		 }
		 
		 public String getProductCode(){
			 return ProductCode;
		 }
		 public void setProductCode(String ProductCode){
			 this.ProductCode = ProductCode;
		 }
		 
		 public String getDepartmentId(){
			 return DepartmentId;
		 }
		 public void setDepartmentId(String DepartmentId){
			 this.DepartmentId = DepartmentId;
		 }
		 
		 public String getBrand(){
			 return Brand;
		 }
		 public void setBrand(String Brand){
			 this.Brand = Brand;
		 }
		 
		 public String getName(){
			 return Name;
		 }
		 public void setName(String Name){
			 this.Name = Name;
		 }
		 
		 public String getProductType(){
			 return ProductType;
		 }
		 public void setProductType(String ProductType){
			 this.ProductType = ProductType;
		 }
		 
		 public String getDiscount(){
			 return Discount;
		 }
		 public void setDiscount(String Discount){
			 this.Discount = Discount;
		 }
		 
		 public int getPrice(){
			 return Price;
		 }
		 public void setPrice(int Price){
			 this.Price = Price;
		 } 
		 public Date getExpirationDate(){
			 return ExpirationDate;
		 }
		 public void setExpirationDate(Date ExpirationDate){
			 this.ExpirationDate = ExpirationDate;
		 }
		 
		 public Date getManufacturingDate(){
			 return ExpirationDate;
		 }
		 public void setManufacturingDate(Date ManufacturingDate){
			 this.ManufacturingDate = ManufacturingDate;
		 }
		 
		 
		 public Boolean isValid(){
			 return isValid;
		 }
		 public void setIsValid(Boolean isValid){
			 this.isValid = isValid;
		 }
}
