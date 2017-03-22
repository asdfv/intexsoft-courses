package by.intexsoft.vasili.lodegro.security.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends AbstractPersistable<Integer> {

    public User() {
    }

    @Column
    public String username;

    @Column
    public String password;

    @Column
    public boolean enabled;

//    @ManyToMany(targetEntity = Authority.class, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_authority",
//            joinColumns = {@JoinColumn(name = "user_id")},
//            inverseJoinColumns = {@JoinColumn(name = "authority_id")}
//    )
//    public Set<Authority> authorities;


    public User(User user) {
        this.username = user.username;
        this.password = user.password;
        this.enabled = user.enabled;
    }
}
