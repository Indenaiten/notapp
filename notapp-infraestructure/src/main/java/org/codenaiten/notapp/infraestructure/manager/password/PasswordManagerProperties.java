package org.codenaiten.notapp.infraestructure.manager.password;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PasswordManagerProperties {

    @Value("${password.hasher.sign}")
    private String sign;

}
