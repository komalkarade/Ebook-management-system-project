package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookDAOImpl;
import com.DB.DBConnect;

public class DeleteOldBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteOldBook() {
        super();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String email=req.getParameter("email");
			int book_id=Integer.parseInt(req.getParameter("book_id"));
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
			boolean f = dao.oldBookDelete(email, "Old",book_id);

			HttpSession session = req.getSession();

			if (f) {
				session.setAttribute("succMsg", "Book Delete Successfully.....");
				resp.sendRedirect("old_book.jsp");

			} else {
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("old_book.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
