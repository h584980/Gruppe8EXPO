"use strict";

	const rootElement = document.getElementById("stand");

	const navn = rootElement.querySelector('input[name="navn"]');
	const meldPaaKnapp = rootElement.querySelector('button[name="button"]');
	
	let navnGodkjent = false;

	document.addEventListener("DOMContentLoaded", sjekkNavn);

	rootElement.querySelector('button[name="button"]').disabled = true;
	
	navn.addEventListener("input", sjekkNavn);

	function sjekkAltGodkjent() {
		if(navnGodkjent){	
			meldPaaKnapp.disabled = false;
		} else {
			meldPaaKnapp.disabled = true;
		}
	}
	
	function sjekkNavn() {
		navn.value=navn.value.replace(/[^a-zA-Z0-9åæøÅÆØÖö -]/g,'');
		if (navn.value.length >= 2 && navn.value.length <= 200 && /^[A-Za-z0-9ÆØÅæøå]+(((-| )[A-Za-z0-9ÆØÅæøå]+)+)?$/.test(navn.value)) {
			navn.classList.remove(...navn.classList);
			navn.classList.add('inputValid');
			navnGodkjent = true;
			sjekkAltGodkjent();
		} else if (navn.value == "") {
			navn.classList.remove(...navn.classList);
			navn.classList.add('noInput');
			navnGodkjent = false;
			sjekkAltGodkjent();
		} else {
			navn.classList.remove(...navn.classList);
			navn.classList.add('inputInvalid');
			navnGodkjent = false;
			sjekkAltGodkjent();
		} 
		
	}