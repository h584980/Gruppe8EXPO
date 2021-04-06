"use strict";

	const rootElement = document.getElementById("stand");

	const navn = rootElement.querySelector('input[name="navn"]');
	const startDato = rootElement.querySelector('input[name="startDato"]');
	const startTid = rootElement.querySelector('input[name="startTid"]');
	const sluttDato = rootElement.querySelector('input[name="sluttDato"]');
	const sluttTid = rootElement.querySelector('input[name="sluttTid"]');

	const meldPaaKnapp = rootElement.querySelector('button[name="button"]');
	
	let navnGodkjent = false;
	let datoGodkjent = false;
	let startTidGodkjent  = false;
	let sluttTidGodkjent  = false;

	document.addEventListener("DOMContentLoaded", sjekkNavn);
	document.addEventListener("DOMContentLoaded", sjekkDato);
	document.addEventListener("DOMContentLoaded", sjekkStartTid);
	document.addEventListener("DOMContentLoaded", sjekkSluttTid);

	rootElement.querySelector('button[name="button"]').disabled = true;
	
	navn.addEventListener("input", sjekkNavn);
	startDato.addEventListener("input", sjekkDato);
	startTid.addEventListener("input", sjekkStartTid);
	sluttDato.addEventListener("input", sjekkDato);
	sluttTid.addEventListener("input", sjekkSluttTid);
	
	function sjekkAltGodkjent() {
		if(navnGodkjent && datoGodkjent && startTidGodkjent && sluttTidGodkjent){
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
	
	function sjekkDato() {
		let d1 = Date.parse(startDato.value);
		let d2 = Date.parse(sluttDato.value);
		if (d1 < d2) {
	    	datoGodkjent = true;
		} else {
	    	datoGodkjent = false;
		}
		sjekkAltGodkjent();
	}
	
	function sjekkStartTid() {
		console.log(startTid.value)
		if (startTid.value == '') {
            	startTidGodkjent = false;
        } else {
			startTidGodkjent = true;
		}
		sjekkAltGodkjent();

	}
	
	function sjekkSluttTid() {
		if (sluttTid.value == '') {
            	sluttTidGodkjent = false;
        } else {
			sluttTidGodkjent = true;
		}
		sjekkAltGodkjent();

	}
	
	
	
	
	
	
	
	
	
	