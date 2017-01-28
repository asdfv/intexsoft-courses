package by.intexsof.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "users")
public class User extends AbstractPersistable<Integer> {
	
	private static final long serialVersionUID = -5684698978617230856L;
	
	@Column
	public String name;
}
