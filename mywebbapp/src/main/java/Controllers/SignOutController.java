package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signout")
public class SignOutController extends HttpServlet{
    

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws  ServletException, IOException {

        HttpSession httpSession = req.getSession();
		
		httpSession.removeAttribute("userActive");
        httpSession.removeAttribute("user");

        res.sendRedirect("/mywebbapp/");

    }
}
