package one.digitalinnovation.personapi.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    // Utilizar as anotações JPA para fazer o mapeamento das entidades e criar o modelo de dados

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // delega para o banco a estratégia de geração de chaves primárias
    // generationType.IDENTITY - toda vez que inserir um dado ele vai ser de forma incremental

    // ao informar esse dado da nossa API ele será cadastrado como obrigatório
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;
}
