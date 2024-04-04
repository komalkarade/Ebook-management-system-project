package com.user.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.BookDAOImpl;
import com.DB.DBConnect;
import com.entity.BookDtls;

@MultipartConfig
public class AddOldBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddOldBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
			
			String bookName=req.getParameter("bname");		
			String authore=req.getParameter("author");
			String price=req.getParameter("price");
			String bookCategory="Old";
			String status="Active";
            Part part = req.getPart("bimg");
           String fileName=part.getSubmittedFileName();
           
			String useremail=req.getParameter("user");

           BookDtls b=new BookDtls(bookName,authore,price,bookCategory,status,fileName,useremail);
           
           BookDAOImpl dao=new BookDAOImpl(DBConnect.getConn());
           
        
        Boolean f= dao.addBooks(b);
            
          
          HttpSession session=req.getSession();
          
          if(f) {
        	  
        	  String path=   getServletContext().getRealPath("")+"book";
              
              
              File file=new File(path);
              part.write(path+File.separator+fileName);
        	  
        	  session.setAttribute("succMsg", "Book Add successfully");
        	  resp.sendRedirect("sell_book.jsp");
          }
          
          else {
        	  session.setAttribute("failedMsg", "Something wrong on server");
        	  resp.sendRedirect("sell_book.jsp");
          }

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
