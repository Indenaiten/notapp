package org.codenaiten.notapp.infraestructure.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codenaiten.notapp.domain.type.Email;
import org.codenaiten.notapp.domain.type.LastName;
import org.codenaiten.notapp.domain.type.Name;
import org.codenaiten.notapp.domain.entity.User;
import org.codenaiten.notapp.domain.type.user.UserId;
import org.codenaiten.notapp.domain.type.user.UserName;
import org.codenaiten.notapp.infraestructure.core.entity.Entityable;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModel implements Entityable<User> {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "username", nullable = false, length = 250)
    private String username;

    @Column(name = "email", nullable = false, length = 250)
    private String email;

    @Column(name = "name", nullable = false, length = 250)
    private String name;

    @Column(name = "lastname", nullable = false, length = 250)
    private String lastname;

    @Column(name = "password", nullable = false, length = 250)
    private String password;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public UserModel( final User user ){
        this.id = user.getId() != null ? user.getId().toString() : null;
        this.username = user.getUsername() != null ? user.getUsername().value() : null;
        this.email = user.getEmail() != null ? user.getEmail().value() : null;
        this.name = user.getName() != null ? user.getName().value() : null;
        this.lastname = user.getLastname() != null ? user.getLastname().value() : null;
        this.password = user.getPassword();
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public User toEntity(){
        final UserId id = UserId.of( this.id );
        final UserName username = UserName.of( this.username );
        final Email email = Email.of( this.email );
        final Name name = Name.of( this.name );
        final LastName lastname = LastName.of( this.lastname );
        return new User( id, username, email, name, lastname, this.password);
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
