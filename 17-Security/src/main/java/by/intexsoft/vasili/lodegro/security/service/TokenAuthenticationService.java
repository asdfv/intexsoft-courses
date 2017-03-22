package by.intexsoft.vasili.lodegro.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class TokenAuthenticationService {

    public final static Logger LOGGER = LoggerFactory.getLogger(TokenAuthenticationService.class);

    static final long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 10; // 10 days
    static final String SECRET = "ThisIsASecret";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

//    Is null... But why???
//    @Autowired
//    SecurityContextHolder securityContextHolder;
//
//    @Autowired
//    UserDetailsService userDetailsService;

    public void addAuthentication(HttpServletResponse response, String username) {

//        LOGGER.info("Before userDetailsService.loadUserByUsername");
//        CustomUserDetails customUser = (CustomUserDetails) userDetailsService.loadUserByUsername(username);
//        LOGGER.info("After userDetailsService.loadUserByUsername: " + customUser.getPassword());

        // We generate a token now.
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("scopes", AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
        LOGGER.info("Claims: " + claims.toString());
        String JWT = Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
        LOGGER.info(username + " get a token: " + JWT);
    }

    public Authentication getAuthentication(HttpServletRequest request) {

//        LOGGER.info("securityContextHolder for user: ");
//        LOGGER.info(securityContextHolder.getContext().getAuthentication().getName());

        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            String username = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
            LOGGER.info("User " + username + " try to get secure...");

            if (username != null) {
                Authentication auth = new UsernamePasswordAuthenticationToken(
                        username,
                        null,
                        AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
                LOGGER.info("Auth is: " + auth.toString());

                return auth;
            }
            LOGGER.info("Username is NULL");
            return null;
//            return username != null ?
//                    new UsernamePasswordAuthenticationToken(
//                            username,
//                            null,
//                            userDetailsService.loadUserByUsername(username).getAuthorities()
//                    ) :
//                    null;
        }
        return null;
    }
}
