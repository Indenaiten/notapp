package org.codenaiten.notapp.infraestructure.manager.password;

import lombok.SneakyThrows;
import org.codenaiten.notapp.domain.port.manager.PasswordManagerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.UUID;

@Component
public class PasswordManagerPortImpl implements PasswordManagerPort {

    public static final String ALGORITHM = "SHA-256";
    public static final String DELIMITER = ".";

// ------------------------------------------------------------------------------------------------------------------ \\

    private final PasswordManagerProperties passwordManagerProperties;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Autowired
    public PasswordManagerPortImpl(final PasswordManagerProperties passwordManagerProperties) {
        this.passwordManagerProperties = passwordManagerProperties;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @SneakyThrows
    @Override
    public String hash(final String password, final String salt ) {
        final String sign = this.passwordManagerProperties.getSign();
        final String passwordSalted = String.join( DELIMITER, password, salt, sign);

        final MessageDigest digest = MessageDigest.getInstance( ALGORITHM );
        final byte[] hash = digest.digest( passwordSalted.getBytes( StandardCharsets.UTF_8 ));
        return Base64.getEncoder().encodeToString( hash );
    }

    @Override
    public String createSalt() {
        return Base64.getEncoder().encodeToString( UUID.randomUUID().toString().getBytes( StandardCharsets.UTF_8 ));
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
