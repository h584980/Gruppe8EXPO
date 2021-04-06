
<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"/>


    

<html>
<head>
<meta charset="UTF-8"/>
</head>
<link rel="stylesheet" href="css/NewFile.css"/>
<title>Registrering</title>
<script src="js/ArrangementValidering.js" defer></script> 
<body>



<div id="stand" class="container">
<form action="arrangementservlet" method="post">
  
	  <div class="innhold">
	    <h1>Registrering av Arrangement</h1>
	    <hr/>
		<label for="navn"><b>Navn </b></label>
		<font color="red">${ugyldigNavn}</font>
		<br/>
		<input class="noInput" type="text" placeholder="Skriv inn navn på arrangement" name="navn" value="${gyldigNavn}"/>
		<br/>
		<label for="birthday">Startdato:</label>
  		<input type="date" id="birthday" name="startDato">
		<br>
		<label for="birthday">Sluttdato:</label>
  		<input type="date" id="birthday" name="sluttDato">
		<br>
		<label for="appt">Starttid:</label>
  		<input type="time" id="appt" name="startTid">
  		<br>
  		<label for="appt">Sluttid:</label>
  		<input type="time" id="appt" name="sluttTid">

		<br/>

	    <button type="submit" class="registerbtn" name="button"><b>Registrer</b></button>
	    <br/>
	    <hr/>
	  </div>

	</form>

 <div class="signin">
  		<p>Gå tilbake til <a href="index.jsp">Meny</a></p>

  </div>
 
  </div>
  
 

</body>
</html>
