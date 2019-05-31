package com.example.Information.services;

import com.example.Information.entities.Person;
import com.example.Information.exceptions.EntityNotFoundException;
import com.example.Information.models.PersonModel;

import java.util.List;

public interface PersonService {

	List<PersonModel> findAll();

	PersonModel findOne(long id) throws EntityNotFoundException;

	PersonModel save(PersonModel personModel) ;

	PersonModel update(long id, PersonModel personModel);

	void delete(long id) throws EntityNotFoundException;

}
