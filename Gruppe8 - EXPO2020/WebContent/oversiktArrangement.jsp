<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<link rel="stylesheet"href="css/NewFile.css">
<title>EXPO2021</title> 
<body>

<div id="stand" class="container">

	 <div class="innhold">
	  
	   <h1>Arrangementer</h1>

	   <hr>
	    
	   <c:forEach items="${liste}" var="arrangement">
			
			<form action="arrangementservlet" method="get">
				<button type="submit"
						class="registerbtn" 
						name="navn" 
						value="${arrangement.navn}">
						<b>${arrangement.navn}</b>
				</button>
			</form>
	    
		   	<br>
		   	<br>
		   	<br>
	    
		</c:forEach>
	  
	  </div>

  </div>

</body>
</html>
