package br.com.dio.spring.service;

import br.com.dio.spring.dto.MessageResponseDTO;
import br.com.dio.spring.entity.Person;
import br.com.dio.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(Person person) {
        Person savadPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Create Person with ID" + savadPerson.getId())
                .build();

    }

}
