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
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> usuario = repository.findById(id);
		return usuario.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User usuario) {
		return repository.save(usuario);
	}
	
	public void del(Long id) {
		try {
			repository.deleteById(id);
		} catch (ResourceNotFoundException e) {
			
		}
	}
	
	public User update(Long id, User usuario) {
		try {
			User cadastro = repository.getReferenceById(id);
			updateDados(cadastro, usuario);
			return repository.save(cadastro);
		} catch (RuntimeException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateDados(User cadastro, User usuario) {
		// TODO Auto-generated method stub
		cadastro.setNome(usuario.getNome());
		cadastro.setEmail(usuario.getEmail());
		cadastro.setTelefone(usuario.getTelefone());
		
	}
	
	
}
