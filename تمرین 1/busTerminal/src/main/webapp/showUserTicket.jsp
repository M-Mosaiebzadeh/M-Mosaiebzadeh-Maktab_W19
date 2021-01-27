<%@ page import="java.util.List" %>
<%@ page import="ir.maktab.busTerminal.entities.Ticket" %><%--
  Created by IntelliJ IDEA.
  User: Soheil
  Date: 1/27/2021
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<label>Buying Ticket List</label>
<br><br>
<table  class="table table-striped" border="2px">
    <tr>
        <td>
            Choose
        </td>
        <td>
            Ticket ID
        </td>
        <td>
            Date
        </td>
    </tr>

    <%
        List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets");
    %>

    <%
        for (Ticket ticket:tickets) {

    %>
    <tr>
        <td>
<%--            <form action="fullDetailTicket" method="get">--%>
<%--                <input type="hidden" name="ticket" value="<%=ticket.getId()%>">--%>
<%--                <input type="submit" name="submit" value="Show Tickets">--%>
<%--            </form>--%>
            <a href="fullDetailTicket?action=show&ticket=<%=ticket.getId()%>">Show Detail</a>
        </td>
        <td>
            <%= ticket.getId()%>
        </td>
        <td>
            <%= ticket.getTravel().getDate()%>
        </td>
    </tr>

    <%

        }
    %>
</table>
</body>
</html>
