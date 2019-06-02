package com.example.Information.services.serviceImpl;

import com.example.Information.entities.Person;
import com.example.Information.exceptions.IdRequiredException;
import com.example.Information.exceptions.IllegalOperationException;
import com.example.Information.models.PersonModel;
import com.example.Information.repositories.PersonRepository;
import com.example.Information.services.PersonService;
import com.example.Information.exceptions.EntityNotFoundException;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;

	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public List<PersonModel> findAll() {
		return personRepository.findAll()
							   .stream()
							   .map(PersonModel::from)
							   .collect(Collectors.toList());
	}

	@Override
	public PersonModel findOne(long id) throws EntityNotFoundException {
		return personRepository.findById(id)
							   .map(PersonModel::from)
							   .orElseThrow(() -> new EntityNotFoundException(Person.class,id));
	}

	@Override
	public PersonModel save(PersonModel personModel) {


		Person person = new Person();
		person.setAge(personModel.getAge());
		person.setBirthPlace(personModel.getBirthPlace());
		person.setLastname(personModel.getLastname());
		person.setName(personModel.getName());
		person.setSons(new HashSet<>());

		return PersonModel.from(personRepository.save(person));
	}

	@Override
	public PersonModel addSon(long id, long son) throws EntityNotFoundException {
		Person retrievedSon = personRepository.findById(son).orElseThrow(EntityNotFoundException::new);
		Person retrievedFather = personRepository.findById(id).orElseThrow(EntityNotFoundException::new);

		if (retrievedSon.wasOnLinage(retrievedFather)) throw new IllegalArgumentException("the son can't be added");
		retrievedFather.addSon(retrievedSon);
		personRepository.save(retrievedFather);
		return PersonModel.from(retrievedFather);

	}


	@Override
	public String deleteSon(long id) throws Exception {
		Person son = personRepository.findById(id).orElseThrow(EntityNotFoundException::new);

		son.getFather().deleteSon(son);

		return "Son has been deleted ";
	}

	@Override
	public PersonModel update(long id, PersonModel personModel) throws IllegalOperationException, IdRequiredException, EntityNotFoundException {

		long personId = personModel.getId().orElseThrow(IdRequiredException::new);

		if (id != personId)
			throw new IllegalOperationException("IDs doesn't match");

		Person person = personRepository.findById(id).orElseThrow(EntityNotFoundException::new);

		person.setLastname(personModel.getLastname());
		person.setName(personModel.getName());
		person.setBirthPlace(personModel.getBirthPlace());
		person.setAge(personModel.getAge());

		return PersonModel.from(person);
	}

	@Override
	public void delete(long id) throws EntityNotFoundException {

		Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Person.class, id));
		personRepository.delete(person);
	}
}
