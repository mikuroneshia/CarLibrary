package com.kaiki.carlibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kaiki.carlibrary.repository.CarLibraryRepository;

@SpringBootApplication
public class CarLibraryApplication {
	@Autowired
	CarLibraryRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CarLibraryApplication.class, args);
	}

	/*@PostConstruct
	public void initialData() {
	}*/
}
