package br.com.pweb.portifolio.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

// Classe que representa a estrutura de um erro padrão para respostas de exceção
public class StandardError implements Serializable {


	private static final long serialVersionUID = 1L;
	private Instant timestamp; // Timestamp do momento em que o erro ocorreu
	private Integer status; // Código de status HTTP
	private String error; // Mensagem de erro genérica
	private String message; // Mensagem específica da exceção
	private String path; // URI da requisição que causou o erro
	
	// Construtor padrão
	public StandardError() {
		super();
	}

	// Construtor com parâmetros para inicializar todos os campos
	public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	
	// Getters e Setters para todos os campos da classe
	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
}
