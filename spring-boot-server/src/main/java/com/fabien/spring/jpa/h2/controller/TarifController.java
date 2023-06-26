package com.fabien.spring.jpa.h2.controller;

import com.fabien.spring.jpa.h2.model.AeroClub;
import com.fabien.spring.jpa.h2.model.Tarif;
import com.fabien.spring.jpa.h2.repository.AeroClubRepository;
import com.fabien.spring.jpa.h2.repository.TarifRepository;
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
public class TarifController {

	@Autowired
	AeroClubRepository aeroClubRepository;

	@Autowired
	TarifRepository tarifRepository;

	@GetMapping("/tarif")
	public ResponseEntity<List<Tarif>> getAllTarifs() {
		try {
			List<Tarif> tarifs = new ArrayList<>();

			if (tarifs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tarifs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tarif/{id}")
	public ResponseEntity<Tarif> getTarifById(@PathVariable("id") long id) {
		Optional<Tarif> tarifData = tarifRepository.findById(id);

		if (tarifData.isPresent()) {
			return new ResponseEntity<>(tarifData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/tarif/{id}")
	public ResponseEntity<Tarif> createTarif(@RequestBody Tarif tarif, @PathVariable("id") long id) {
		Optional<AeroClub> aeroClub = aeroClubRepository.findById(id);
		System.out.println(aeroClub);

		try {
			Tarif _tarif = tarifRepository
					.save(new Tarif(tarif.getId(), tarif.getTaxeAtterrissage(), tarif.getTaxeParking(), tarif.getCarburant(), tarif.getAeroClub()));
			return new ResponseEntity<>(_tarif, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PutMapping("/tarif/{id}")
	public ResponseEntity<Tarif> updateTarif(@PathVariable("id") long id, @RequestBody Tarif tarif) {
		Optional<Tarif> tarifData = tarifRepository.findById(id);

		if (tarifData.isPresent()) {
			Tarif _tarif = tarifData.get();
			_tarif.setTaxeAtterrissage(tarif.getTaxeAtterrissage());
			_tarif.setTaxeParking(tarif.getTaxeParking());
			_tarif.setCarburant(tarif.getCarburant());
			return new ResponseEntity<>(tarifRepository.save(_tarif), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/tarif/{id}")
	public ResponseEntity<HttpStatus> deleteTarif(@PathVariable("id") long id) {
		try {
			tarifRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tarif")
	public ResponseEntity<HttpStatus> deleteAllTarifs() {
		try {
			tarifRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
