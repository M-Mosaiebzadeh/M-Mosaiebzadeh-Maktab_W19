<%--
  Created by IntelliJ IDEA.
  User: Soheil
  Date: 1/26/2021
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="searchTicket" method="get">
    <label>Choose a origin:</label>
    <select name="origin" id="origin">
        <option value="TEHRAN">TEHRAN</option>
        <option value="MAZANDARAN">MAZANDARAN</option>
        <option value="ESFEHAN">ESFEHAN</option>
        <option value="MARKAZI">MARKAZI</option>
        <option value="QOM">QOM</option>
    </select>
    <br>
    <br>
    <label>Choose a destination:</label>
    <select name="destination" id="destination">
        <option value="TEHRAN">TEHRAN</option>
        <option value="MAZANDARAN">MAZANDARAN</option>
        <option value="ESFEHAN">ESFEHAN</option>
        <option value="MARKAZI">MARKAZI</option>
        <option value="QOM">QOM</option>
    </select>
    <br>
    <br>
    <label>date:</label>
    <input type="date" id="date" name="date">
    <br>
    <br>
    <input type="submit" value="Search Ticket">
</form>

</body>
</html>
