package org.codenaiten.notapp.domain.api;

import org.codenaiten.notapp.domain.entity.User;
import org.codenaiten.notapp.domain.type.Email;
import org.codenaiten.notapp.domain.type.LastName;
import org.codenaiten.notapp.domain.type.Name;
import org.codenaiten.notapp.domain.exception.CreateUserException;
import org.codenaiten.notapp.domain.type.user.UserName;

public interface UserService {

    User create(UserName username, Email email, String password, Name name, LastName lastname) throws CreateUserException;

}
