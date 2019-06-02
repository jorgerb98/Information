package com.example.Information.models;

import com.example.Information.entities.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class PersonModel {

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

	private String password;

	private PersonModel father;

	private List<PersonModel> sons;

	public static PersonModel from(Person person){
		PersonModel personModel = new PersonModel();
		personModel.setId(person.getId());
		personModel.setAge(person.getAge());
		personModel.setBirthPlace(person.getBirthPlace());
		personModel.setLastname(person.getLastname());
		personModel.setName(person.getName());
		if (person.getSons().isPresent())
			personModel.setSons(person.getSons().get().stream().map(PersonModel::from).collect(Collectors.toList()));
		if (person.getFather().isPresent())
			personModel.setFather(PersonModel.from(person.getFather().get()));

		personModel.setPassword(person.getPassword());

		return personModel;
	}

	public Optional<Long> getId() {
		return Optional.ofNullable(id);
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

	public Optional<List<PersonModel>> getSons() {
		return Optional.ofNullable(sons);
	}
	public void setSons(List<PersonModel> sons) {
		this.sons = sons;
	}
	public Optional<PersonModel> getFather() {
		return Optional.ofNullable(father);
	}

	public void setFather(PersonModel father) {
		this.father = father;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
