<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bulkregistrering</title>
</head>
<link rel="stylesheet"href="css/NewFile.css">
<body>

<div id="stand" class="container">

  
	  <div class="innhold">
	  <h1>Bulkegistrering av stand</h1>
	  <hr>
	  <h3>Få EXCEL dokumentet i riktig format</h3>
	  <img src="images/format.png" width=100%>
	  <br>
	  <h3>Lagre EXCEL dokumentet som en .CSV fil</h3>
	  <img src="images/lagring.png" width=100% >
	  <br>
	  <br>
	   <label for="filename"><b>Trykk "Choose file" og velg riktig fil</b></label>
	   <br>
	   	   
	   
	   <br>
			<form action="bulkservlet" method="post" enctype="multipart/form-data">
				<input type="file" name="filename" accept=".csv"> <font color="red">${ugyldigFil}</font>
				<br>
				<br>
				<label for="arrangement">Velg Arrangement:</label>
			    <select name="arrangement" id="arrangement">
				    <c:forEach items="${liste}" var="arrangement">
						<option value="${arrangement.navn}">${arrangement.navn}</option>
					</c:forEach>
		  		</select>
		  		<br>
				<br>
	    		<button type="submit" class="registerbtn" name="button"><b>Registrer</b></button>
			</form>
			<br>
			
	<hr>
	

	  </div>

	

 <div class="signin">
  	<p>Gå tilbake til <a href="index.jsp">Meny</a></p>
  	

  </div>
 
  </div>
  
 

</body>
</html>
