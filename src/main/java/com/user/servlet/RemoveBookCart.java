package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DB.DBConnect;


public class RemoveBookCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RemoveBookCart() {
        super();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int book_id=Integer.parseInt(req.getParameter("book_id"));
		int userid=Integer.parseInt(req.getParameter("userid"));
		int cid=Integer.parseInt(req.getParameter("cid"));

		CartDAOImpl dao=new CartDAOImpl(DBConnect.getConn());
		boolean f= dao.deleteBook(book_id,userid,cid);
		
		HttpSession session=req.getSession();
		if(f) {
			
			session.setAttribute("succMsg","Delete Successfully");
			resp.sendRedirect("checkout.jsp");
			
			
		}
		else {
			session.setAttribute("failedMsg","Delete Successfully");
			resp.sendRedirect("checkout.jsp");
			
		}
	}

	
}
