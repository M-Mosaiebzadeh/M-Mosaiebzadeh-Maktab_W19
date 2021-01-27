package ir.maktab.employeeServlet.filters;

import ir.maktab.employeeServlet.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static ir.maktab.employeeServlet.util.EntityManagerFactoryUtil.*;

public class SaveFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html");
        EntityManager entityManager = createEntityManagerFactory().createEntityManager();
        PrintWriter out = servletResponse.getWriter();
//        entityManager.getTransaction().begin();
        String firstname = servletRequest.getParameter("firstname");
        String lastname = servletRequest.getParameter("lastname");
        String email = servletRequest.getParameter("email");

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> fromEmployee = query.from(Employee.class);

        query.select(fromEmployee).where(builder.and(
                builder.and(
                        builder.equal(fromEmployee.get("firstname"),firstname),
                        builder.equal(fromEmployee.get("lastname"),lastname)
                ),
                builder.equal(fromEmployee.get("email"),email)
        ));

        TypedQuery<Employee> typedQuery = entityManager.createQuery(query);

        List<Employee> employee = typedQuery.getResultList();

        if (employee.size() == 0){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else {
            out.println("<center");
            out.println("<p style='font-size:40px;color:red;'>");
            out.println("This Person now exist");
            out.println("</p></center>");
            servletRequest.getRequestDispatcher("save.html").include(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
