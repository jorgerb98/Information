package com.example.Information.services;

import com.example.Information.exceptions.EntityNotFoundException;
import com.example.Information.exceptions.IdRequiredException;
import com.example.Information.exceptions.IllegalOperationException;
import com.example.Information.models.PersonModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PersonService {

	List<PersonModel> findAll();

	PersonModel findOne(long id) throws EntityNotFoundException;

	PersonModel save(PersonModel personModel) ;

	PersonModel addSon(long id, long son) throws Exception;

	String deleteSon(long id) throws Exception;


	PersonModel update(long id, PersonModel personModel) throws IllegalOperationException, IdRequiredException, EntityNotFoundException;

	void delete(long id) throws EntityNotFoundException;

}
