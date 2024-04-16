package br.com.pweb.portifolio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pweb.portifolio.entities.User;
import br.com.pweb.portifolio.repositories.UserRepository;
import br.com.pweb.portifolio.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository; // Injeção de dependência do UserRepository
	
	// Método para buscar todos os usuários
	public List<User> findAll() {
		return repository.findAll(); // Retorna a lista de todos os usuários
	}
	
	// Método para buscar um usuário pelo ID
	public User findById(Long id) {
		Optional<User> usuario = repository.findById(id); // Busca o usuário pelo ID no repositório
		return usuario.orElseThrow(() -> new ResourceNotFoundException(id)); // Lança exceção se o usuário não for encontrado
	}
	
	// Método para inserir um novo usuário
	public User insert(User usuario) {
		return repository.save(usuario); // Insere o novo usuário no banco de dados
	}
	
	// Método para excluir um usuário pelo ID
	public void del(Long id) {
		try {
			repository.deleteById(id); // Exclui o usuário pelo ID
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id); // Lança exceção se o usuário não for encontrado
		}
	}
	
	// Método para atualizar um usuário pelo ID
	public User update(Long id, User usuario) {
		try {
			User cadastro = repository.getReferenceById(id);
			updateDados(cadastro, usuario); // Atualiza os dados do usuário existente com os novos dados
			return repository.save(cadastro); // Salva e retorna o usuário atualizado
		} catch (RuntimeException e) {
			throw new ResourceNotFoundException(id); // Lança exceção se o usuário não for encontrado
		}
	}

	// Método privado para atualizar os dados de um usuário existente com novos dados
	private void updateDados(User cadastro, User usuario) {
		// TODO Auto-generated method stub
		cadastro.setNome(usuario.getNome());
		cadastro.setEmail(usuario.getEmail());
		cadastro.setTelefone(usuario.getTelefone());
		
		// Adicione mais campos conforme necessário para atualização
		
	}
	
	
}
