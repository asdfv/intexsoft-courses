package by.intexsoft.vasili.lodegro.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

class TokenAuthenticationService {

    public final static Logger LOGGER = LoggerFactory.getLogger(TokenAuthenticationService.class);

    private static CustomUserDetailService customUserDetailService = new CustomUserDetailService();

    static final long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 10; // 10 days
    static final String SECRET = "ThisIsASecret";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    static void addAuthentication(HttpServletResponse response, String username) {
        // We generate a token now.
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
        LOGGER.info(username + " get a token: " + JWT);
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            String username = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
            LOGGER.info("User " + username + " try to get secure...");
            return username != null ?
                    new UsernamePasswordAuthenticationToken(
                            username,
                            null,
                            customUserDetailService.loadUserByUsername("adm").getAuthorities()
                    ) :
                    null;
        }
        return null;
    }
}
