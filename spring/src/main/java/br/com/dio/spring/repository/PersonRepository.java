package br.com.dio.spring.repository;

import br.com.dio.spring.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person, Long> {

}
