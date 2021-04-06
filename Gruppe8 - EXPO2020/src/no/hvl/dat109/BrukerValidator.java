package no.hvl.dat109;

import javax.servlet.http.HttpServletRequest;

public class BrukerValidator {

	public static boolean validerAdminPassord(String passord, HttpServletRequest request) {
		
		if (passord.equals("passord")) {
			return true;
		} else {
			request.setAttribute("ugyldigAdminPassord", "Feil passord. Prøv på nytt");
			return false;
		}
		
	}

	public static boolean validerJuryPassord(String passord, HttpServletRequest request) {
		
		if (passord.equals("passord")) {
			return true;
		} else {
			request.setAttribute("ugyldigAdminPassord", "Feil passord. Prøv på nytt");
			return false;
		}
	}

}
