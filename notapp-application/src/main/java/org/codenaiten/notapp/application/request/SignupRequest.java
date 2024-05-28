package org.codenaiten.notapp.application.request;

import java.io.Serial;
import java.io.Serializable;

public class SignupRequest implements Serializable {

    /**
     * A unique version identifier for the Serializable class. This ID is used during the deserialization process to
     * verify that the sender and receiver of a serialized object maintain compatible versions of the class, ensuring
     * that the object can be correctly deserialized.
     */
    @Serial
    private static final long serialVersionUID = 1L;

// ------------------------------------------------------------------------------------------------------------------ \\

    private final String username;
    private final String email;
    private final String name;
    private final String lastname;
    private final String password;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public SignupRequest(
            final String username,
            final String email,
            final String name,
            final String lastname,
            final String password
    ) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| GETTERS |---------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getPassword() {
        return this.password;
    }

// ------------------------------------------------------------------------------------------------------------------ \\
}
