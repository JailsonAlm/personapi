package one.digitalinnovation.personapi.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    //Para criar as variáveis a seguir é preciso declarar enum na class
    HOME("Home"),
    MOBILE("Mobile"),
    COMERCIAL("Comercial");

    private final String descripition;
}
