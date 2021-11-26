/*package br.com.dio.spring.service;

import br.com.dio.spring.dto.MessageResponseDTO;
import br.com.dio.spring.dto.request.PersonDTO;
import br.com.dio.spring.entity.Person;
import br.com.dio.spring.repository.PersonRepository;
import br.com.dio.spring.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonaService {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    void testGivenPersonDTOThenReturnSavedMessage() {

       PersonDTO personDTO = PersonUtils.createFakeDTO();

       Person  person = PersonUtils.createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MessageResponseDTO succesMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, succesMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + id)
                .build();
    }
}*/
