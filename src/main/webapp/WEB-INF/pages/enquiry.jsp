<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Counsellor Registration</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="card">

			<div class="card-header bg-primary">
				<h3 lass="d-inline-flex p-2">Counsellor Login</h3>
			</div>
			<div class="card-body">

				<form:form modelAttribute="enquiry" method="POST" action="addEnquiry">

					
					<div class="form-group">
						<label class="sr-only" for="enqName">Name:</label>
						<form:input path="enqName"
							class="form-control border border-secondary" id="enqName" />
					</div>
					

					<div class="form-group">
						<label class="sr-only" for="mobile">mobile:</label>
						<form:input path="mobile"
							class="form-control border border-secondary" id="mobile" />
					</div>
					
					<div class="form-group">
						<label class="sr-only" for="classMode">Class Mode:</label>
						<form:select path="classMode" class="form-control border border-secondary">
							<option value="">--select--</option>
							<option value="">Online</option>
							<option value="">Offline</option>
						</form:select>
						
					</div>
					
					<div class="form-group">
						<label class="sr-only" for="course">course:</label>
						<form:select path="course" class="form-control border border-secondary">
							<option value="">--select--</option>
							<option value="Java">Java</option>
							<option value="spring">spring</option>
							<option value="Springboot">Spring boot</option>
							<option value="React">React</option>
							<option value="AWS">AWS</option>
							<option value="Microservice">Microservice</option>
						</form:select>
						
					</div>
					<div class="form-group">
						<label class="sr-only" for="status">status:</label>
						<form:select path="status" class="form-control border border-secondary">
							<option value="">--select--</option>
							<option value="O">Open</option>
							<option value="C">Closed</option>
							<option value="E">Enroll</option>
							<option value="L">Lost</option>
						</form:select>
						
					</div>
					
					<br>
					<br>
					<button type="submit" class="btn btn-primary">Register</button>
					<button type="reset" class="btn btn-primary">Reset</button>

				</form:form>



			</div>
			<div class="card-footer bg-primary">
				<h3>card footer</h3>
			</div>
		</div>
	</div>






</body>
</html>
