<%--
  Created by IntelliJ IDEA.
  User: Soheil
  Date: 1/26/2021
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="signUp" method="post">
    Firstname : <input type="text" name="firstname" ><br>
    Lastname : <input type="text" name="lastname" ><br>
    Phone Number : <input type="text" name="phoneNumber" ><br>
    Username : <input type="text" name="username" ><br>
    Password : <input type="password" name="password" ><br>
    <input type="submit" name="submit" value="sign up">
    <br>
</form>
<a href="login.jsp">Login</a>

</body>
</html>
