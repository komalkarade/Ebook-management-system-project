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

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			String name= req.getParameter("fname");
			String email=req.getParameter("email");
			String phno=req.getParameter("phno");
			String password=req.getParameter("password");
			String adress=req.getParameter("adress");
			String check=req.getParameter("check");
			String landmark=req.getParameter("landmark");
			String city=req.getParameter("city");
			String state=req.getParameter("state");
			String pincode=req.getParameter("pincode");

			
			// System.out.println(name+" "+email+" "+phno+" "+password +" "+check );
			
			User us= new User(0, name, email, phno, password, adress, landmark, city, state, pincode);
			us.setName(name);
			us.setEmail(email);
			us.setPhno(phno);
			us.setPassword(password);
			us.setLandmark(landmark);
			us.setCity(city);
			us.setState(state);
			us.setPincode(pincode);

			
			HttpSession session=req.getSession();
			
			if(check!=null) {
			UserDAOImpl dao=new UserDAOImpl(DBConnect.getConn());
			boolean f=dao.userRegister(us);
			
			if(f) {
				
				
				//System.out.println("User Register Successfully");
				session.setAttribute("succMsg", " Registeration Successfully....");
				resp.sendRedirect("register.jsp");
			}
			else {
				
				//System.out.println("Something wrong on server...");
				session.setAttribute("failedMsg", "Something wrong on server...");
				resp.sendRedirect("register.jsp");
			}
			
			}
			else {
				
				
				
				//System.out.println("Please check Terms and condition");
				session.setAttribute("failedMsg", "Please check Terms and condition");
				resp.sendRedirect("register.jsp");
			}
			
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
