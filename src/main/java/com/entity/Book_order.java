package com.entity;

public class Book_order {

	private int id;
	private String orderId;
	private String username;	
	private String email;
	private String phno;
	private String fulladd;
	private String book_name;
	private String author;
	private Double price;
	private String paymentType;
	public Book_order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book_order(int id, String orderId, String username, String email, String phno, String fulladd,
			String book_name, String author, Double price, String paymentType) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.username = username;
		this.email = email;
		this.phno = phno;
		this.fulladd = fulladd;
		this.book_name = book_name;
		this.author = author;
		this.price = price;
		this.paymentType = paymentType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getFulladd() {
		return fulladd;
	}
	public void setFulladd(String fulladd) {
		this.fulladd = fulladd;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double double1) {
		this.price = double1;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	@Override
	public String toString() {
		return "Book_order [id=" + id + ", orderId=" + orderId + ", username=" + username + ", email=" + email
				+ ", phno=" + phno + ", fulladd=" + fulladd + ", book_name=" + book_name + ", author=" + author
				+ ", price=" + price + ", paymentType=" + paymentType + "]";
	}
	
	




	
}
