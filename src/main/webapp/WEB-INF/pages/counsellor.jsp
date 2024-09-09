<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Counsellor Registration</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">
    <div class="card">

        <div class="card-header bg-primary"><h3 lass="d-inline-flex p-2">Counsellor Registration</h3></div>
        <div class="card-body">

<form:form modelAttribute="counsellor" method="POST" action="enroll">

<div class="form-group">
                  <label class="sr-only" for="email">Name:</label>
                  <form:input path="counsellorName" class="form-control border border-secondary" id="counsellorName"/>
                </div>
                <div class="form-group">
                  <label class="sr-only" for="email">Email:</label>
                  <form:input path="email" class="form-control border border-secondary" id="email"/>
                </div>
                <div class="form-group">
                  <label class="sr-only" for="email">Mobile:</label>
                  <form:input path="mobile" class="form-control border border-secondary" id="mobile"/>
                </div>
               
                <div class="form-group">
                  <label class="sr-only" for="pwd">Password:</label>
                  <form:input path="password" class="form-control border border-secondary" id="password"/>
                </div>
                <div class="checkbox">
                 
                </div>
                <button type="submit" class="btn btn-primary">Register</button>

</form:form>
            


        </div>
        <div class="card-footer bg-primary"><h3>card footer</h3></div>
    </div>
</div>






</body>
</html>
