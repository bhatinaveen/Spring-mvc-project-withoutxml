<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
	<h1>Welcome To Patel Parts</h1>
	<form:form action="${pageContext.request.contextPath}/homePage"
		method="POST">
		<p>
			UserName <input type="text" name="username">

		</p>
		<p>
			Password <input type="password" name="password">

		</p>
		<input type="submit" value="Login">
	</form:form>


</body>
</html>