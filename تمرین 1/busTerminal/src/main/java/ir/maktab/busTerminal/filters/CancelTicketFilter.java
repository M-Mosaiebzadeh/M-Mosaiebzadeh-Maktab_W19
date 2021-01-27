package ir.maktab.busTerminal.filters;

import ir.maktab.busTerminal.dao.TicketDao;
import ir.maktab.busTerminal.entities.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static ir.maktab.busTerminal.util.EntityManagerFactoryUtil.*;

public class CancelTicketFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        EntityManager entityManager = createEntityManagerFactory().createEntityManager();

        PrintWriter out = servletResponse.getWriter();
        servletResponse.setContentType("text/html");

        TicketDao ticketDao = new TicketDao(entityManager);
        Integer cancelTicketId = Integer.parseInt(servletRequest.getParameter("cancel"));
        Ticket ticket = ticketDao.load(cancelTicketId);


        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");

        try {
            Date nowDate = formatterDate.parse(formatterDate.format(new Date()));
//            Date nowTime = formatterTime.parse(formatterTime.format(new Date()));
//
//            if (ticket.getTravel().getTime().after(nowTime)){
//
//            } else {
//                out.println("<center><h3>");
//                out.println("your ticket is expired...sorry");
//                out.println("</h3></center>");
//                servletRequest.getRequestDispatcher("userPage.jsp").include(servletRequest, servletResponse);
//            }
            if (ticket.getTravel().getDate().after(nowDate)) {
                servletRequest.setAttribute("ticketForDel",ticket);
                filterChain.doFilter(servletRequest, servletResponse);

            } else {
                out.println("<center><h3>");
                out.println("your ticket is expired...sorry");
                out.println("</h3></center>");
                servletRequest.getRequestDispatcher("userPage.jsp").include(servletRequest, servletResponse);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
