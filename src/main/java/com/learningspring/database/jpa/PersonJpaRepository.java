package com.learningspring.database.jpa;

import org.slf4j.*;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import com.learningspring.database.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
@RestController
public class PersonJpaRepository {
	@PersistenceContext
	EntityManager entityManager;
	
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/persons/jpa/{id}")
	public Person findById(@PathVariable int id) {
		System.out.println(entityManager.find(Person.class, id));
		return (Person) entityManager.find(Person.class, id);
	}
	
	@PostMapping("/persons/jpa/insert")
	public Person insertPerson(@RequestBody Person person) {
		return (Person) entityManager.merge(person);
	}
	
	@PostMapping("/persons/jpa/update")
	public Person update(@RequestBody Person person) {
		return (Person) entityManager.merge(person);
	}
	
	@GetMapping("/persons/jpa/delete")
	public ResponseEntity<String> deletePersonById(@RequestParam int id) {
		entityManager.remove(findById(id));
//		return ResponseEntity.status(200)
//                .body("This is a response with status code and body");
		return ResponseEntity.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body("Deleted User with id " + id);
	}
}
