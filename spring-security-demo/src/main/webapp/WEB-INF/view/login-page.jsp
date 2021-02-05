<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
	<h1>Welcome To Patel Parts</h1>
	<form:form action="${pageContext.request.contextPath}homePage"
		method="POST">
		<c:if test="${param.error!=null}">
		<h1>Sorry Passowrd Wrong</h1>
		</c:if>
		
		
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