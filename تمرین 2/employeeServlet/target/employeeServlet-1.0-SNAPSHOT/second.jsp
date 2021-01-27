<%@ page import="java.util.List" %>
<%@ page import="ir.maktab.employeeServlet.entities.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Soheil
  Date: 1/26/2021
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ٍShow Employee</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <table class="table table-striped" border="2px">
        <tr>
            <th>
                Firstname
            </th>
            <th>
                Lastname
            </th>
            <th>
                Email
            </th>
        </tr>
        <%
            List<Employee> employeeList = (List<Employee>) request.getAttribute("list");
        %>
        <%
            for (Employee employee:employeeList) {

        %>
        <tr>
            <td>
                <%= employee.getFirstname()%>
            </td>
            <td>
                <%= employee.getLastname()%>
            </td>
            <td>
                <%= employee.getEmail()%>
            </td>
        </tr>

        <%

            }
        %>

    </table>
</body>
</html>
