package br.com.pweb.portifolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pweb.portifolio.entities.User;

// Interface que estende JpaRepository para manipulação de entidades User no banco de dados
public interface UserRepository extends JpaRepository<User, Long> {
	// JpaRepository<User, Long>:
    // - User: Tipo da entidade com a qual esta interface irá trabalhar (User neste caso)
    // - Long: Tipo da chave primária da entidade (o tipo do campo 'id' da entidade User)

    // Esta interface herda todos os métodos CRUD (Create, Read, Update, Delete) de JpaRepository
    // para a entidade User, incluindo métodos como save(), findById(), findAll(), delete(), etc.
}
