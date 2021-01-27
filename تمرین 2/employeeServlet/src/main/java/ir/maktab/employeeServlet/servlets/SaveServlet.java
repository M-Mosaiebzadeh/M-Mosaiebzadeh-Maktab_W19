package ir.maktab.employeeServlet.servlets;


import ir.maktab.employeeServlet.entities.Employee;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static ir.maktab.employeeServlet.util.EntityManagerFactoryUtil.*;


public class SaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");

        EntityManager entityManager = createEntityManagerFactory().createEntityManager();
        PrintWriter out = response.getWriter();
        entityManager.getTransaction().begin();

        Employee employee = new Employee();
        employee.setFirstname(request.getParameter("firstname"));
        employee.setLastname(request.getParameter("lastname"));
        employee.setEmail(request.getParameter("email"));

        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();


        out.println("<center><h2>");
        out.println(request.getParameter("firstname") +
                " " + request.getParameter("lastname") + " successfully added. ");
        out.println("</center></h2>");

        request.getRequestDispatcher("/save.html").include(request,response);
    }
}
