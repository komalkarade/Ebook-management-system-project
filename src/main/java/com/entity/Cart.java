package com.entity;

public class Cart {
	
	private int cid;
	private int book_id;
	private int userid;
	private String bookName;
	private String author;
	private Double price;
	private Double totalPrice;
	
	public Cart(int cid, int book_id, int userid, String bookName, String author, Double price, Double totalPrice) {
		super();
		this.cid = cid;
		this.book_id = book_id;
		this.userid = userid;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.totalPrice = totalPrice;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	

	

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
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

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", book_id=" + book_id + ", userid=" + userid + ", bookName=" + bookName
				+ ", author=" + author + ", price=" + price + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
