package br.com.pweb.portifolio.services.exceptions;

// RuntimeException personalizada para representar a exceção de recurso não encontrado
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	// Construtor que recebe o ID do recurso não encontrado
	public ResourceNotFoundException(Object id) {
		// Chama o construtor da superclasse (RuntimeException) com uma mensagem de erro personalizada
		super("Usuário id: " + id + " não localizado.");
	}
}
