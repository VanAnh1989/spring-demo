<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources/css/home.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
</head>
<body>
	<div class="login-page">
		<div class="form">
			<form class="register-form">
				<input type="text" placeholder="name" /> <input type="password"
					placeholder="password" /> <input type="text"
					placeholder="email address" />
				<button>create</button>
				<p class="message">
					Already registered? <a href="#">Sign In</a>
				</p>
			</form>
			<form class="login-form" action="Insert.html" method="Get">
				<input type="text" placeholder="username" name="user"/> 
				<input type="password" placeholder="password" name="pass"/>
				<input type="submit" value="Register" />
				<p class="message">
					Not registered? <a href="#">Create an account</a>
				</p>
				<p>${Error}</p>
			</form>
		</div>
	</div>
</body>
</html>