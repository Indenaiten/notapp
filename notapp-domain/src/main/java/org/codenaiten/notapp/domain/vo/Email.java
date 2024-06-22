package org.codenaiten.notapp.domain.vo;

import org.codenaiten.notapp.domain.core.vo.ValueObject;

import java.io.Serial;
import java.util.regex.Pattern;

/**
 * Represents an email address as a value object. This class encapsulates the concept of an email by dividing it into
 * its constituent parts: username and domain, and ensures that these parts conform to specific validation rules. It
 * extends {@code ValueObject<String>} to leverage value-based equality and immutability.
 */
public class Email extends ValueObject<String> {

    /**
     * A unique version identifier for the Serializable class. This ID is used during the deserialization process to
     * verify that the sender and receiver of a serialized object maintain compatible versions of the class, ensuring
     * that the object can be correctly deserialized.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /** The minimum number of domain levels required for a valid email address. */
    public static final int MIN_DOMAIN_LEVELS = 2;

    /** A pattern that matches valid usernames of email. */
    public static final Pattern PATTERN_USERNAME = Pattern.compile( "[a-z0-9+_.-]+", Pattern.CASE_INSENSITIVE );

    /** A pattern that matches valid email addresses. */
    public static final Pattern PATTERN_EMAIL = Pattern.compile( String.format( "^%s@[a-z0-9.-]+$", PATTERN_USERNAME ), Pattern.CASE_INSENSITIVE);

// ------------------------------------------------------------------------------------------------------------------ \\

    /** The full email address as a string. */
    private final String value;

    /** The username part of the email address. */
    private final String username;

    /** The domain part of the email address, represented as a {@link Domain} object. */
    private final Domain domain;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    /**
     * Constructs an Email object given the username and domain. Validates that both components meet specific format
     * requirements.
     *
     * @param username The local part of the email address.
     * @param domain   The domain part of the email address, encapsulated within a {@link Domain} object.
     *
     * @throws IllegalArgumentException if the domain is null, the username is null or empty, or if the username does
     *                                  not match the specified format.
     */
    public Email( final String username, final Domain domain ){
        if( domain == null ){
            throw new IllegalArgumentException( "The domain must not be null" );
        }
        if( username == null || username.isEmpty() ){
            throw new IllegalArgumentException( "The username must not be null or empty" );
        }
        if( !PATTERN_USERNAME.matcher( username ).matches() ){
            throw new IllegalArgumentException( String.format(
                    "The username must have the following format: %s", PATTERN_USERNAME ));
        }
        if( domain.size() < MIN_DOMAIN_LEVELS ){
            throw new IllegalArgumentException( String.format(
                    "The domain must have at least %d levels", MIN_DOMAIN_LEVELS ));
        }

        this.username = username;
        this.domain = domain;
        this.value = String.format( "%s@%s", username, domain.value() );
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public Email copy() {
        return new Email( this.username, this.domain );
    }

    @Override
    public String value() {
        return this.value;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| LOCAL METHODS |---------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    /**
     * Returns the username part of the email address.
     *
     * @return The username as a {@code String}.
     */
    public String username(){
        return this.username;
    }


    /**
     * Returns the domain part of the email address, encapsulated within a {@link Domain} object.
     *
     * @return The {@link Domain} of the email.
     */
    public Domain domain(){
        return this.domain;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| BUILDERS & VALIDATORS |-------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    /**
     * Creates and returns an Email object from a username and domain.
     *
     * @param username The local part of the email address.
     * @param domain   The domain part of the email address.
     *
     * @return An instance of {@code Email}.
     */
    public static Email of( final String username, final Domain domain ){
        return new Email( username, domain );
    }


    /**
     * Validates whether a given username and domain combination can form a valid Email object.
     *
     * @param username The local part of the email address.
     * @param domain   The domain part of the email address.
     *
     * @return {@code true} if the combination is valid, {@code false} otherwise.
     */
    public static boolean validate( final String username, final Domain domain ){
        return helperValidate( () -> Email.of( username, domain ));
    }


    /**
     * Creates and returns an Email object from a complete email string value.
     *
     * @param value The full email address as a {@code String}.
     * @return An instance of {@code Email}.
     *
     * @throws IllegalArgumentException if the value is null, empty, or does not match the specified format.
     */
    public static Email of( final String value ){
        if( value == null || value.isEmpty() ){
            throw new IllegalArgumentException( "Value must be not be null or empty" );
        }
        if( !PATTERN_EMAIL.matcher( value ).matches() ){
            throw new IllegalArgumentException( String.format(
                    "The value must have the following format: %s", PATTERN_EMAIL ));
        }

        final String[] parts = value.split( "@" );
        final String username = parts[0];
        final Domain domain = Domain.of( parts[1] );
        return new Email( username, domain );
    }


    /**
     * Validates whether a given email string value can form a valid Email object.
     *
     * @param value The full email address as a {@code String}.
     *
     * @return {@code true} if the value is valid, {@code false} otherwise.
     */
    public static boolean validate( final String value ){
        return helperValidate( () -> Email.of( value ));
    }



// ------------------------------------------------------------------------------------------------------------------ \\

}
