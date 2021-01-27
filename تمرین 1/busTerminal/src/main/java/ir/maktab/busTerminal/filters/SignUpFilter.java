package ir.maktab.busTerminal.filters;

import ir.maktab.busTerminal.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static ir.maktab.busTerminal.util.EntityManagerFactoryUtil.createEntityManagerFactory;

public class SignUpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        String username = servletRequest.getParameter("username");
        if (isExistUser(username).size() == 0){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            out.println("<center><h3>");
            out.println("username " + username + " is exist!!");
            out.println("please sign in ...");
            out.println("</h3></center>");

            servletRequest.getRequestDispatcher("login.jsp").include(servletRequest,servletResponse);

        }
    }

    private List<User> isExistUser(String username) {

        EntityManager entityManager = createEntityManagerFactory().createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> fromUser = query.from(User.class);

        query.select(fromUser).where(builder.equal(fromUser.get("username"),username));

        TypedQuery<User> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

    @Override
    public void destroy() {

    }
}
