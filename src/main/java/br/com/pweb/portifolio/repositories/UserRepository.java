package br.com.pweb.portifolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pweb.portifolio.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
