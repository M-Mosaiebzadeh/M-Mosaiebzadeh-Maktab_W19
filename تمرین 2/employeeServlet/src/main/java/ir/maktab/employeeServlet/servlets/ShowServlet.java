package ir.maktab.employeeServlet.servlets;

import ir.maktab.employeeServlet.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static ir.maktab.employeeServlet.util.EntityManagerFactoryUtil.*;

public class ShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        EntityManager entityManager = createEntityManagerFactory().createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);

        query.select(query.from(Employee.class));
        TypedQuery<Employee> typedQuery = entityManager.createQuery(query);

        List<Employee> employeeList = typedQuery.getResultList();

        req.setAttribute("list",employeeList);

        req.getRequestDispatcher("second.jsp").forward(req,resp);


//        out.println("<table border='2px'>\n" +
//                "<tr>\n" +
//                "    <th>\n" +
//                "        firstname\n" +
//                "    </th>\n" +
//                "    <th>\n" +
//                "        lastname\n" +
//                "    </th>\n" +
//                "    <th>\n" +
//                "        email\n" +
//                "    </th>\n" +
//                "</tr>");
//
//        for (Employee employee : employeeList) {
//
//            out.println("<tr>");
//            out.println("<td>");
//            out.println(employee.getFirstname());
//            out.println("</td>");
//            out.println("<td>");
//            out.println(employee.getLastname());
//            out.println("</td>");
//            out.println("<td>");
//            out.println(employee.getEmail());
//            out.println("</td>");
//            out.println("</tr>");
//
//        }
//
//        out.println("</table><br>");
//
//        out.println("<h3><a href ='index.html'> back to menu </a></h3>");

        out.close();
        entityManager.close();

    }
}
