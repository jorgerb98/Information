package com.example.Information.models;

import com.example.Information.entities.Person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PersonModel {


	@NotNull
	private String name;

	@NotNull
	private String lastname;

	@NotNull
	@Min(1)
	private int age;

	@NotNull
	private String birthPlace;

	private List<PersonModel> sons;

	public static PersonModel from(Person person){
		PersonModel personModel = new PersonModel();
		personModel.setAge(person.getAge());
		personModel.setBirthPlace(person.getBirthPlace());
		personModel.setLastname(person.getLastname());
		personModel.setName(person.getName());
		if (person.getSons().isPresent()){
			personModel.setSons(person.getSons().get().stream().map(PersonModel::from).collect(Collectors.toList()));
		}
		return personModel;
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

	public List<PersonModel> getSons() {
		return sons;
	}

	public void setSons(List<PersonModel> sons) {
		this.sons = sons;
	}
}
