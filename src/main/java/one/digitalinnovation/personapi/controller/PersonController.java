package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people") // caminho de acesso principal da API
public class PersonController {

    private PersonRepository personRepository;

    // Uma das grandes vantagens do Spring é a gestão de dependências

    @Autowired //indica para a string injetar uma aplicação do tipo repository aqui para dentro
    // A vantagem de inserir dentro de um construtor é que ele facilita para criar testes unitários
    // mais para frente
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // @GetMapping - Uma operação Http do tipo Get
    @PostMapping // Criação de um livro
    public MessageResponseDTO createPerson(@RequestBody Person person){
        //@RequestBody a firma que está vindo uma requisição do tipo pessoas aqui
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID" +savedPerson.getId())
                .build();
    }
}
