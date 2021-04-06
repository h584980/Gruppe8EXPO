<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"href="css/NewFile.css">
<title>Oversikt</title>
</head>
<body>
<div id="deltager" class="container">
			<div class="innholdOversikt">
			<h1>Oversikt</h1>
			<hr>
			<table>
					<tr bgcolor="#ddd">
						<th>Stand</th>
						<th>Snittrating</th>
						<th>Antall stemmer</th>
					</tr>
					<c:forEach items="${liste}" var="stand">
					<tr bgcolor="#f1f1f1">
						<td>
						<form action="standservlet" method="get">
							<button type="submit" 
									name="navn" 
									value="${stand.navn}">
									<b>${stand.navn}</b>
							</button>
						</form>
						</td>
						<td align="center">
							${stand.snittStemme}
						</td>
						<td align="center">
							${stand.antallStemmer}
						</td>
					</tr>
					</c:forEach>
			</table>
				<br>
				<hr>
			</div>
			<div class="signin">
  				<p>
						<p>Gå tilbake til <a href="index.jsp">Meny</a></p>
					
  			</div>

 		 </div>
	</body>
</html>