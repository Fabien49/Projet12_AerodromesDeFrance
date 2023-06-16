package com.fabien.spring.jpa.h2.controller;

import com.fabien.spring.jpa.h2.model.AeroClub;
import com.fabien.spring.jpa.h2.model.RegisteredUser;
import com.fabien.spring.jpa.h2.repository.AeroClubRepository;
import com.fabien.spring.jpa.h2.repository.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class RegisteredUserController {

	@Autowired
	RegisteredUserRepository registeredUserRepository;

	@GetMapping("/registereduser")
	public ResponseEntity<List<RegisteredUser>> getAllRegisteredUsers(@RequestParam(required = false) String email ) {
		try {
			List<RegisteredUser> registeredsusers = new ArrayList<RegisteredUser>();

			if (email == null)
				registeredUserRepository.findAll().forEach(registeredsusers::add);
			else
				registeredUserRepository.findByEmail(email).forEach(registeredsusers::add);

			if (registeredsusers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(registeredsusers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/registereduser/{id}")
	public ResponseEntity<RegisteredUser> getRegisteredUserById(@PathVariable("id") long id) {
		Optional<RegisteredUser> registereduserData = registeredUserRepository.findById(id);

		if (registereduserData.isPresent()) {
			return new ResponseEntity<>(registereduserData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/registereduser")
	public ResponseEntity<RegisteredUser> createRegisteredUser(@RequestBody RegisteredUser registeredUser) {
		try {
			RegisteredUser _registereduser = registeredUserRepository
					.save(new RegisteredUser(registeredUser.getId(), registeredUser.getFirstName(), registeredUser.getLastName(), registeredUser.getPassword(), registeredUser.getEmail(), registeredUser.getRoles()));
			return new ResponseEntity<>(_registereduser, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/registereduser/{id}")
	public ResponseEntity<RegisteredUser> updateRegisteredUser(@PathVariable("id") long id, @RequestBody RegisteredUser registeredUser) {
		Optional<RegisteredUser> registereduserData = registeredUserRepository.findById(id);

		if (registereduserData.isPresent()) {
			RegisteredUser _registereduser = registereduserData.get();
			_registereduser.setFirstName(registeredUser.getFirstName());
			_registereduser.setLastName(registeredUser.getLastName());
			_registereduser.setEmail(registeredUser.getEmail());
			_registereduser.setPassword(registeredUser.getPassword());
			_registereduser.setRoles(registeredUser.getRoles());
			return new ResponseEntity<>(registeredUserRepository.save(_registereduser), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/registereduser/{id}")
	public ResponseEntity<HttpStatus> deleteRegisteredUser(@PathVariable("id") long id) {
		try {
			registeredUserRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/registereduser")
	public ResponseEntity<HttpStatus> deleteAllRegisteredUsers() {
		try {
			registeredUserRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

/*	@GetMapping("/tutorials/published")
	public ResponseEntity<List<Tutorial>> findByPublished() {
		try {
			List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/

}
