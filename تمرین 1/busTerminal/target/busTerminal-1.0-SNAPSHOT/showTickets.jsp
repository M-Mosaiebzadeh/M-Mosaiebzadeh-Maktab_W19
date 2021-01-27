<%@ page import="java.util.List" %>
<%@ page import="javax.sound.midi.Track" %>
<%@ page import="ir.maktab.busTerminal.entities.Travel" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Soheil
  Date: 1/27/2021
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    PrintWriter writer = response.getWriter();
String date = request.getParameter("date");
String origin = request.getParameter("origin");
String destination = request.getParameter("destination");

%>
<label><% writer.println("Route:  " + origin + " - " + destination); %></label>
<br>
<br>
<label><% writer.println("Date of Departure: " + date); %></label>
<br>
<br>
<table class="table table-striped" border="2px">
    <tr>
        <th>
            Choose
        </th>
        <th>
            Departure Time
        </th>
        <th>
            Travel ID
        </th>
    </tr>

    <%
        List<Travel> travelList = (List<Travel>) request.getAttribute("travelList");
    %>

        <%
            for (Travel travel:travelList) {

        %>
    <tr>
        <td>
            <form action="completeBuy.jsp" method="get">
                <%
                    HttpSession session1 = request.getSession();
                    session1.setAttribute("myTravel",travel);
                %>
                <input type="submit" name="submit" value="Buy">
            </form>
        </td>
        <td>
            <%= travel.getTime()%>
        </td>
        <td>
            <%= travel.getId()%>
        </td>
    </tr>

        <%

            }
        %>
    <br>
    <br>
    <a href="searchTicket.jsp"> Back to Buy Ticket</a>
</body>
</html>
