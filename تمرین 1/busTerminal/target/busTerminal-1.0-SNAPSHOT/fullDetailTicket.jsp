<%@ page import="ir.maktab.busTerminal.entities.Ticket" %><%--
  Created by IntelliJ IDEA.
  User: Soheil
  Date: 1/27/2021
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
Ticket ticket = (Ticket) request.getAttribute("ticket");

%>
<table class="table table-striped" border="2px">
    <tr>
        <td>
            Ticket ID
        </td>
        <td>
            Full Name
        </td>
        <td>
            Gender
        </td>
        <td>
            Origin
        </td>
        <td>
            Destination
        </td>
        <td>
            Date
        </td>
        <td>
            Time
        </td>
        <td>
            Travel ID
        </td>
    </tr>
    <tr>
        <td>
            <%= ticket.getId()%>
        </td>
        <td>
            <%= ticket.getName()%>
        </td>
        <td>
            <%= ticket.getGender()%>
        </td>
        <td>
            <%= ticket.getTravel().getOrigin()%>
        </td>
        <td>
            <%= ticket.getTravel().getDestination()%>
        </td>
        <td>
            <%= ticket.getTravel().getDate()%>
        </td>
        <td>
            <%= ticket.getTravel().getTime()%>
        </td>
        <td>
            <%= ticket.getTravel().getId()%>
        </td>
        <td>
            <form action="cancelTicket" method="get">
                <input type="hidden" name="cancel" value="<%= ticket.getId()%>">
                <input type="submit" name="submit" value="Cancel Ticket">
            </form>
        </td>
    </tr>

</table>
</body>
</html>
