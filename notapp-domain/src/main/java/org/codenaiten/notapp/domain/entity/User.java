package org.codenaiten.notapp.domain.entity;

import org.codenaiten.notapp.domain.core.entity.Entity;
import org.codenaiten.notapp.domain.type.Email;
import org.codenaiten.notapp.domain.type.LastName;
import org.codenaiten.notapp.domain.type.Name;
import org.codenaiten.notapp.domain.type.user.UserId;
import org.codenaiten.notapp.domain.type.user.UserName;

import java.util.Objects;


public class User implements Entity {
    private final UserId id;
    private UserName username;
    private Email email;
    private Name name;
    private LastName lastname;
    private String password;
    private String salt;




// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public User(
            final UserId id,
            final UserName username,
            final Email email,
            final Name name,
            final LastName lastname,
            final String password,
            final String salt
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.salt = salt;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public boolean equals( final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        User user = (User) object;
        return Objects.equals(this.id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }




// ------------------------------------------------------------------------------------------------------------------ \\
// ---| SETTERS & GETTERS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public UserId getId() {
        return this.id;
    }

    public void setUsername( final UserName username ) {
        this.username = username;
    }

    public UserName getUsername() {
        return this.username;
    }

    public void setEmail( final Email email ) {
        this.email = email;
    }

    public Email getEmail() {
        return this.email;
    }

    public void setName( final Name name ) {
        this.name = name;
    }

    public Name getName() {
        return this.name;
    }

    public void setLastname( final LastName lastname ) {
        this.lastname = lastname;
    }
    public LastName getLastname() {
        return this.lastname;
    }

    public void setPassword( final String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setSalt( final String salt ) {
        this.salt = salt;
    }

    public String getSalt() {
        return this.salt;
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
