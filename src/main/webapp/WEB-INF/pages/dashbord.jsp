<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
<h1>Dashboard</h1>

<table border="1">
    <thead>
        <tr>
            <th>Total Count</th>
            <th>Name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="item" items="${dashboardInfo}">
            <tr>
                <td>${item.totalCount}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<div>
    <h1>Total Enquiry:</h1>
    <p>Enroll Enquiry</p>
    <p>Open Enquiry</p>
    <p>Lost Enquiry</p>
    <p>Closed Enquiry</p>
</div>

</body>
</html>
