package org.codenaiten.notapp.domain;

import org.codenaiten.notapp.domain.api.UserService;
import org.codenaiten.notapp.domain.port.persistence.manager.TransactionalManagerPort;
import org.codenaiten.notapp.domain.port.persistence.repository.UserRepositoryPort;
import org.codenaiten.notapp.domain.port.manager.PasswordManagerPort;
import org.codenaiten.notapp.domain.service.UserServiceImpl;
import org.codenaiten.notapp.domain.service.proxy.UserServiceProxy;

public abstract class DomainFactory {

// ------------------------------------------------------------------------------------------------------------------ \\
// ---| SERVICE |---------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public UserService userService(){
        return new UserServiceProxy(
                new UserServiceImpl( this.userRepositoryPort(), this.passHasherServicePort() ));
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| PORT |------------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public abstract TransactionalManagerPort transactionalManagerPort();
    public abstract UserRepositoryPort userRepositoryPort();
    public abstract PasswordManagerPort passHasherServicePort();

// ------------------------------------------------------------------------------------------------------------------ \\

}
