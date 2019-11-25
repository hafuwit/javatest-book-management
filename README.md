# Warm Up Task: Book Management

# Tasks: Implement the backend-features in Java using SpringBoot	

* Part I: Implementation
	Create a book management application.

	Each book has the following fields: <br>
		+ id: the generated Value (Identity) <br>
		+ text (String): text of the book/ book name (mandatory) (e.g. "Whatever you like") <br>
		+ author (String): author name of the book (mandatory) (e.g. "Whoever") <br>
		+ copies: number of copies, default 1 (mandatory) <br>

* Implement a REST API for the following operations (Services):
	
	Services: <br>
		1. Create a book. <br>
		2. Update a book with a specific ID. <br>
		3. Delete a book with a specific ID. <br>
		4. Get all books. <br>
		Choose one of them (5. or 6.): <br>
		5. Get books that contain specific book name <br>
			e.g. input book name 'simple', return books containing name "simple_A" and book name "simple_B" <br>
		6. Get number of copies by input book name <br>
			e.g. input book name 'simple', return copies = 10 <br>
		7. Optional: get number of copies of all books belong to the same author (input: author name) <br>
		<br>
		Hint (Optional): <br>
			- Query creation from method names: <br>
				https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
			- If possible, try to init SQL-database, create table and some sample data using scripts abc.sql <br>
	
	Technologies used: <br>
		Use Java, Maven, Spring Boot, JPA/ Hibernate, database PostgreSQL. <br>


* Part II: Testing <br>
	Write one test at the database level. <br>
	Write one test at the service level. <br>
	Write one test at the resource level. <br>

	Use any other frameworks you like (e.g. JUnit, DbUnit or Mockito).
