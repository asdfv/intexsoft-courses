package by.intexsoft.vasili.lodegro.security.service;

import by.intexsoft.vasili.lodegro.security.model.Authority;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TokenAuthenticationService {

    public final static Logger LOGGER = LoggerFactory.getLogger(TokenAuthenticationService.class);

    static final long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 10; // 10 days
    static final String SECRET = "ThisIsASecret";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    public void addAuthentication(HttpServletResponse response, Authentication auth) {

        String username = auth.getName();
//        Set<String> authorities = AuthorityUtils.authorityListToSet(auth.getAuthorities());
        List<String> authorities = auth.getAuthorities().stream().map(s -> s.getAuthority()).collect(Collectors.toList());


        // We generate a token now.
        Claims claims = Jwts.claims().setSubject(username);


        claims.put("scopes", authorities);
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

        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            LOGGER.info("Parse a token____________________________________________________________ ");

            // parse the token.
            String username = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

//            ArrayList<String> authorities = Jwts.parser()
//                    .setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
//                    .getBody().get("scopes", ArrayList.class);

            ArrayList<String> authorities = new ArrayList<String>() {{
                add("ROLE_REDACTOR");
                add("ROLE_ADMIN");
            }};


            LOGGER.info("User " + username + " with authorities: " + authorities);

            if (username != null) {
                Authentication auth = new UsernamePasswordAuthenticationToken(
                        username,
                        null,
                        AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils.join(authorities, ','))
                );

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
