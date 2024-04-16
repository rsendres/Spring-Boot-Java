package br.com.pweb.portifolio.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.pweb.portifolio.entities.User;
import br.com.pweb.portifolio.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	// Método executado ao iniciar a aplicação (implementação da interface CommandLineRunner)
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// Criando instâncias de usuário para inserção de teste no banco de dados
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		// Salvando os usuários criados usando o UserRepository injetado
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}