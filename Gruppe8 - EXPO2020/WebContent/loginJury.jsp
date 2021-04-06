
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<link rel="stylesheet"href="css/NewFile.css">
<title>Logginn</title>
	<script src="js/DeltagerValidering.js" defer></script> 
<body>



<div id="stand" class="container">
<form action="juryloginservlet" method="post">
 
	  <div class="innhold">
	    <h1>Jury login</h1>
	    <label for="arrangement">Velg Arrangement:</label>
	    <select name="arrangement" id="arrangement">
		    <c:forEach items="${liste}" var="arrangement">
				<option value="${arrangement.navn}">${arrangement.navn}</option>
			</c:forEach>
  		</select>
  		<br>
  		<br>
		<label for="kode" ><b>Passord (12345) </b></label>
		<font color="red"> ${ugyldigJuryPassord}</font>
		<br>
		<input class="noInput" type="password" placeholder="Skriv inn passord" name="passord">
		<br>

	    <button type="submit" class="registerbtn" name="button"><b>Login</b></button>
	    <br>
	    <br>
	  </div>

	</form>
 <div class="signin">
  		<p>Gå tilbake til <a href="index.html">tilgang</a></p>

  </div>
 
  </div>
  
 

</body>
</html>
