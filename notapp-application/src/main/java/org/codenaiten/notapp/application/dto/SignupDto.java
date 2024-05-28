package org.codenaiten.notapp.application.dto;

import org.codenaiten.notapp.domain.entity.User;

import java.io.Serial;
import java.io.Serializable;

public class SignupDto implements Serializable {

    /**
     * A unique version identifier for the Serializable class. This ID is used during the deserialization process to
     * verify that the sender and receiver of a serialized object maintain compatible versions of the class, ensuring
     * that the object can be correctly deserialized.
     */
    @Serial
    private static final long serialVersionUID = 1L;

// ------------------------------------------------------------------------------------------------------------------ \\

    private final String id;
    private final String username;
    private final String email;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public SignupDto(
            final String id,
            final String username,
            final String email
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public SignupDto( final User user ) {
        this.id = user.getId() != null ? user.getId().toString() : null;
        this.username = user.getUsername() != null ? user.getUsername().toString() : null;
        this.email = user.getEmail() != null ? user.getEmail().toString() : null;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| GETTERS |---------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public String getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

// ------------------------------------------------------------------------------------------------------------------ \\
}
