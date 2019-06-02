package com.example.Information.repositories;

import com.example.Information.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

	Optional<Person> findByNameIgnoreCase(String name);
}
