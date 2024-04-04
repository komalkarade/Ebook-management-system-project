package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import com.entity.User;

public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateProfileServlet() {
		super();
	}
	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("fname");
			String email=req.getParameter("email");
			String phno=req.getParameter("phno");
			String password=req.getParameter("password");
			
			User us=new User(id, "", "", "", "", "", "", "", "", "");
			us.setId(id);
			us.setName(name);
			us.setEmail(email);
			us.setPhno(phno);
			
			HttpSession session=req.getSession();
			UserDAOImpl dao=new UserDAOImpl(DBConnect.getConn());
			
			boolean f=dao.checkPassword(id, password);
			if(f)
			{
				boolean f2=dao.updateProfile(us);
				if(f2)
				{
					session.setAttribute("succMsg","Profile Update Successfully..");
					resp.sendRedirect("Edit_profile.jsp");
				}else {
					session.setAttribute("failedMsg","Something wrong on server");
					resp.sendRedirect("Edit_profile.jsp");
				}
					
			}else {
				session.setAttribute("failedMsg","Your Password is Incorrect");
				resp.sendRedirect("Edit_profile.jsp");
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}