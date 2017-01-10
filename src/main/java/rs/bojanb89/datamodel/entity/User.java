/**
 * 
 */
package rs.bojanb89.datamodel.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bojan Bogojevic
 *
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5502972351616620915L;

	@NotNull
	@Column(name = "username", length = 50, nullable = false, unique = true)
	@Getter
	@Setter
	private String username;

	@Column(name = "password", length = 256)
	@Getter
	@Setter
	private String password;

	@Column(name = "enabled", columnDefinition = "tinyint default 0", length = 1)
	@Getter
	@Setter
	private boolean enabled;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	@Getter
	@Setter
	private List<Role> roles;
}
