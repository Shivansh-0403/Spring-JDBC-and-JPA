package com.learningspring.database.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learningspring.database.entity.Person;

@Repository
@RestController
public class PersonJdbcDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@GetMapping("/persons")
	public List<Person> getAllData(){
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	@GetMapping("/persons/{id}")
	public Person getPersonById(@PathVariable int id) {
	    String sql = "SELECT * FROM person WHERE id = " + id + ";";
	    return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Person.class));
	}

	@GetMapping("/persons/delete/{id}")
	public void delPersonById(@PathVariable int id) {
	    String sql = "DELETE from PERSON where id = " + id + ";";
//	    jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Person.class));
	    jdbcTemplate.execute(sql);
	}
	
	@PostMapping("/persons/insert")
	public void insert(@RequestBody Person person) {
		String sql = "INSERT into PERSON (id, name, location, birth_date) values (?, ?, ?, ?);";
		jdbcTemplate.update(sql, new Object[] {person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirth_date().getTime())});
	}
}
