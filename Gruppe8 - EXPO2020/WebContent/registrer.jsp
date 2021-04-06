
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<link rel="stylesheet"href="css/NewFile.css">
<title>Registrering</title>
	<script src="js/RegistreringsValidering.js" defer></script> 
<body>



<div id="stand" class="container">
<form action="registreringsservlet" method="post">
  
	  <div class="innhold">
	    <h1>Registrering av stand</h1>
	    <hr>
		<label for="navn"><b>Navn </b></label>
		<font color="red">${ugyldigNavn}</font>
		<br>
		<input class="noInput" type="text" placeholder="Skriv inn navn på stand" name="navn" value="${gyldigNavn}">
		<br>
		<label for="arrangement">Velg Arrangement:</label>
	    <select name="arrangement" id="arrangement">
		    <c:forEach items="${liste}" var="arrangement">
				<option value="${arrangement.navn}">${arrangement.navn}</option>
			</c:forEach>
  		</select>
		<br>

	    <button type="submit" class="registerbtn" name="button"><b>Registrer</b></button>
	    <br>
	    <br>
	    <hr>
	  </div>

	</form>

 <div class="signin">
  		<p>Gå tilbake til <a href="index.jsp">Meny</a></p>

  </div>
 
  </div>
  
 

</body>
</html>
