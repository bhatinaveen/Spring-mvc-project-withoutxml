<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Home</h1>
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value=" Logout">

	</form:form>

</body>
</html>