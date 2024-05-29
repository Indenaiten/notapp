package org.codenaiten.notapp.infraestructure.service.password.hasher;

import org.codenaiten.notapp.domain.port.service.PassHasherServicePort;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassHasherServicePortImpl implements PassHasherServicePort {

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

    @Override
    public String hash(final String password, final String salt ) {
        return BCrypt.hashpw(this.saltPassword( password ), salt);
    }

    @Override
    public String createSalt() {
        return BCrypt.gensalt();
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| PRIVATE METHODS |-------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    private String saltPassword( final String password ){
        return String.join("", this.passHasherProperties.getSign(), password);
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
