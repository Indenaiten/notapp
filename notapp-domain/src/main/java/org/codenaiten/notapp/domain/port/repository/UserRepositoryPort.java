package org.codenaiten.notapp.domain.port.repository;

import org.codenaiten.notapp.domain.type.Email;
import org.codenaiten.notapp.domain.type.user.UserId;
import org.codenaiten.notapp.domain.type.user.UserName;
import org.codenaiten.notapp.domain.entity.User;

import java.util.Optional;

public interface UserRepositoryPort {
    Optional<User> find( UserId id );
    Optional<User> find(UserName username);
    Optional<User> find(Email email);
    void save( User user );
}
