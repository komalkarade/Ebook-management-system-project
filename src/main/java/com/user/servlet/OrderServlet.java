package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.BookDAOImpl;
import com.DAO.BookOrderImpl;
import com.DAO.CartDAOImpl;
import com.DB.DBConnect;
import com.entity.BookDtls;
import com.entity.Book_order;
import com.entity.Cart;
import com.mysql.cj.Session;


public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderServlet() {
		super();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("username");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String address = req.getParameter("address");
			String landmark = req.getParameter("landmark");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String pincode = req.getParameter("pincode");
			String paymentType = req.getParameter("payment");

			String fullAdd = address + "," + landmark + "," + city + "," + state + "," + pincode;

			CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());

			List<Cart> blist = dao.getBookByUser(id);
			BookOrderImpl dao2 = new BookOrderImpl(DBConnect.getConn());
			int i = dao2.getOrderNo();

			Book_order o = new Book_order();
			ArrayList<Book_order> orderList =new ArrayList<Book_order>();
			for (Cart c : blist) {

				o.setOrderId("BOOK-ORD-00" + i);
				o.setUsername(name);
				o.setEmail(email);
				o.setFulladd(fullAdd);
				o.setPhno(phno);
				o.setBook_name(c.getBookName());
				o.setAuthor(c.getAuthor());
				o.setPrice(c.getPrice());
				o.setPaymentType(paymentType);
				orderList.add(o);
				i++;
				
			}

			if ("noselect".equals(paymentType)) {
				resp.sendRedirect("checkout.jsp");
			} else {
                
				boolean f = dao2.saveOrder(orderList);
				
				if(f) {
					System.out.println("order success");
				}
				else {
					System.out.println("order failed");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
