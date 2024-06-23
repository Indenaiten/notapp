package org.codenaiten.notapp.domain.service;

import org.codenaiten.notapp.domain.port.manager.PasswordManagerPort;
import org.codenaiten.notapp.domain.vo.Email;
import org.codenaiten.notapp.domain.vo.LastName;
import org.codenaiten.notapp.domain.vo.Name;
import org.codenaiten.notapp.domain.entity.User;
import org.codenaiten.notapp.domain.api.UserService;
import org.codenaiten.notapp.domain.exception.CreateUserException;
import org.codenaiten.notapp.domain.port.persistence.repository.UserRepositoryPort;
import org.codenaiten.notapp.domain.vo.user.UserId;
import org.codenaiten.notapp.domain.vo.user.UserName;

public class UserServiceImpl implements UserService {

    private final UserRepositoryPort userRepositoryPort;

    private final PasswordManagerPort passwordManagerPort;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public UserServiceImpl(
            final UserRepositoryPort userRepositoryPort,
            final PasswordManagerPort passwordManagerPort
    ) {
        this.userRepositoryPort = userRepositoryPort;
        this.passwordManagerPort = passwordManagerPort;
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
        final String salt = this.passwordManagerPort.createSalt();
        final String passwordEncrypted = this.passwordManagerPort.hash( password, salt );
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
