package br.com.dio.spring.service;

import br.com.dio.spring.dto.MessageResponseDTO;
import br.com.dio.spring.dto.request.PersonDTO;
import br.com.dio.spring.entity.Person;
import br.com.dio.spring.exception.PersonNotFoundException;
import br.com.dio.spring.mapper.PersonMapper;
import br.com.dio.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = personMapper.toModel(personDTO);


        Person savadPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Create Person with ID" + savadPerson.getId())
                .build();

    }


    public List<PersonDTO> listAll() {
        final List<Person> allPeople = personRepository.findAll();

        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {

         Person person = verifyifExists(id);
        // Optional<Person> optionalPerson = personRepository.findById(id);

        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyifExists(id);
        
        personRepository.deleteById(id);
    }

    private Person verifyifExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
