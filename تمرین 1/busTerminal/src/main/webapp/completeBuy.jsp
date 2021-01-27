<%--
  Created by IntelliJ IDEA.
  User: Soheil
  Date: 1/27/2021
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="finalConfirm" method="get">
        Full name : <input type="text" name="name"><br>
        <input type="radio" id="male" name="gender" value="male">
        <label for="male">Male</label><br>
        <input type="radio" id="female" name="gender" value="female">
        <label for="female">Female</label><br><br>
<%--        <%request.setAttribute("myTravel",request.getAttribute("myTravel"));%>--%>
        <input type="submit" name="submit" value="Confirm">
    </form>
</body>
</html>
