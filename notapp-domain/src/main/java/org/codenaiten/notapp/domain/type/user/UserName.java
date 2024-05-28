package org.codenaiten.notapp.domain.type.user;

import org.codenaiten.notapp.domain.core.vo.ValueObject;

import java.io.Serial;
import java.util.regex.Pattern;

public class UserName extends ValueObject<String> {

    /**
     * A unique version identifier for the Serializable class. This ID is used during the deserialization process to
     * verify that the sender and receiver of a serialized object maintain compatible versions of the class, ensuring
     * that the object can be correctly deserialized.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /** A pattern that matches valid usernames. */
    public static final Pattern PATTERN_USERNAME = Pattern.compile( "[a-z0-9+_.-]+", Pattern.CASE_INSENSITIVE );
    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 30;

// ------------------------------------------------------------------------------------------------------------------ \\

    private final String value;


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public UserName( final String value ){
        if( value == null || value.isEmpty() ){
            throw new IllegalArgumentException( "The username must not be null or empty" );
        }
        if( value.length() < MIN_SIZE ){
            throw new IllegalArgumentException(
                    String.format( "The username must have at least %d characters", MIN_SIZE ));
        }
        if( value.length() > MAX_SIZE ){
            throw new IllegalArgumentException(
                    String.format( "The username must have at most %d characters", MAX_SIZE ));
        }
        if( !PATTERN_USERNAME.matcher( value ).matches() ){
            throw new IllegalArgumentException(
                    String.format( "The username must have the following format: %s", PATTERN_USERNAME ));
        }

        this.value = value;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public UserName copy () {
        return new UserName(this.value);
    }

    @Override
    public String value () {
        return this.value;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| BUILDERS & VALIDATORS |-------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public static UserName of( final String username ){
        return new UserName(username);
    }

    public static boolean validate( final String username ){
        return helperValidate(() -> UserName.of(username));
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
