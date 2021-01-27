package ir.maktab.busTerminal.servlets;

import ir.maktab.busTerminal.dao.TicketDao;
import ir.maktab.busTerminal.dao.TravelDao;
import ir.maktab.busTerminal.dao.UserDao;
import ir.maktab.busTerminal.entities.Ticket;
import ir.maktab.busTerminal.entities.Travel;
import ir.maktab.busTerminal.entities.User;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import static ir.maktab.busTerminal.util.EntityManagerFactoryUtil.*;

public class FinalConfirm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        EntityManager entityManager = createEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        HttpSession session = req.getSession(false);
        Travel travel = (Travel) session.getAttribute("myTravel");

        Cookie[] cookies = req.getCookies();
        String username = "";
        for (Cookie cookie:cookies) {
            if (cookie.getName().equals("user")){
                username = cookie.getValue();
                break;
            }
        }
        UserDao userDao = new UserDao(entityManager);
        User user = userDao.loadUserByUsername(username).get(0);


        String name = req.getParameter("name");
        String gender = req.getParameter("gender");

        TicketDao ticketDao = new TicketDao(entityManager);
        Ticket ticket = new Ticket();
        ticket.setName(name);
        ticket.setGender(gender);
        ticket.setUser(user);
        ticket.setTravel(travel);
        ticketDao.save(ticket);

        entityManager.getTransaction().commit();
        entityManager.close();

        req.setAttribute("ticketId",ticket.getId());
        req.getRequestDispatcher("successfulPurchase.jsp").forward(req,resp);
    }
}
