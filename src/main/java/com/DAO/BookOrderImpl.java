package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.entity.Book_order;

public class BookOrderImpl implements BookOrderDAO {
	private Connection conn;

	public BookOrderImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	@Override
	public int getOrderNo() {
		int i=0;
		try {
			String sql="Select  *  from book_order";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				i++;
			}
		} catch (Exception e) {
e.printStackTrace();		}
		return i;
	}
	@Override
	public boolean saveOrder(List<Book_order> blist) {
boolean f=false;

try {
	String sql="insert into book_order(order_id,user_name,email,address,phno,book_name,author,price,payment)  values(?,?,?,?,?,?,?,?,?)";
	conn.setAutoCommit(false);
	PreparedStatement ps=conn.prepareStatement(sql);
	for(Book_order b:blist) {
		ps.setString(1, b.getOrderId());
		ps.setString(2, b.getUsername());
		ps.setString(3, b.getEmail());
		ps.setString(4, b.getFulladd());
		ps.setString(5, b.getPhno());
		ps.setString(6, b.getBook_name());
		ps.setString(7, b.getAuthor());
		ps.setDouble(8, b.getPrice());
		ps.setString(9, b.getPaymentType());
     
		ps.addBatch();

		
	}
	
	int[] count=ps.executeBatch();
	conn.commit();
	f=true;
	conn.setAutoCommit(true);
} catch (Exception e) {
e.printStackTrace();}

return false;
	}
	

}
