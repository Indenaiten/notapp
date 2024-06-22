package org.codenaiten.notapp.infraestructure.persistence;


import org.codenaiten.notapp.domain.vo.Email;
import org.codenaiten.notapp.domain.entity.User;
import org.codenaiten.notapp.domain.port.repository.UserRepositoryPort;
import org.codenaiten.notapp.domain.vo.user.UserId;
import org.codenaiten.notapp.domain.vo.user.UserName;
import org.codenaiten.notapp.infraestructure.persistence.model.UserModel;
import org.codenaiten.notapp.infraestructure.persistence.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryPortImpl implements UserRepositoryPort {

    private final UserDao userDao;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Autowired
    public UserRepositoryPortImpl(final UserDao userDao) {
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
