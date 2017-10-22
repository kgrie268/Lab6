package sait.cprg352;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domainclasses.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 742227
 */

public class HomeServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.print(":");
        User user1 = new User();
        //TODO PULL FROM SESSION
        HttpSession session = request.getSession();
        
        if (session.getAttribute("user") == null) {
            response.sendRedirect("login"); 
            
            return;
        }
    
       //String userName= (String)request.getAttribute("userName");
       request.setAttribute("userName", session.getAttribute("user"));
       
       
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            // stop other execution of code
        
           
    }
   
    
    

}
//request.setAttribute("errorMessage", "Invaild username or password");