
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<link rel="stylesheet"href="css/NewFile.css">
<title>Registrering</title>
	<script src="js/StemmeValidering.js" defer></script> 
<body>

<div id="stand" class="container">
<form action="standservlet" method="post">
	  <div class="innholdStand">
	    <h1>${stand.navn}</h1>
	    <hr>
		<table>
					<tr bgcolor="#ddd">
						<th>Snittrating</th>
						<th>Antall stemmer</th>
					</tr>
					<tr bgcolor="#f1f1f1">
						<td align="center">
							${stand.snittStemme}
						</td>
						<td align="center">
							${stand.antallStemmer}
						</td>
					</tr>
				</table>
				
	    <p>Her skal det en QR-kode</p>
	    <font color="limegreen">${tilbakemelding}</font>
		<br>
	    <div class="stemmer">
	      <input type="radio" id="vote0" name="vote" value="0">
		  <label for="vote0">0</label>&nbsp;&nbsp;&nbsp;&nbsp;
		  <input type="radio" id="vote1" name="vote" value="1">
		  <label for="vote1">1</label>&nbsp;&nbsp;&nbsp;&nbsp;
		  <input type="radio" id="vote2" name="vote" value="2">
		  <label for="vote2">2</label>&nbsp;&nbsp;&nbsp;&nbsp;
		  <input type="radio" id="vote3" name="vote" value="3">
		  <label for="vote3">3</label>&nbsp;&nbsp;&nbsp;&nbsp;
		  <input type="radio" id="vote4" name="vote" value="4">
		  <label for="vote4">4</label>  &nbsp;&nbsp;&nbsp;&nbsp;
		  <input type="radio" id="vote5" name="vote" value="5">
		  <label for="vote5">5</label>
		</div>
	    <button type="submit" class="registerbtn" name="navn" value="${stand.navn}"><b>Stem</b></button>
	    <br>
	    <hr>

	  </div>

</form>

 <div class="signin">
  	<p><a href="oversiktservlet">Stand oversikt</a></p>
  </div>
  </div>

</body>
</html>
