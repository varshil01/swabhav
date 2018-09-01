<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"
	import="com.techlabs.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
form {
	border: 3px solid #f1f1f1;
	width: 500px
}

input {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0px;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

label {
	margin-top: 20px;
}
</style>


</head>
<body>
	<article>
	<h2>Add Student Form</h2>
	<div>
		<strong>Note:</strong>
		<%
			if (request.getParameter("error") != null) {
				String error = request.getParameter("error");
				out.println("<h2 style='color:red'>" + error + "</h2>");
			}
		%>

	</div>
	<form name="StudentForm" method="POST"
		action="/mvc-student-db-app/addstudent" novalidate>

		<div class="container">
			<div class="row">
				<div class="form-group" class="control-label col-sm-2">
					<label class="control-label col-sm-2" for="fname"> <b>FirstName*</b>
					</label>
					<div class="col-sm-6">
						<input type="text" placeholder="Enter First name" name="fname"
							value="<%=request.getAttribute("fname") == null ? "" : request
					.getAttribute("fname")%>">
					</div>

				</div>
			</div>

			<br>
			<div class="row">
				<div class="form-group">
					<label for="lname" class="control-label col-sm-2"> <b>LastName*</b>
					</label>
					<div class="col-sm-6">
						<input type="text" placeholder="Enter LastName" name="lname"
							value="<%=request.getAttribute("lname") == null ? "" : request
					.getAttribute("lname")%>">

					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="form-group">
					<label for="rollno" class="control-label col-sm-2"> <b>RollNo*</b>
					</label>
					<div class="col-sm-6">
						<input type="number" placeholder="Enter RollNo." name="rollno"
							value="<%=request.getAttribute("unparseroll") == null ? ""
					: request.getAttribute("unparseroll")%>">

					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<label for="cgpi" class="control-label col-sm-2"> <b>CGPI</b>
					</label>
					<div class="col-sm-6">
						<input type="number" placeholder="Enter CGPI" name="cgpi"
							value="<%=request.getAttribute("unparsecgpi") == null ? ""
					: request.getAttribute("unparsecgpi")%>">

					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<label for="clg_id" class="control-label col-sm-2"> <b>ColegeID*</b>
					</label>
					<div class="col-sm-6">
						<select name="clg_id">
						<%
						List<College> listOfNamesAndIdOfColleges=(List)request.getAttribute("listOfNamesAndIdOfColleges");
							for(College college:listOfNamesAndIdOfColleges){
								out.println("<option style='width:500px' value="+college.getClg_ID()+">"+college.getClg_Name()+"</option>");
							}
						%>
							
							</select>

						<!--  	<input type="number" placeholder="Enter College Id" name="clg_id"
							value="<%=request.getAttribute("unparseclg_id") == null ? ""
					: request.getAttribute("unparseclg_id")%>">-->

					</div>
				</div>
			</div>
			<div class="row inline-block">
				<div class="form-group">
					<label for="gender" class="control-label col-sm-2"> <b>Gender*</b>
					</label>
					<div class="col-sm-6">
						<input type="radio" class="col-sm-2" name="gender" id="male" value="male"><label for="male" class="col-sm-1">Male</label><input
							type="radio" class="col-sm-2" name="gender" id="female" value="female"><label for="female" class="col-sm-1">Female</label>



					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group">
					<input type="submit" style="margin-left: 50px"
						class="btn btn-primary col-sm-5"  value="Add">
				</div>
			</div>


		</div>

	</form>
	</article>



</body>
</html>