package com.example.Information.controllers;

import com.example.Information.exceptions.EntityNotFoundException;
import com.example.Information.exceptions.IdRequiredException;
import com.example.Information.exceptions.IllegalOperationException;
import com.example.Information.models.PersonModel;
import com.example.Information.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping("/people")
	public List<PersonModel> findAll() {
		return personService.findAll();
	}


	@GetMapping("/people/{id}")
	public PersonModel findOne(@PathVariable long id) throws EntityNotFoundException {
		return personService.findOne(id);
	}

	@PostMapping("/people")
	public PersonModel save(@Valid @RequestBody PersonModel personModel) throws Exception {
		return personService.save(personModel);
	}

	@PutMapping("/people/{id}")
	public PersonModel update(@PathVariable long id, @RequestBody PersonModel personModel) throws EntityNotFoundException, IdRequiredException, IllegalOperationException {
		return personService.update(id, personModel);
	}

	@DeleteMapping("/people/{id}")
	public void delete(@PathVariable long id) throws EntityNotFoundException {
		personService.delete(id);
	}

	@PutMapping("/son/{id}/{son}")
	public PersonModel son(@PathVariable long id, @PathVariable long son) throws Exception {
		return personService.addSon(id, son);
	}
	@PutMapping("/son/{id}")
	public String son(@PathVariable long id) throws Exception {
		return personService.deleteSon(id);
	}
}
