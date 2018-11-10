package tokens;





import javax.servlet.http.HttpServletRequest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.JsonObject;


import models.Personne;

public class AutorisationAcess {

	
	public static String registerToken(Personne personne)
	{
		
		Algorithm algo;
                
                algo = Algorithm.HMAC256("secretKey");
          
		Builder token = JWT.create().withIssuer("auth0");
		
		token.withClaim("userId", personne.getUserId());
		token.withClaim("userMail", personne.getUserMail());
		token.withClaim("userName", personne.getUserName());
		
		
		String tok = token.sign(algo);
	
		return tok;
	}
	
	
	public static String encodePassword(String password)
	{
	
		Algorithm algo;
        algo = Algorithm.HMAC256("secretKey");
        Builder token = JWT.create().withIssuer("auth0");
        token.withClaim("userPassword", password);
        String tok = token.sign(algo);

        return tok;
	}
	
	
	
	public static Claim verify(HttpServletRequest request)
	{
		
		
		
		String token = request.getHeader("Authorization").split(" ")[1];
		
       Algorithm algorithm ;
             
                algorithm = Algorithm.HMAC256("secretKey");
            
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer("auth0")
		        .build(); //Reusable verifier instance
		    DecodedJWT jwt = verifier.verify(token); 
		    return jwt.getClaim("userId");
		
	}
	
	
	
	
	public static boolean allowUser(HttpServletRequest req)
	{
		String auth = req.getHeader("Authorization");
		if(auth == null)
			return false;
		else
			return true;
		
	}
	
	
	
}
