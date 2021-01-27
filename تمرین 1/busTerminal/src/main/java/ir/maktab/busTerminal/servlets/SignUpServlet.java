package ir.maktab.busTerminal.servlets;

import ir.maktab.busTerminal.dao.UserDao;
import ir.maktab.busTerminal.entities.User;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static ir.maktab.busTerminal.util.EntityManagerFactoryUtil.*;

public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntityManager entityManager = createEntityManagerFactory().createEntityManager();
        UserDao userDao = new UserDao(entityManager);
        entityManager.getTransaction().begin();

        User user = new User();
        user.setFirstname(req.getParameter("firstname"));
        user.setLastname(req.getParameter("lastname"));
        user.setPhoneNumber(req.getParameter("phoneNumber"));
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        userDao.save(user);
        entityManager.getTransaction().commit();
        entityManager.close();


        req.getRequestDispatcher("login.jsp").forward(req,resp);


    }
}
