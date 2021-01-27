package ir.maktab.busTerminal.servlets;

import ir.maktab.busTerminal.dao.TicketDao;
import ir.maktab.busTerminal.entities.Ticket;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static ir.maktab.busTerminal.util.EntityManagerFactoryUtil.*;

public class FullDetailTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager entityManager = createEntityManagerFactory().createEntityManager();
        TicketDao ticketDao = new TicketDao(entityManager);

        Integer ticketId = Integer.parseInt(req.getParameter("ticket"));
        Ticket ticket = ticketDao.load(ticketId);

        req.setAttribute("ticket",ticket);
        req.getRequestDispatcher("fullDetailTicket.jsp").forward(req,resp);

    }
}
