package com.worscipe.bright.gateway.auth;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	private static final Logger logger = LogManager.getLogger(TokenManagerImpl.class);

	
	private final static String API_KEY = "xfANpSwJI6yllxK6NFE7eZahCNVPUJmg";
	private final static SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

	public String generateFakeToken(String email) {
	    
		return "FakeToken" + email;
	}

	
	public String generateToken(String key, Role role) {

		// TODO generate a valid JWT Token for clients to use
		// TODO assign token with user role permissions
		Date now = new Date();
        Date exp = new Date(System.currentTimeMillis() + (60000*60)); // 1 hour
        
        try {
		return Jwts.builder().setIssuer("BrightIdeas")
				.setSubject(key)
				.claim("role", role)
				.setIssuedAt(now)
				.setExpiration(exp)
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
		    logger.debug(claims.getExpiration().compareTo(now));
		    
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
	
	private Jws<Claims> decodeJwts(String jwt) {
		//this will throw an error if it is not a signed JWS (as expected)
		   //This line will throw an exception if it is not a signed JWS (as expected)
		try {
			Jws<Claims> claims = Jwts.parser()         
				       .setSigningKey(TextCodec.BASE64.decode(API_KEY))
				       .parseClaimsJws(jwt);
			return claims;
			
		} catch (SignatureException e) {
			
			logger.debug("SignatureException!");
			logger.debug(e);
			return null;
		}
	    
	    
		   
	}
	
}
