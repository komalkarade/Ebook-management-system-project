package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookDAOImpl;
import com.DAO.CartDAOImpl;
import com.DB.DBConnect;
import com.entity.BookDtls;
import com.entity.Cart;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int book_id=Integer.parseInt(req.getParameter("book_id"));
			int userid=Integer.parseInt(req.getParameter("userid"));

			BookDAOImpl dao=new BookDAOImpl(DBConnect.getConn());
			BookDtls b=dao.getBookById(book_id);
			
			Cart c=new Cart();
			c.setBook_id(book_id);
		c.setUserid(userid);
		c.setBookName(b.getBookName());
		c.setAuthor(b.getAuthor());
		c.setPrice(Double.parseDouble(b.getPrice()));
		c.setTotalPrice(Double.parseDouble(b.getPrice()));
		
		
		CartDAOImpl dao2=new CartDAOImpl(DBConnect.getConn());
		boolean f=dao2.addCart(c);
		
		HttpSession session=req.getSession();
		
		 
		if(f) {
			
			session.setAttribute("addCart", "Add cart successfully");
			resp.sendRedirect("all_new_book.jsp");
			
		//	System.out.println("Add cart successfully");
		}
		else {
			session.setAttribute("failed", "Something wrong on server...");
			resp.sendRedirect("all_new_book.jsp");
			//System.out.println("Something wrong on server...");

		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
