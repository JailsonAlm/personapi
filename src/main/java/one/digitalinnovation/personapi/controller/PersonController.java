package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Controller("/person")
@RequestMapping(value = "/api/v1/people", method = RequestMethod.GET)
public class PersonController {

    private PersonService personService;

    @Autowired(required = true)
    public PersonController(PersonService personService) {
        super();
        this.personService = personService;
    }

    // @GetMapping - Uma operação Http do tipo Get
    // @PostMapping - Criação de um livro
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    // Listar todos os elementos disponíveis
    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.lisAll();
    }

    // pegar uma pessoa especifica do banco de dados
    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id,@RequestBody PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }

    // Operação de delete
//    @GetMapping("/{id}") <- ERRADO
    @DeleteMapping("/{id}") //<- Certo
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(Long id) throws PersonNotFoundException {
        personService.deleteId(id);
    }
}
