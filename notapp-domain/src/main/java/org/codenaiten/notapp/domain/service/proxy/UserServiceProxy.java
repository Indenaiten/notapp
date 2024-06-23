package org.codenaiten.notapp.domain.service.proxy;

import org.codenaiten.notapp.domain.api.UserService;
import org.codenaiten.notapp.domain.entity.User;
import org.codenaiten.notapp.domain.exception.CreateUserException;
import org.codenaiten.notapp.domain.vo.Email;
import org.codenaiten.notapp.domain.vo.LastName;
import org.codenaiten.notapp.domain.vo.Name;
import org.codenaiten.notapp.domain.vo.user.UserName;

public class UserServiceProxy implements UserService {

    private final UserService userService;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public UserServiceProxy( final UserService userService ) {
        this.userService = userService;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public User create( final UserName username, final Email email, final String password, final Name name, final LastName lastname) throws CreateUserException {
        return this.userService.create( username, email, password, name, lastname );
    }


// ------------------------------------------------------------------------------------------------------------------ \\

}
