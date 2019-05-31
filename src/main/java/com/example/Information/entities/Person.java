package com.example.Information.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String name;

	@NotNull
	private String lastname;

	@NotNull
	@Min(1)
	private int age;

	@NotNull
	private String birthPlace;

	private Optional<Person> father;

	private Optional<List<Person>> sons;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Optional<Person> getFather() {
		return father;
	}

	public void setFather(Optional<Person> father) {
		this.father = father;
	}

	public Optional<List<Person>> getSons() {
		return sons;
	}

	public void setSons(Optional<List<Person>> sons) {
		this.sons = sons;
	}
}
