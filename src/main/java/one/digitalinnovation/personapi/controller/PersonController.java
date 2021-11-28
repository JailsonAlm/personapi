package one.digitalinnovation.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people") // caminho de acesso principal da API
public class PersonController {

    @GetMapping // Uma operação Http do tipo Get
    public String getBook(){
        return "API Test!";
    }
}
