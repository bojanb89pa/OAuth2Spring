package rs.bojanb89.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.bojanb89.datamodel.to.UserTO;
import rs.bojanb89.service.UserService;

@RestController
@RequestMapping(value = "")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public void addUser(@RequestBody UserTO user) {
		userService.addUser(user);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public UserTO getUser(@RequestParam String username) {
		return userService.getUser(username);
	}
}
