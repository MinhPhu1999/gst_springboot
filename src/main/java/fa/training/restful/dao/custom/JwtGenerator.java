package fa.training.restful.dao.custom;

import fa.training.restful.constant.AppConstant;
import fa.training.restful.dao.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {
	public String returnToken(User user){
        return Jwts.builder()
                .claim("name", user.getName())
                .claim("username", user.getUsername())
                .claim("role", user.getRole())
                .signWith(SignatureAlgorithm.HS512, AppConstant.JWT_SECRET)
                .compact();
    }
	
}
