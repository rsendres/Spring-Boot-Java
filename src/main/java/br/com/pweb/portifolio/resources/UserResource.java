package br.com.pweb.portifolio.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.pweb.portifolio.entities.User;
import br.com.pweb.portifolio.services.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service; // Injeção de dependência do serviço UserService
	
	// Endpoint para buscar todos os usuários
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll(); // Chama o serviço para buscar todos os usuários
		return ResponseEntity.ok().body(list); // Retorna a lista de usuários no corpo da resposta HTTP
	}
	
	// Endpoint para buscar um usuário pelo ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User usuario = service.findById(id); // Chama o serviço para buscar um usuário pelo ID
		return ResponseEntity.ok().body(usuario); // Retorna o usuário encontrado no corpo da resposta HTTP
	}
	
	// Endpoint para inserir um novo usuário
	@PostMapping()
	public ResponseEntity<User> insert(@RequestBody User usuario) {
		usuario = service.insert(usuario); // Chama o serviço para inserir o novo usuário
		// Monta a URI do recurso criado e retorna como parte da resposta HTTP
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(usuario); // Retorna a resposta HTTP com status 201 (Created)
	}
	
	// Endpoint para deletar um usuário pelo ID
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.del(id); // Chama o serviço para deletar o usuário pelo ID
		return ResponseEntity.noContent().build(); // Retorna uma resposta HTTP sem conteúdo com status 204 (No Content)
		
	}
	
	// Endpoint para atualizar um usuário pelo ID
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User usuario) {
		usuario = service.update(id, usuario); // Chama o serviço para atualizar o usuário pelo ID
		return ResponseEntity.ok().body(usuario); // Retorna o usuário atualizado no corpo da resposta HTTP
	}
	
	
	
	
	
	
	
	
	

}
