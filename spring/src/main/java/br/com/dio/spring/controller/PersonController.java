package br.com.dio.spring.controller;

import br.com.dio.spring.dto.MessageResponseDTO;
import br.com.dio.spring.entity.Person;
import br.com.dio.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {


    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        Person savadPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Create Person with ID" + savadPerson.getId())
                .build();

    }

}
