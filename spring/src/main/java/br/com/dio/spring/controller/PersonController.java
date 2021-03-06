package br.com.dio.spring.controller;

import br.com.dio.spring.dto.MessageResponseDTO;
import br.com.dio.spring.dto.request.PersonDTO;
import br.com.dio.spring.entity.Person;
import br.com.dio.spring.exception.PersonNotFoundException;
import br.com.dio.spring.repository.PersonRepository;
import br.com.dio.spring.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);

    }

    @GetMapping
    public List<PersonDTO> listAll() {
       return personService.listAll();
    }

    @GetMapping("{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {

        return personService.findById(id);
    }

    @PutMapping("{id}")
    public MessageResponseDTO updateById(Long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
            return personService.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }

}
