package br.com.pweb.portifolio.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.pweb.portifolio.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

// Classe para lidar com exceções globais na aplicação
@ControllerAdvice
public class ResourceExceptionHandler {
	
	// Anotação para indicar que este método trata exceções do tipo ResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Recurso não Encontrado."; // Mensagem de erro
		HttpStatus status = HttpStatus.NOT_FOUND; // Status HTTP 404 (Not Found)
		
		// Criação de um objeto StandardError com detalhes da exceção
		StandardError defaultError = new StandardError(
			Instant.now(),  // Timestamp atual
			status.value(),  // Código de status HTTP (404)
			error, // Mensagem de erro
			e.getMessage(), // Mensagem específica da exceção ResourceNotFoundException
			request.getRequestURI() // URI da requisição que causou a exceção
		);
		
		// Retorna uma resposta HTTP com o status e o corpo contendo o objeto StandardError
		return ResponseEntity.status(status).body(defaultError);
	}
	
}
