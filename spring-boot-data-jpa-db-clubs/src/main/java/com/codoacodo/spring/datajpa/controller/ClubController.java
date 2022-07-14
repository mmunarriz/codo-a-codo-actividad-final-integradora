package com.codoacodo.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codoacodo.spring.datajpa.model.Club;
import com.codoacodo.spring.datajpa.repository.ClubRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ClubController {

	@Autowired
	ClubRepository tutorialRepository;

	@GetMapping("/clubs")
	public ResponseEntity<List<Club>> getAllClubs(@RequestParam(required = false) String title) {
		try {
			List<Club> clubs = new ArrayList<Club>();

			if (title == null)
				tutorialRepository.findAll().forEach(clubs::add);
			else
				tutorialRepository.findByTitleContaining(title).forEach(clubs::add);

			if (clubs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(clubs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/clubs/{id}")
	public ResponseEntity<Club> getTutorialById(@PathVariable("id") long id) {
		Optional<Club> tutorialData = tutorialRepository.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/clubs")
	public ResponseEntity<Club> createTutorial(@RequestBody Club tutorial) {
		try {
			Club _tutorial = tutorialRepository
					.save(new Club(tutorial.getTitle(), tutorial.getDescription(), false));
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/clubs/{id}")
	public ResponseEntity<Club> updateTutorial(@PathVariable("id") long id, @RequestBody Club tutorial) {
		Optional<Club> tutorialData = tutorialRepository.findById(id);

		if (tutorialData.isPresent()) {
			Club _tutorial = tutorialData.get();
			_tutorial.setTitle(tutorial.getTitle());
			_tutorial.setDescription(tutorial.getDescription());
			_tutorial.setPublished(tutorial.isPublished());
			return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/clubs/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			tutorialRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/clubs")
	public ResponseEntity<HttpStatus> deleteAllClubs() {
		try {
			tutorialRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/clubs/published")
	public ResponseEntity<List<Club>> findByPublished() {
		try {
			List<Club> clubs = tutorialRepository.findByPublished(true);

			if (clubs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(clubs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
