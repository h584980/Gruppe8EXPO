package no.hvl.dat109;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	private final static String CHARACTER_ENCODING = "UTF-8";
	private final static int MAX_AGE_IN_SECONDS = 60*60*24*365;

	public static void addCookieToResponse(HttpServletResponse response, String navn, String verdi) {
		try {
			Cookie cookie = new Cookie(navn, URLEncoder.encode(verdi, CHARACTER_ENCODING));
			cookie.setMaxAge(MAX_AGE_IN_SECONDS);
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			// Should never happen
			e.printStackTrace();
		}
	}

	public static String getCookieFromRequest(HttpServletRequest request, String navn) {
		String verdi = null;
		try {
			verdi = Arrays.stream(request.getCookies())
					.filter(c -> c.getName().equals(navn))
					.map(Cookie::getValue)
					.findFirst().orElse(null);

			verdi = URLDecoder.decode(verdi, CHARACTER_ENCODING);

		} catch (NullPointerException e) {
			// If no cookie in request.
			// null is returned
			
		} catch (UnsupportedEncodingException e) {
			// Should never happen
			e.printStackTrace();
		}
		return verdi;
	}
}