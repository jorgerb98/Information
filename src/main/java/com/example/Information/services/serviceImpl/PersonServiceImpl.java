package com.example.Information.services.serviceImpl;

import com.example.Information.entities.Person;
import com.example.Information.models.PersonModel;
import com.example.Information.repositories.PersonRepository;
import com.example.Information.services.PersonService;
import com.example.Information.exceptions.EntityNotFoundException;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.stream.Collectors;

public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;

	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public List<PersonModel> findAll() {
		return personRepository.findAll().stream().map(PersonModel::from).collect(Collectors.toList());
	}

	@Override
	public PersonModel findOne(long id) throws EntityNotFoundException {
		return personRepository.findById(id).map(PersonModel::from).orElseThrow(() -> new EntityNotFoundException(Person.class,id));
	}

	@Override
	public PersonModel save(PersonModel personModel) {
		Person person = new Person();
		person.setAge(personModel.getAge());
		person.setBirthPlace(personModel.getBirthPlace());
		//person.setFather(personModel.g());
		person.setLastname(personModel.getLastname());
		person.setName(personModel.getName());
		//person.setSons(personModel.getSons().);

		return PersonModel.from(personRepository.save(person));
	}

	@Override
	public PersonModel update(long id, PersonModel personModel) {
		return null;
	}

	@Override
	public void delete(long id) throws EntityNotFoundException {


		Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Person.class, id));
		personRepository.delete(person);
	}
}
