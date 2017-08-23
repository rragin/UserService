package com.agilesde.diva.user;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@RequestMapping(method = RequestMethod.POST, value = "/users", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<?> createUser(@RequestBody final MultiValueMap<String, String > formVars) {
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("create"));
        headers.set("firstName", formVars.get("first_name").toString());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/users/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUser(@PathVariable("username") String username) {
        User user = new User();;
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("jdoe@agilesde.com");
        user.setAddress("123 Somewhere St Melbourne, FL 32901");
        
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.PUT, value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("update"));
        return new ResponseEntity<String>(headers, HttpStatus.OK);
	}

}
