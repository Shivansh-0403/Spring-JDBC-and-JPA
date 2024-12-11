package com.learningspring.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.learningspring.database.jdbc.PersonJdbcDao;
import com.learningspring.database.jpa.PersonJpaRepository;

@SpringBootApplication
public class DatabaseApplication {
	// public class DatabaseApplication implements CommandLineRunner{

	// private Logger logger = LoggerFactory.getLogger(this.getClass());

	// @Autowired
	// PersonJpaRepository dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception{
	// logger.info("PERON DATA :- {}", dao.findById(1001));
	// }
}
