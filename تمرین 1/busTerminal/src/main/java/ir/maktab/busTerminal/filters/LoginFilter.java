package ir.maktab.busTerminal.filters;

import ir.maktab.busTerminal.entities.User;
import ir.maktab.busTerminal.util.EntityManagerFactoryUtil;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static ir.maktab.busTerminal.util.EntityManagerFactoryUtil.*;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();

        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");

        if (isExistUser(username,password).size() != 0){
            servletRequest.setAttribute("user",isExistUser(username,password).get(0));
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            out.println("<center><h3>");
            out.println("username " + username + " not found!!");
            out.println("please sign up first!");
            out.println("</h3></center>");

            servletRequest.getRequestDispatcher("login.jsp").include(servletRequest,servletResponse);
        }
    }

    private List<User> isExistUser(String username, String password) {

        EntityManager entityManager = createEntityManagerFactory().createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> fromUser = query.from(User.class);

        query.select(fromUser).where(builder.and(
                builder.equal(fromUser.get("username"),username),
                builder.equal(fromUser.get("password"),password)
        ));

        TypedQuery<User> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

    @Override
    public void destroy() {

    }
}
