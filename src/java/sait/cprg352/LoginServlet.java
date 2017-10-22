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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 742227
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
System.out.println("yooo did it print?");
        //gets parameter action
        //gets the userName
        String userName = (String) request.getAttribute("userName");
        Cookie[] cks = request.getCookies();
        String signOut = "";
        
        //checks through all the cookies ti see if adam or betty are there and displays them
        
        if(cks != null){
        for (int i = 0; i < cks.length; i++) {

            Cookie cookie = cks[i];
            if (cookie != null) {

                if (cookie.getValue().equals("adam")) {
                    request.setAttribute("userName", "adam");
                    request.setAttribute("checked", "checked='checked'");
                    //getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                    signOut = cookie.getValue();
                    System.out.println("addfscds");
//                    return;
                }
                if (cookie.getValue().equals("betty")) {
                    request.setAttribute("userName", "betty");
                    signOut = cookie.getValue();
                    //getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                    System.out.println("vdsvdsds");
//                    return;
                }

            }

        }
        }
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        //checks to sww if action is done and will display logged out message
        if (session.getAttribute("user") != null) {
            if (action != null && action.equals("logout")) {
                request.setAttribute("errorMessage", "Logged out");
                request.setAttribute("userName", signOut);
                session.removeAttribute("user");

                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
        }
        if (session.getAttribute("user") != null) {
            response.sendRedirect("home");

            return;
        }

        // String checked = request.getParameter("checkBox");
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        // stop other execution of code

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        //request.setAttribute("age2", age);
        // validation
        System.out.print("your OK");
        if (userName == null || userName.isEmpty() || passWord == null || passWord.isEmpty()) {
            // set error message

            request.setAttribute("errorMessage", "Both values are required");

            // forward the request back to login page.jsp
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            // stop other execution of code
            return;
        }
        //makes a user
        User user = new User();

        user.setUserName(userName);
        user.setPassWord(passWord);
        UserService userClass = new UserService();
        //Checks if user object has a username and password and if null then
        if (userClass.login(user.getUserName(), user.getPassWord()) != null) {

            //makes a session
            HttpSession session = request.getSession();
            session.setAttribute("user", user.getUserName());
            Cookie ck = new Cookie("cookieUser", user.getUserName());
            //this adds a cookie if the user clicks remmber me
            if (request.getParameter("checkBox") != null && request.getParameter("checkBox").equals("add")) {
                //store if the checkbox is checked
                System.out.print("Ello mate!!!");

                response.addCookie(ck);
            } else {

                ck.setMaxAge(0);
                response.addCookie(ck);
            }
            response.sendRedirect("home");

            //else{
            //request.setAttribute("user", user);
            //System.out.print("yoooo");
            //getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); 
            //response.sendRedirect("Name");
        } else {
            System.out.print("yaaaaa");
            request.setAttribute("userName", userName);
            request.setAttribute("passWord", passWord);
            request.setAttribute("errorMessage", "Invaild username or password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

        // stop other execution of code
    }

}
