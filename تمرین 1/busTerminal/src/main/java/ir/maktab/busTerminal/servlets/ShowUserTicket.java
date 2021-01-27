package ir.maktab.busTerminal.servlets;

import ir.maktab.busTerminal.dao.UserDao;
import ir.maktab.busTerminal.entities.Ticket;
import ir.maktab.busTerminal.entities.Travel;
import ir.maktab.busTerminal.entities.User;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static ir.maktab.busTerminal.util.EntityManagerFactoryUtil.*;

public class ShowUserTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager entityManager = createEntityManagerFactory().createEntityManager();

        Cookie[] cookies = req.getCookies();
        String username = "";
        for (Cookie cookie:cookies) {
            if (cookie.getName().equals("user")){
                username = cookie.getValue();
                break;
            }
        }

//        UserDao userDao = new UserDao(entityManager);
//        User user = userDao.loadUserByUsername(username).get(0);

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> query = builder.createQuery(Ticket.class);
        Root<Ticket> fromTicket = query.from(Ticket.class);

        query.select(fromTicket)
                .where(builder.equal(fromTicket.get("user").get("username"),username));

        TypedQuery<Ticket> typedQuery = entityManager.createQuery(query);
        List<Ticket> tickets = typedQuery.getResultList();
        req.setAttribute("tickets",tickets);
        req.getRequestDispatcher("showUserTicket.jsp").forward(req,resp);

    }
}
