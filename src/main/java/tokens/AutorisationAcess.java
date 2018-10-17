package tokens;


import java.util.Iterator;

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

	
	public static JsonObject registerToken(Personne personne)
	{
		JsonObject obj = new JsonObject();
		Algorithm algo = Algorithm.HMAC256("secretKey");
		Builder token = JWT.create();
		
		token.withClaim("userId", personne.getUserId());
		token.withClaim("userMail", personne.getUserMail());
		token.withClaim("userName", personne.getUserName());
		token.withClaim("userPicture", personne.getUserPicture());
		
		String tok = token.sign(algo);
		obj.addProperty("token", tok);
		return obj;
	}
	
	
	public static Claim verify(HttpServletRequest request)
	{
		
		String token = "";
		
		System.out.println("header ----------------> " + request.getHeaderNames());
		
		if(request.getHeader("Authorization").isEmpty())
		{
			return null;
		}
		
		token = request.getHeader("Authorization");
		System.out.println("token ----------------------> " + token);
		
		 Algorithm algorithm = Algorithm.HMAC256("secretKey");
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer("auth0")
		        .build(); //Reusable verifier instance
		    DecodedJWT jwt = verifier.verify(token);
		    return jwt.getClaim("userId");
		
	}
	
}
