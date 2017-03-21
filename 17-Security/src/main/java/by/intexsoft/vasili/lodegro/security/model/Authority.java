package by.intexsoft.vasili.lodegro.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Table
@Entity
public class Authority implements GrantedAuthority {

    @Id
    @Column
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    public String name;

    @JsonIgnore
    @Override
    public String getAuthority() {
        return this.name;
    }
}
