package com.demo.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	
	private static String key = "tom-cookie";
	
	/**
	 * 种cookie
	 * @param token
	 * @param response
	 */
	public static void flushCookie(String token,HttpServletResponse response){
		Cookie cookie = new Cookie(key, token);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		cookie.setDomain("locahost");
		cookie.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(cookie);
	}
	
	public static String getRequestedToken(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if(cookies == null){
			return null;
		}
		for (Cookie cookie : cookies) {
			if(cookie==null){
				continue;
			}
			if(!key.equalsIgnoreCase(cookie.getName())){
				continue;
			}
			return cookie.getValue();
		}
		return null;
	}
	
}
