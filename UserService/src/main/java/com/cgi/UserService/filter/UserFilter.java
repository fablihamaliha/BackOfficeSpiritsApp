package com.cgi.UserService.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class UserFilter extends GenericFilter {
	
	 private String secretKey= "cgicanadakey";
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		 
		HttpServletRequest httprequest=(HttpServletRequest) request;
		HttpServletResponse httpresponse=(HttpServletResponse) response;
		
		httpresponse.setHeader("Access-Control-Allow-Origin","*");
		httpresponse.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE,OPTIONS");
		httpresponse.setHeader("Access-Control-Allow-Credentials", "true");
		httpresponse.setHeader("Access-Control-Allow-Headers", "*");
		
		//to handle prefligh request from web browser - when ui is javascript based , and domains are cross
		if (httprequest.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name())) {
			chain.doFilter(httprequest, httpresponse);
		}
		
		else
			
		{
			
			
			String authheader=httprequest.getHeader("Authorization");
			System.out.println(authheader);
			if((authheader==null) || (!authheader.startsWith("Bearer")))
			{
				throw new ServletException("JWT Token is missing");
				
			}
			
			String mytoken=authheader.substring(7);
			
			 try
			 {
				 JwtParser jwtparser=Jwts.parser().setSigningKey("cgicanadakey");
				 Jwt jwtobj=jwtparser.parse(mytoken);
				 Claims claimobj=(Claims)jwtobj.getBody();
				 System.out.println("welcome " + claimobj.getSubject());
			 }
			catch (SignatureException sigex)
			 {
				throw new ServletException("signature mismatch");
			 }
			 catch(MalformedJwtException malform) {
				 
				 throw new ServletException("Token is modified by unauthorized user");
			 }
			
		}
	chain.doFilter(httprequest, httpresponse);
	}

}