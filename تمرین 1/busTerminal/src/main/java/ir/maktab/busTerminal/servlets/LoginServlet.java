package ir.maktab.busTerminal.servlets;

import ir.maktab.busTerminal.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        User user = (User) req.getAttribute("user");

        Cookie cookie = new Cookie("user",user.getUsername());
        cookie.setMaxAge(1000000);
        resp.addCookie(cookie);


        out.println("<center><h3>");
        out.println("Welcome " + user.getFirstname() + " " + user.getLastname() + " ....");
        out.println("</h3></center>");

        req.getRequestDispatcher("userPage.jsp").include(req,resp);


    }
}
