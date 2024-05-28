package org.codenaiten.notapp.infraestructure.persistence.repository;


import org.codenaiten.notapp.domain.type.Email;
import org.codenaiten.notapp.domain.entity.User;
import org.codenaiten.notapp.domain.port.UserRepository;
import org.codenaiten.notapp.domain.type.user.UserId;
import org.codenaiten.notapp.domain.type.user.UserName;
import org.codenaiten.notapp.infraestructure.persistence.dao.UserDao;
import org.codenaiten.notapp.infraestructure.persistence.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserDao userDao;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Autowired
    public UserRepositoryImpl(final UserDao userDao) {
        this.userDao = userDao;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public Optional<User> find( final UserId id) {
        return this.userDao.findById( id.toString() ).map( UserModel::toEntity );
    }

    @Override
    public Optional<User> find( final UserName username ) {
        return this.userDao.findByUsername( username.value() ).map( UserModel::toEntity );
    }

    @Override
    public Optional<User> find( final Email email ) {
        return this.userDao.findByEmail( email.value() ).map( UserModel::toEntity );
    }

    @Override
    public void save( final User user ) {
        this.userDao.save( new UserModel( user ));
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
