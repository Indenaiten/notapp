package org.codenaiten.notapp.application.request;

import java.io.Serial;
import java.io.Serializable;

public class LoginRequest implements Serializable {

    /**
     * A unique version identifier for the Serializable class. This ID is used during the deserialization process to
     * verify that the sender and receiver of a serialized object maintain compatible versions of the class, ensuring
     * that the object can be correctly deserialized.
     */
    @Serial
    private static final long serialVersionUID = 1L;

// ------------------------------------------------------------------------------------------------------------------ \\

    private final String login;
    private final String password;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public LoginRequest(
            final String login,
            final String password
    ) {
        this.login = login;
        this.password = password;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| GETTERS |---------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

// ------------------------------------------------------------------------------------------------------------------ \\
}
