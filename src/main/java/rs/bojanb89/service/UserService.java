package rs.bojanb89.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.bojanb89.datamodel.entity.Role;
import rs.bojanb89.datamodel.entity.User;
import rs.bojanb89.datamodel.to.UserTO;
import rs.bojanb89.exception.BadRequestException;
import rs.bojanb89.exception.code.ErrorCode;
import rs.bojanb89.repository.UserRepository;
import rs.bojanb89.security.PasswordEncoder;

@Service
public class UserService {

	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	
	public void addUser(UserTO userTO) throws BadRequestException {
		User user = fromTO(userTO);
		if(userRepository.findByUsername(user.getUsername()) != null) {
			throw new BadRequestException(ErrorCode.USER_EXISTS, "User exists");
		}
		userRepository.save(user);
	}
	
	public UserTO getUser(String username) {
		return toFrom(userRepository.findByUsername(username));
	}

	private User fromTO(UserTO userTO) {
		User user = new User();
		if(userTO.enabled != null) {
			user.setEnabled(userTO.enabled);
		} else {
			user.setEnabled(true);
		}
		user.setPassword(passwordEncoder.encode(userTO.password));
		user.setUsername(userTO.username);
		user.setEmail(userTO.email);

		Role role = new Role();
		role.setName("CLIENT");
		role.setUser(user);
		user.setRoles(Arrays.asList(role));
		
		return user;
	}

	private UserTO toFrom(User user) {
		UserTO userTO = new UserTO(user.getUsername(), user.isEnabled(), user.getEmail());
		return userTO;
	}

}
