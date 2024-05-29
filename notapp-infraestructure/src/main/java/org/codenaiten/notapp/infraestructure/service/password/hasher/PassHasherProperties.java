package org.codenaiten.notapp.infraestructure.service.password.hasher;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PassHasherProperties {

    @Value("${password.hasher.sign}")
    private String sign;

}
