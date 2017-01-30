package by.intexsoft.vasili.userapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "users")
public class User extends AbstractPersistable<Integer> {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "name")
	public String name;
}
