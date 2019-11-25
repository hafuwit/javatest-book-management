package com.bookmanagement.bookmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookManagementApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/book-management/api");
		SpringApplication.run(BookManagementApplication.class, args);
	}
}