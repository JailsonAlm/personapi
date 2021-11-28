package one.digitalinnovation.personapi.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.*;

@Entity // Indicando que a classe é uma entidade e para ela ser reconhecida pelo banco
@Data // Automaticamente vai inserir o geter and setter
@Builder  // vai dar um padrão de projeto para fazer a construção de objetos
@AllArgsConstructor // inserir os construtores
@NoArgsConstructor // inserir os construtores
public class Phone {
    // Utilizar as anotações JPA para fazer o mapeamento das entidades e criar o modelo de dados

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // delega para o banco a estratégia de geração de chaves primárias
    // generationType.IDENTITY - toda vez que inserir um dado ele vai ser de forma incremental
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)// ao informar esse dado da nossa API ele será cadastrado como obrigatório
    private PhoneType type;

    @Column(nullable = false)
    private String number;
}
