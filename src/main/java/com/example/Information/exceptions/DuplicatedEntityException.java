
package com.example.Information.exceptions;

import com.example.Information.exceptions.generic.ConflictException;

public class DuplicatedEntityException extends ConflictException {

	public DuplicatedEntityException() {
		super("Duplicated entity");
	}
}
