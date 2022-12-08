package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.UserDetails;

@WebServlet("/loguser")
public class Login extends HttpServlet{

    UserDetails user1 = new UserDetails("admin", "password");
    UserDetails user2 = new UserDetails("user", "password");

    public void doGet(HttpServletRequest req, HttpServletResponse res)  throws  ServletException, IOException {

        HttpSession httpSession = req.getSession();

        if(httpSession.getAttribute("userActive") != null){

            req.getRequestDispatcher("./views/dashboard.jsp").forward(req, res);

        }else{
            res.sendRedirect("/mywebbapp/");
        }
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws  ServletException, IOException {

        String name = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession httpSession = req.getSession();

        if(user1.getUsername().equals(name) && user1.getPassword().equals(password) ||
            user2.getUsername().equals(name) && user2.getPassword().equals(password)){

            user1.setFavObj(req.getParameter("favoriteItem"));
            user2.setFavObj(req.getParameter("favoriteItem"));

            if(user1.getUsername().equals(name)){
                httpSession.setAttribute("user", user1);
            }else if(user2.getUsername().equals(name)){
                httpSession.setAttribute("user", user2);
            }

            httpSession.setAttribute("userActive", "user is now active");
            httpSession.setMaxInactiveInterval(30);

            req.getRequestDispatcher("./views/dashboard.jsp").forward(req, res);

        }else{
            req.setAttribute("wronglog", true);
            req.getRequestDispatcher("index.jsp").forward(req, res);
        }    
    }
}
