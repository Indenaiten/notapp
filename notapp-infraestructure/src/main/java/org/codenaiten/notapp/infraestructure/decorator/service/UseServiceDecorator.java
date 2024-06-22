package org.codenaiten.notapp.infraestructure.decorator.service;

import jakarta.transaction.Transactional;
import org.codenaiten.notapp.domain.api.UserService;
import org.codenaiten.notapp.domain.entity.User;
import org.codenaiten.notapp.domain.exception.CreateUserException;
import org.codenaiten.notapp.domain.vo.Email;
import org.codenaiten.notapp.domain.vo.LastName;
import org.codenaiten.notapp.domain.vo.Name;
import org.codenaiten.notapp.domain.vo.user.UserName;

public class UseServiceDecorator implements UserService {

    private final UserService userService;

    public UseServiceDecorator( final UserService userService ) {
        this.userService = userService;
    }

    @Transactional( rollbackOn = { CreateUserException.class })
    @Override
    public User create(
            final UserName username,
            final Email email,
            final String password,
            final Name name,
            final LastName lastname
    ) throws CreateUserException {
        return this.userService.create( username, email, password, name, lastname );
    }
}
