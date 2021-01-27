<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Soheil
  Date: 1/26/2021
  Time: 4:02 PM
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
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie:cookies) {
        if (cookie.getName().equals("user")){
            writer.println("Welcome Back " + cookie.getValue() + " .....");
            request.getRequestDispatcher("userPage.jsp").forward(request,response);
            break;
        }
    }
%>
    <form action="login" method="post">
        Username : <input type="text" name="username" ><br>
        Password : <input type="password" name="password" ><br>
        <input type="submit" name="submit" value="login"><br>
        <br>
    </form>
    <a href="signUp.jsp">Sign up</a>
</body>
</html>
