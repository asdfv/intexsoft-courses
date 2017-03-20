package by.intexsoft.vasili.lodegro.security;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    @Override
    public String getAuthority() {
        return "ROLE_ADMIN";
    }
}
