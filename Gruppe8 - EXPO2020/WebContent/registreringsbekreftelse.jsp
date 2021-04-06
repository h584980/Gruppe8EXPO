<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"href="css/NewFile.css">
<title>Registreringsbekreftelse</title>
</head>
<body>
	<div id="stand" class="container">
	<div class="innhold">
		<h2>Registreringsbekreftelse</h2>
		<p>Registrering er mottatt for Stand:</p>
		<p>
			<c:forEach items="${liste}" var="stand">	
			<p>&nbsp;&nbsp;&nbsp;${stand.navn}</p>		
			</c:forEach>
			&nbsp;&nbsp;&nbsp;${nyttStand.navn}
		</p>
		
		
	</div>
	<div class="signin">
				<p>Gå tilbake til <a href="index.jsp">Meny</a></p>
				
		</div>
	</div>
</body>
</html>