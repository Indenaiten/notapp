package org.codenaiten.notapp.domain.service;

import org.codenaiten.notapp.domain.port.service.PassHasherServicePort;
import org.codenaiten.notapp.domain.type.Email;
import org.codenaiten.notapp.domain.type.LastName;
import org.codenaiten.notapp.domain.type.Name;
import org.codenaiten.notapp.domain.entity.User;
import org.codenaiten.notapp.domain.api.UserService;
import org.codenaiten.notapp.domain.exception.CreateUserException;
import org.codenaiten.notapp.domain.port.repository.UserRepositoryPort;
import org.codenaiten.notapp.domain.type.user.UserId;
import org.codenaiten.notapp.domain.type.user.UserName;

public class UserServiceImpl implements UserService {

    private final UserRepositoryPort userRepositoryPort;

    private final PassHasherServicePort passHasherServicePort;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public UserServiceImpl(
            final UserRepositoryPort userRepositoryPort,
            final PassHasherServicePort passHasherServicePort
    ) {
        this.userRepositoryPort = userRepositoryPort;
        this.passHasherServicePort = passHasherServicePort;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public User create(
            final UserName username,
            final Email email,
            final String password,
            final Name name,
            final LastName lastname
    ) throws CreateUserException {
        final UserId id = UserId.random();
        final String salt = this.passHasherServicePort.createSalt();
        final String passwordEncrypted = this.passHasherServicePort.hash( password, salt );
        final User user = new User(id, username, email, name, lastname, passwordEncrypted, salt);
        if( this.userRepositoryPort.find( username ).isPresent()){
            throw new CreateUserException(user, String.format( "Username \"%s\" already exists", username ));
        }
        if( this.userRepositoryPort.find( email ).isPresent()){
            throw new CreateUserException(user, String.format( "Email \"%s\" already exists", email ));
        }
        this.userRepositoryPort.save( user );
        return user;
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
