package org.codenaiten.notapp.domain.type;

import org.codenaiten.notapp.domain.core.vo.ValueObject;

import java.io.Serial;
import java.util.regex.Pattern;

public class LastName extends ValueObject<String> {

    /**
     * A unique version identifier for the Serializable class. This ID is used during the deserialization process to
     * verify that the sender and receiver of a serialized object maintain compatible versions of the class, ensuring
     * that the object can be correctly deserialized.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /** A pattern that matches valid lastnames. */
    public static final Pattern PATTERN_USERNAME = Pattern.compile( "[a-záéíóúàèìòùäëïöü][a-záéíóúàèìòùäëïöü\\s-]+", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE );
    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 150;

// ------------------------------------------------------------------------------------------------------------------ \\

    private final String value;


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public LastName(final String value ){
        if( value == null || value.isEmpty() ){
            throw new IllegalArgumentException( "The lastname must not be null or empty" );
        }
        if( value.length() < MIN_SIZE ){
            throw new IllegalArgumentException(
                    String.format( "The lastname must have at least %d characters", MIN_SIZE ));
        }
        if( value.length() > MAX_SIZE ){
            throw new IllegalArgumentException(
                    String.format( "The lastname must have at most %d characters", MAX_SIZE ));
        }
        if( !PATTERN_USERNAME.matcher( value ).matches() ){
            throw new IllegalArgumentException(
                    String.format( "The lastname must have the following format: %s", PATTERN_USERNAME ));
        }

        this.value = value;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public LastName copy () {
        return new LastName(this.value);
    }

    @Override
    public String value () {
        return this.value;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| BUILDERS & VALIDATORS |-------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public static LastName of( final String lastname ){
        return new LastName(lastname);
    }

    public static LastName of( final String firstLastname, final String secondLastname ){
        return new LastName( String.join( " ", firstLastname, secondLastname ));
    }

    public static boolean validate( final String lastname ){
        return helperValidate(() -> LastName.of( lastname ));
    }
    public static boolean validate( final String firstLastname, final String secondLastname ){
        return helperValidate(() -> LastName.of( firstLastname, secondLastname ));
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
