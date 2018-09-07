<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form action="/editstudent" method="post">
		<s:hidden type="number" name="studentBeam.rollno" label="Rollno"
			value="%{studentBeam.rollno}"></s:hidden>

		<s:textfield name="studentBeam.fname" label="First Name"
			value="%{studentBeam.fname}"></s:textfield>
		<s:textfield name="studentBeam.lname" label="Last Name"
			value="%{studentBeam.lname}"></s:textfield>
		<s:textfield type="number" name="studentBeam.cgpi" label="CGPI"
			value="%{studentBeam.cgpi}"></s:textfield>
		<s:radio name="studentBeam.gender" label="Gender"
			list="#{'1':'Male','2':'Female','3':'Others'}"
			value="%{=studentBeam.gender}"></s:radio>
		<s:hidden name="methodtype" value="POST"></s:hidden>
		<s:submit value="Update"></s:submit>
	</s:form>


</body>
</html>