package org.codenaiten.notapp.domain;

import org.codenaiten.notapp.domain.api.UserService;
import org.codenaiten.notapp.domain.port.repository.UserRepositoryPort;
import org.codenaiten.notapp.domain.port.manager.PasswordManagerPort;
import org.codenaiten.notapp.domain.service.UserServiceImpl;

public abstract class DomainFactory {

// ------------------------------------------------------------------------------------------------------------------ \\
// ---| SERVICE |---------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public UserService userService(){
        return new UserServiceImpl( this.userRepositoryPort(), this.passHasherServicePort() );
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| PORT |------------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public abstract UserRepositoryPort userRepositoryPort();
    public abstract PasswordManagerPort passHasherServicePort();

// ------------------------------------------------------------------------------------------------------------------ \\

}
