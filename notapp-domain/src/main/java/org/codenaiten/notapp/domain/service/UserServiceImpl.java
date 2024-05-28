package org.codenaiten.notapp.domain.service;

import org.codenaiten.notapp.domain.type.Email;
import org.codenaiten.notapp.domain.type.LastName;
import org.codenaiten.notapp.domain.type.Name;
import org.codenaiten.notapp.domain.entity.User;
import org.codenaiten.notapp.domain.api.UserService;
import org.codenaiten.notapp.domain.exception.CreateUserException;
import org.codenaiten.notapp.domain.port.UserRepository;
import org.codenaiten.notapp.domain.type.user.UserId;
import org.codenaiten.notapp.domain.type.user.UserName;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
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
        final User user = new User(id, username, email, name, lastname, password);
        if( this.userRepository.find( username ).isPresent()){
            throw new CreateUserException(user, String.format( "Username \"%s\" already exists", username ));
        }
        if( this.userRepository.find( email ).isPresent()){
            throw new CreateUserException(user, String.format( "Email \"%s\" already exists", email ));
        }
        this.userRepository.save( user );
        return user;
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
