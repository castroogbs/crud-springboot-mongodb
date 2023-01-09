package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/**
	 * This bean will run by default, every time we start the application.
	 * 
	 * It should return a function that receives "args", that could be passed
	 * through command line, when we start the project.
	 */
	@Bean
	CommandLineRunner runner( // these parameters work like dependency injections
		StudentRepository repository,
		MongoTemplate mongoTemplate	
		) {
		// the return of this method is a lambda function
		return args -> {
			Address address = new Address(
				"Brasil",
				"São Paulo",
				"009231239"
			);

			Student student = new Student(
				"User",
				"Test",
				"usertest@usertest.com",
				Gender.FEMALE,
				address,
				List.of("Computer Science", "Maths"), // gens a list with the values passed through params
				BigDecimal.TEN,
				LocalDateTime.now()
			);

			// usingMongoTemplateAndQuery(repository, mongoTemplate, student);

			/**
			 * ifPresentOrElse(lambda, Runnable)
			 * 
			 * The lambda function will receive the student as an argument,
			 * if present.
			 */
			repository.findStudentByEmail(student.getEmail())
						.ifPresentOrElse( s -> {
							System.out.println("User alterady exists: " + student);
						}, () -> {
							System.out.println("Inserting student... " + student);
							repository.insert(student);
						});

		};
	}

	private void usingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, Student student) {
		// Query is a queryBuilder, that we can use to build custom queries
		Query query = new Query();
		// we still could add more method calls after the .is()
		query.addCriteria(Criteria.where("email").is(student.getEmail()));

		/**
		 * mongoTemplate will allow us to use the "query".
		 * 
		 * For example: the .find() method expects a Query and an Object that represents
		 * an Entity.
		 */
		List<Student> students = mongoTemplate.find(query, Student.class);

		/**
		 * Bellow we are doing some kind of validation to our user register.
		 */
		if (students.size() > 1) {
			throw new IllegalStateException("Found many students with the same e-mail. Email: " + student.getEmail());
		}

		if (students.isEmpty()) {
			System.out.println("Inserting student... " + student);
			repository.insert(student);
		} else {
			System.out.println("User alterady exists: " + student);
		}
	}

}
