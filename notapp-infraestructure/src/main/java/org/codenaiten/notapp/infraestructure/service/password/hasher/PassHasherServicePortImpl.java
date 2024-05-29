package org.codenaiten.notapp.infraestructure.service.password.hasher;

import lombok.SneakyThrows;
import org.codenaiten.notapp.domain.port.service.PassHasherServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.UUID;

@Component
public class PassHasherServicePortImpl implements PassHasherServicePort {

    public static final String ALGORITHM = "SHA-256";
    public static final String DELIMITER = ".";

// ------------------------------------------------------------------------------------------------------------------ \\

    private final PassHasherProperties passHasherProperties;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Autowired
    public PassHasherServicePortImpl(final PassHasherProperties passHasherProperties) {
        this.passHasherProperties = passHasherProperties;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @SneakyThrows
    @Override
    public String hash(final String password, final String salt ) {
        final String sign = this.passHasherProperties.getSign();
        final String passwordSalted = String.join( DELIMITER, password, sign, salt);

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
