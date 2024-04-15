package br.com.pweb.portifolio.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Usuário id: " + id + " não localizado.");
	}
}
