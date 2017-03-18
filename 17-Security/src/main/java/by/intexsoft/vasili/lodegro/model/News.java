package by.intexsoft.vasili.lodegro.model;

import javax.persistence.*;

/**
 * model for Users table
 */
@Entity
@Table
public class News {

	private static final long serialVersionUID = 1L;

	/**
	 * Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "news_id")
	public long id;

	/**
	 * News title
	 */
	@Column
	public String title;
	
	/**
	 * News content
	 */	
	@Column
	public String text;
}
