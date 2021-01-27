<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Soheil
  Date: 1/27/2021
  Time: 12:18 PM
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
    String gender = request.getParameter("gender");
    String fullName = request.getParameter("name");
    Integer ticketId = (Integer) request.getAttribute("ticketId");
    String callGender;
    if (gender.equals("male")){
        callGender = "Mr";
    }
    else {
        callGender = "Ms";
    }

%>
    <p><% writer.println(callGender + " " + fullName + " Your ticket purchase was successful");
        writer.println("Ticket ID is : " + ticketId);
    %></p>
<br>
<br>

<% request.getRequestDispatcher("userPage.jsp").include(request,response);%>


</body>
</html>
