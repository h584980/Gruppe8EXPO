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
			&nbsp;&nbsp;&nbsp;${nyttStand.navn}
		</p>
		<div class="signin">
			<a href="oversiktservlet">Gå til oversikt</a>
		</div>
	</div>
	</div>
</body>
</html>