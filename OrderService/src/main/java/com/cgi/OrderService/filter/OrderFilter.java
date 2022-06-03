package com.cgi.OrderService.filter;

import io.jsonwebtoken.*;
import io.swagger.models.HttpMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderFilter extends GenericFilter {

    private String secretKey= "cgicanadakey";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        //Indicates whether the response can be shared.
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        //Specifies the method or methods allowed when accessing the resource in response to a preflight request.
        httpServletResponse.setHeader("Access-Control-Allow-Methods","POST,GET,PUT,DELETE,OPTIONS");
        //Indicates whether or not the response to the request can be exposed when the credentials flag is true.
        httpServletResponse.setHeader("Access-Control-Allow-Credentials","true");
        //Used in response to a preflight request to indicate which HTTP headers can be used when making the actual request.
        httpServletResponse.setHeader("Access-Control-Allow-Headers","*");


        //handle preflight request
        if(httpServletRequest.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name())){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }else{

            //Get the Authorization header
            String authheader = httpServletRequest.getHeader("Authorization");

            //If header is null or does not start with "Bearer" throw an exception
            if(authheader==null || (!authheader.startsWith("Bearer"))){
                throw new ServletException("JWT Token is missing");
            }

            //Remove "Bearer" from the string so we only get token
            String mytoken = authheader.substring(7);

            try{
                //Create the jwt parser
                JwtParser jwtParser = Jwts.parser().setSigningKey(secretKey);
                //parse the token and validate it
                Jwt jwtobj = jwtParser.parse(mytoken);


            }catch(MalformedJwtException e){
                throw new ServletException("Token is modified by unauthorized user");
            }
            catch(SignatureException e){
                throw new ServletException("Signature Mismatch");
            }

            filterChain.doFilter(httpServletRequest,httpServletResponse);

        }
    }
}
