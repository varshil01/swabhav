<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<s:head />
</head>

<body>
	<h1>
		MethodType is:
		<s:property value="methodtype"></s:property>
	</h1>
	<s:form action="addstudentpost" method="post">

		<s:textfield type="number" name="studentBeam.rollno" label="Rollno"
			value=""></s:textfield>
		<s:textfield name="studentBeam.fname" label="First Name"></s:textfield>
		<s:textfield name="studentBeam.lname" label="Last Name"></s:textfield>
		<!--<s:textfield name="studentBeam.clg_id" label="College Id"></s:textfield>-->
		<s:select list="%{studentBeam.hashOfColleges}" label="Select college"
			headerKey="-1" headerValue="Select College name"
			name="studentBeam.clg_id" listKey="key" listValue="value"></s:select>
		<s:textfield type="number" name="studentBeam.cgpi" label="CGPI"
			value=""></s:textfield>
		<s:radio name="studentBeam.gender" label="Gender"
			list="#{'Male':'Male','Female':'Female','Others':'Others'}"></s:radio>

		<s:submit value="ADD"></s:submit>
	</s:form>
</body>
</html>