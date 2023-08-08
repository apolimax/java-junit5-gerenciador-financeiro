package br.rn.will.seuBarriga.domain.exceptions;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = -8766265277982246998L;

	public ValidationException(String message) {
		super(message);
	}

}
