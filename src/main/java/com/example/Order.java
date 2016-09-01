package com.example;

import java.util.Date;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class Order {
	
	
	private int id;
	private String name;
    
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	private Date orderDate;
	private Boolean active;
	
	public Order(){
		
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getFoundedDate() {
		return orderDate;
	}


	public void setFoundedDate(Date foundedDate) {
		this.orderDate = foundedDate;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;//
	}


	public Order(int id, String name, Date foundedDate, Boolean active) {
		this.id = id;
		this.name = name;
		this.orderDate = foundedDate;
		this.active = active;
	}
	
	
 
}
