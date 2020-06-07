package com.worscipe.bright.gateway.auth;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.TextCodec;



/**
 *  
 *  TODO Move JWT Values to Application Properties
 * 
 *  Cryptographic Keys: 
 *  1. xfANpSwJI6yllxK6NFE7eZahCNVPUJmg
 *  2. IFjLoANIAViwiKphRk9mMVMABPDM4PTM
 *  3. x7dGkAR4yMFsa52MZT8o8nA4zYK7T3yV
 *  4. Ruf8dzxyOgdVZRihtJYrQiq0YHwxgZvd
 *  
 */

@Service
public class TokenManagerImpl implements TokenManager {
	
	private static final Logger logger = LoggerFactory.getLogger(TokenManagerImpl.class);

	
	private static final String API_KEY = "xfANpSwJI6yllxK6NFE7eZahCNVPUJmg";
	private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

	@Override
	public String generateToken(Map<String,String> claims) {

		// TODO assign token with user role permissions
		Date now = new Date();
        Date exp = new Date(System.currentTimeMillis() + (60000*60)); // 1 hour
        
        try {
		// OpenId Specifications  https://openid.net/specs/openid-connect-core-1_0.html
        	return Jwts.builder()
        	    //OpenId Required
				.setIssuer("https://worscipe.com") 
				.setSubject(claims.get("uid")) 
				.setAudience(null)
				.setExpiration(exp)
				.setIssuedAt(now)
				//optional: 
				.claim("role", claims.get("role"))
				.signWith(signatureAlgorithm, TextCodec.BASE64.decode(API_KEY))
				.compact();
		
        }
        catch (JwtException e) {
        	logger.debug("Unable to create JWT" + e.getMessage());
        	return "Unable to create JWT" + e.getMessage();
        }
	}
	
	public Boolean isValidToken(String token) {
		
		Date now = new Date();
		Jws<Claims> claim = decodeJwts(token);
		
		
		if(claim != null) {
			
			Claims claims = claim.getBody();			
		   	logger.debug("Expiration: " + claims.getExpiration());
		    logger.debug("Now: " + now);
		    logger.debug(String.valueOf(claims.getExpiration().compareTo(now)));
		    
		    if (claims.getExpiration().compareTo(now) >= 0 ) {
		    	logger.debug("token expiration is after or equal to the current date");
		    	//expiration is after or equal to the current date (in milliseconds); 
		    	return true; 
		    } else {
		    	//token is expired;
		    	return false; 
		    }
		} else {
			//claim is null, decode failed; 
			return false;
		}
			
	}
	
	public String decodeSubject(String token) {
		Jws<Claims> claims = decodeJwts(token);
		return claims.getBody().get("sub").toString();
	}

	
	private Jws<Claims> decodeJwts(String jwt) {
		//this will throw an error if it is not a signed JWS (as expected)
		   //This line will throw an exception if it is not a signed JWS (as expected)
		try {
			return Jwts.parser()         
				       .setSigningKey(TextCodec.BASE64.decode(API_KEY))
				       .parseClaimsJws(jwt);
		
		} catch (SignatureException e) {
			logger.debug("SignatureException!");
			logger.debug(e.getMessage());
			return null;
		}
	    
	    
		   
	}
	
}
