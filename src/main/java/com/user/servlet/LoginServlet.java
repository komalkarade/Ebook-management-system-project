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


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
            HttpSession session = req.getSession();
            
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
                User adminUser = new User(0, "Admin", email, "", password, "", "", "", "", "");
                session.setAttribute("userobj", adminUser);
                resp.sendRedirect("admin/home.jsp");
                return; // Terminate the method after redirection
            }

            User user = dao.login(email, password);
            if (user != null) {
                session.setAttribute("userobj", user);
                resp.sendRedirect("index.jsp");
                return; // Terminate the method after redirection
            } else {
                session.setAttribute("failedMsg", "Email & Password Invalid");
                resp.sendRedirect("login.jsp");
                return; // Terminate the method after redirection
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}