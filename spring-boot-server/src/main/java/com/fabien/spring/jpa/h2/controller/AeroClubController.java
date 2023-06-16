package com.fabien.spring.jpa.h2.controller;

import com.fabien.spring.jpa.h2.model.AeroClub;
import com.fabien.spring.jpa.h2.model.Tarifs;
import com.fabien.spring.jpa.h2.repository.AeroClubRepository;
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
public class AeroClubController {

	@Autowired
	AeroClubRepository aeroClubRepository;

	@GetMapping("/aeroclub")
	public ResponseEntity<List<AeroClub>> getAllAeroclubs(@RequestParam(required = false) String oaci ) {
		try {
			List<AeroClub> aeroclubs = new ArrayList<AeroClub>();

			if (oaci == null)
				aeroClubRepository.findAll().forEach(aeroclubs::add);
			else
				aeroClubRepository.findByOaciContaining(oaci).forEach(aeroclubs::add);

			if (aeroclubs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(aeroclubs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/aeroclub/{id}")
	public ResponseEntity<AeroClub> getTutorialById(@PathVariable("id") long id) {
		Optional<AeroClub> aeroclubData = aeroClubRepository.findById(id);

		if (aeroclubData.isPresent()) {
			return new ResponseEntity<>(aeroclubData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/aeroclub")
	public ResponseEntity<AeroClub> createAeroclub(@RequestBody AeroClub aeroclub, Tarifs taris) {
		try {
			AeroClub _aeroclub = aeroClubRepository
					.save(new AeroClub(aeroclub.getId(), aeroclub.getOaci(), aeroclub.getName(), aeroclub.getType(), aeroclub.getAdresse(), aeroclub.getCodePostal(), aeroclub.getPhoneNumber(), aeroclub.getMail()));
			return new ResponseEntity<>(_aeroclub, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/aeroclub/{id}")
	public ResponseEntity<AeroClub> updateTutorial(@PathVariable("id") long id, @RequestBody AeroClub aeroClub) {
		Optional<AeroClub> aeroClubData = aeroClubRepository.findById(id);

		if (aeroClubData.isPresent()) {
			AeroClub _aeroclub = aeroClubData.get();
			_aeroclub.setOaci(aeroClub.getOaci());
			_aeroclub.setName(aeroClub.getName());
			_aeroclub.setType(aeroClub.getType());
			_aeroclub.setAdresse(aeroClub.getAdresse());
			_aeroclub.setCodePostal(aeroClub.getCodePostal());
			_aeroclub.setPhoneNumber(aeroClub.getPhoneNumber());
			_aeroclub.setMail(aeroClub.getMail());
			return new ResponseEntity<>(aeroClubRepository.save(_aeroclub), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/aeroclub/{id}")
	public ResponseEntity<HttpStatus> deleteAeroclub(@PathVariable("id") long id) {
		try {
			aeroClubRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/aeroclub")
	public ResponseEntity<HttpStatus> deleteAllAeroclubs() {
		try {
			aeroClubRepository.deleteAll();
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
