# Warm Up Task: Book Management

# Tasks: Implement the backend-features in Java using SpringBoot	

* Part I: Implementation
	Create a book management application.

	Each book has the following fields:
		id: the generated Value (Identity)
		text (String): text of the book/ book name (mandatory) (e.g. "Whatever you like")
		author (String): author name of the book (mandatory) (e.g. "Whoever")
		copies: number of copies, default 1 (mandatory)

* Implement a REST API for the following operations (Services):
	
	Services:
		1. Create a book.
		2. Update a book with a specific ID.
		3. Delete a book with a specific ID.		
		4. Get all books.
		
		Choose one of them (5. or 6.):
		5. Get books that contain specific book name
			e.g. input book name 'simple', return books containing name "simple_A" and book name "simple_B"
		
		6. Get number of copies by input book name 
			e.g. input book name 'simple', return copies = 10
					
		7. Optional: get number of copies of all books belong to the same author (input: author name)
		
		Hint (Optional): 
			- Query creation from method names: 
				https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
			- If possible, try to init SQL-database, create table and some sample data using scripts abc.sql  
	
	Technologies used: 
		Use Java, Maven, Spring Boot, JPA/ Hibernate, database PostgreSQL.


* Part II: Testing
	Write one test at the database level.
	Write one test at the service level.
	Write one test at the resource level.

	Use any other frameworks you like (e.g. JUnit, DbUnit or Mockito).

Push your code to Bitbucket or anywhere else you like
