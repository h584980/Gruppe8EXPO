"use strict";

	const rootElement = document.getElementById("stand");

	const stemme = document.querySelectorAll('input[type="radio"][name="vote"]');
	const meldPaaKnapp = rootElement.querySelector('button[name="button"]');
	
	let stemmeGodkjent = false;

	document.addEventListener("DOMContentLoaded", sjekkStemme);

	rootElement.querySelector('button[name="button"]').disabled = true;
	
	for (var i = 0, len = stemme.length; i < len; i++) {
 		(stemme[i].addEventListener("click", sjekkStemme)) 
    }  

	function sjekkAltGodkjent() {
		if(stemmeGodkjent){	
			meldPaaKnapp.disabled = false;
		} else {
			meldPaaKnapp.disabled = true;
		}
	}
	
	function sjekkStemme() {
		stemmeGodkjent = false;
		for (var i = 0, len = stemme.length; i < len; i++) {
        	if (stemme[i].checked) {
            	stemmeGodkjent = true;
        	}
     	}	
		sjekkAltGodkjent();
	}