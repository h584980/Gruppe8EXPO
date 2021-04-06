
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

<form action="adminloginservlet" method="post">
  
	  <div class="innhold">
	    <h1>Admin login</h1>
		<label for="kode" ><b>Passord (12345) </b></label>
		<font color="red"> ${ugyldigAdminPassord}</font>
		<br>
		<input class="noInput" type="password" placeholder="Skriv inn passord" name="passord">
		<br>

	    <button type="submit" class="registerbtn" name="button"><b>Login</b></button>
	    <br>
	    <br>
	    <hr>
	  </div>

	</form>

 <div class="signin">
  		<p>Gå tilbake til <a href="index.html">tilgang</a></p>

  </div>
 
  </div>
  
 

</body>
</html>
