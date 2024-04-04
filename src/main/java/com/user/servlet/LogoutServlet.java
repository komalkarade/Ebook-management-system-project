package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession(false); 
            
            if (session != null) {
                session.invalidate(); 
            }
            
            HttpSession newSession = req.getSession(true); 
            newSession.setAttribute("succMsg", "Logout Successfully"); 
            
            resp.sendRedirect("login.jsp"); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
