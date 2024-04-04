package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.BookDtls;
import com.DAO.BookDAOImpl;
import com.DB.DBConnect;

public class EditBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditBooksServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id= Integer.parseInt(req.getParameter("id"));
			String bookName=req.getParameter("bname");		
			String authore=req.getParameter("author");
			String price=req.getParameter("price");
			String status=req.getParameter("status");
			
			BookDtls b=new BookDtls();
			b.setBookId(id);
			b.setBookName(bookName);
			b.setAuthor(authore);
			b.setPrice(price);
			b.setStatus(status);
				
			
			BookDAOImpl dao=new BookDAOImpl(DBConnect.getConn());
			boolean f=dao.updateEditBooks(b);
			
			HttpSession session=req.getSession();
			
			if(f) {
				session.setAttribute("succMsg", "Book Update Successfully.....");
				resp.sendRedirect("admin/all_books.jsp");
				
			}
			else {
				 session.setAttribute("failedMsg", "Something wrong on server");
	        	  resp.sendRedirect("admin/all_books.jsp");
			}
			
		} 
		
		
		
		
		catch (Exception e) {			
e.printStackTrace();	
}
		
	}

}
