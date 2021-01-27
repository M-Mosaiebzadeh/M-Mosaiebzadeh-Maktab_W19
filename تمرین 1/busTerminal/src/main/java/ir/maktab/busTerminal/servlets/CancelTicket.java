package ir.maktab.busTerminal.servlets;

import ir.maktab.busTerminal.dao.TicketDao;
import ir.maktab.busTerminal.entities.Ticket;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static ir.maktab.busTerminal.util.EntityManagerFactoryUtil.*;

public class CancelTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        EntityManager entityManager = createEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Ticket ticket = (Ticket) req.getAttribute("ticketForDel");
        TicketDao ticketDao = new TicketDao(entityManager);
        ticketDao.delete(entityManager.contains(ticket) ? ticket : entityManager.merge(ticket));

        entityManager.getTransaction().commit();
        entityManager.close();

        out.println("<center><h3>");
        out.println("Ticket (Ticket ID : " + ticket.getId() + " ) is deleted");
        out.println("</h3></center>");
        req.getRequestDispatcher("userPage.jsp").include(req,resp);


    }
}
