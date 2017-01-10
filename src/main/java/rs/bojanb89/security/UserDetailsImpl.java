/**
 * 
 */
package rs.bojanb89.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import rs.bojanb89.datamodel.entity.Role;
import rs.bojanb89.datamodel.entity.User;

/**
 * @author Bojan Bogojevic
 *
 */
public class UserDetailsImpl implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3413337096852642718L;

	@Getter
	private Collection<? extends GrantedAuthority> authorities;
	@Getter
	private String password;
	@Getter
	private String username;
	@Getter
	private boolean enabled;

	/**
	 * @param user
	 */
	public UserDetailsImpl(User user) {
		this.password = user.getPassword();
		this.username = user.getUsername();
		this.authorities = translate(user.getRoles());
		this.enabled = user.isEnabled();
	}

	/**
	 * @param roles
	 * @return
	 */
	private Collection<? extends GrantedAuthority> translate(List<Role> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Role role : roles) {
			String name = role.getName().toUpperCase();
			if (!name.startsWith("ROLE_")) {
				name = "ROLE_" + name;
			}
			authorities.add(new SimpleGrantedAuthority(name));
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

}
