package ir.maktab.busTerminal.servlets;

import ir.maktab.busTerminal.dao.TravelDao;
import ir.maktab.busTerminal.entities.Travel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import static ir.maktab.busTerminal.util.EntityManagerFactoryUtil.*;

public class SearchTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

       PrintWriter out = resp.getWriter();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(req.getParameter("date"));
            String origin = req.getParameter("origin");
            String destination = req.getParameter("destination");
            List<Travel> travels = showTravelList(date,origin,destination);
            req.setAttribute("travelList",travels);
            req.getRequestDispatcher("showTickets.jsp").forward(req,resp);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
    public List<Travel> showTravelList(Date date,String origin,String destination) {
        EntityManager entityManager = createEntityManagerFactory().createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Travel> query = builder.createQuery(Travel.class);
        Root<Travel> fromTravel = query.from(Travel.class);
        query.select(fromTravel).where(builder.and(
                builder.equal(fromTravel.get("date"),date),
                builder.and(
                        builder.equal(fromTravel.get("origin"),origin),
                        builder.equal(fromTravel.get("destination"),destination)
                )
        )).orderBy();
        TypedQuery<Travel> typedQuery = entityManager.createQuery(query);
        List<Travel> travels = typedQuery.getResultList();
        travels.sort(Comparator.comparing(Travel::getTime));
        return travels;
    }
}
