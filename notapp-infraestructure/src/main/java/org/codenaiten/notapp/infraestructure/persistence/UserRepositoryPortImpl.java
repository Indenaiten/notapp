package org.codenaiten.notapp.infraestructure.persistence;


import org.codenaiten.notapp.domain.type.Email;
import org.codenaiten.notapp.domain.entity.User;
import org.codenaiten.notapp.domain.port.repository.UserRepositoryPort;
import org.codenaiten.notapp.domain.type.user.UserId;
import org.codenaiten.notapp.domain.type.user.UserName;
import org.codenaiten.notapp.infraestructure.persistence.model.UserModel;
import org.codenaiten.notapp.infraestructure.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryPortImpl implements UserRepositoryPort {

    private final UserRepository userRepository;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Autowired
    public UserRepositoryPortImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public Optional<User> find( final UserId id) {
        return this.userRepository.findById( id.toString() ).map( UserModel::toEntity );
    }

    @Override
    public Optional<User> find( final UserName username ) {
        return this.userRepository.findByUsername( username.value() ).map( UserModel::toEntity );
    }

    @Override
    public Optional<User> find( final Email email ) {
        return this.userRepository.findByEmail( email.value() ).map( UserModel::toEntity );
    }

    @Override
    public void save( final User user ) {
        this.userRepository.save( new UserModel( user ));
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
