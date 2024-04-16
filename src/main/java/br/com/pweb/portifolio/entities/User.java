package br.com.pweb.portifolio.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Declaração da entidade JPA representando a tabela 'tb_users' no banco de dados
@Entity
@Table(name = "tb_users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L; // Número de versão para serialização
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Chave primária da entidade
	private String nome; // Nome do usuário
	private String email; // Email do usuário
	private String telefone; // Telefone do usuário
	private String password; // Senha do usuário
	
	// Construtor padrão (obrigatório para JPA)
	public User() {
		super();
	}

	// Construtor com parâmetros para inicializar todos os campos da entidade
	public User(Long id, String nome, String email, String telefone, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.password = password;
	}

	 // Getters e Setters para todos os atributos da entidade
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Sobrescreve o método hashCode para utilizar apenas o 'id' na comparação
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	// Sobrescreve o método equals para comparar objetos usando apenas o 'id'
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
