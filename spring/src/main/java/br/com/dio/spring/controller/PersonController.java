package br.com.dio.spring.controller;

import br.com.dio.spring.dto.MessageResponseDTO;
import br.com.dio.spring.entity.Person;
import br.com.dio.spring.repository.PersonRepository;
import br.com.dio.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.createPerson(person);

    }

}
