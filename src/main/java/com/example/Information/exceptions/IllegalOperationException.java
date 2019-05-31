
package com.example.Information.exceptions;

import com.example.Information.exceptions.generic.ConflictException;

public class IllegalOperationException extends ConflictException {

	public IllegalOperationException(String s) {
		super(s);
	}
}
