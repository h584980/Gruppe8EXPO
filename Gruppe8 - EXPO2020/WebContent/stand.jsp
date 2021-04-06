
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
	    
		<table>
					<tr bgcolor="#ddd">
						<th>Snittrating</th>
						<th>Totalsum</th>
						<th>Antall stemmer</th>
					</tr>
					<tr bgcolor="#f1f1f1">
						<td align="center">
							${stand.snittStemme}
						</td>
						<td align="center">
							${stand.totalsum}
						</td>
						<td align="center">
							${stand.antallStemmer}
						</td>
					</tr>
		</table>
		
				
	    		<br>	



	<ul class="graph">
    	<li><span style="height:${10 + 100*(stand.antall1/stand.flestStemmer)}%">${stand.antall1}</span></li>
    	<li><span style="height:${10 + 100*(stand.antall2/stand.flestStemmer)}%">${stand.antall2}</span></li>
    	<li><span style="height:${10 + 100*(stand.antall3/stand.flestStemmer)}%">${stand.antall3}</span></li>
    	<li><span style="height:${10 + 100*(stand.antall4/stand.flestStemmer)}%">${stand.antall4}</span></li>
    	<li><span style="height:${10 + 100*(stand.antall5/stand.flestStemmer)}%">${stand.antall5}</span></li>
	</ul>
	
	    <div class="stemmer">
			  
			  <label for="vote1">1<input type="radio" id="vote1" name="vote" value="1"></label>
			  
			  <label for="vote2">2<input type="radio" id="vote2" name="vote" value="2"></label>
			  
			  <label for="vote3">3<input type="radio" id="vote3" name="vote" value="3"></label>
			  
			  <label for="vote4">4<input type="radio" id="vote4" name="vote" value="4"></label>  
			  
			  <label for="vote5">5<input type="radio" id="vote5" name="vote" value="5"></label>
			</div>
		      
	    <button type="submit" class="registerbtn" name="navn" value="${stand.navn}"><b>Stem</b></button>
	    <label for="vote0">Ingen stemme<input type="radio" id="vote0" name="vote" value="0"></label>
	    
	    <p>&nbsp;<font color="limegreen">${tilbakemelding}</font>&nbsp;</p>
	    	        
	    <hr>

	  </div>

</form>

 <div class="signin">
  	<p>Gå tilbake til <a href="index.jsp">Meny</a></p>
  </div>
  </div>

</body>
</html>
