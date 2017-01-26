package by.intexsoft.vasili.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Model for entity "USER"
 */
@Entity
@Table(name = "test.users")
public class User extends AbstractPersistable<Integer> {
	
	private static final long serialVersionUID = 1926111368394829626L;
	@Column
	public String name;

}
