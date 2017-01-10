/**
 * 
 */
package rs.bojanb89.datamodel.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bojan Bogojevic
 *
 */
@Entity
@Table(name = "role")
public class Role extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3024694618038446115L;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@Getter
	@Setter
	private User user;

	@NotNull
	@Column(name = "name", length = 50, nullable = false, unique = true)
	@Getter
	@Setter
	private String name;

}
