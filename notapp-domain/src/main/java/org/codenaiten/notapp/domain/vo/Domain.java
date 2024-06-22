package org.codenaiten.notapp.domain.vo;

import org.codenaiten.notapp.domain.core.vo.ValueObject;

import java.io.Serial;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a domain as a value object. A domain is structured as a sequence of levels (strings), typically
 * representing hierarchical elements of a URL or similar structured identifier.
 */
public class Domain extends ValueObject<String> {

    /**
     * A unique version identifier for the Serializable class. This ID is used during the deserialization process to
     * verify that the sender and receiver of a serialized object maintain compatible versions of the class, ensuring
     * that the object can be correctly deserialized.
     */
    @Serial
    private static final long serialVersionUID = 1L;

// ------------------------------------------------------------------------------------------------------------------ \\

    /** The string representation of the domain, composed of its levels. */
    private final String value;

    /** The levels of the domain, stored as an array of Strings. */
    private final String[] levels;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    /**
     * Constructs a Domain ValueObject from an array of levels. Validates that the levels array is not null and not
     * empty.
     *
     * @param levels An array of strings representing the levels of the domain.
     *
     * @throws IllegalArgumentException If levels is null or empty.
     */
    public Domain( final String[] levels ){
        if( levels == null ){
            throw new IllegalArgumentException( "The levels must not be null" );
        }
        if( levels.length == 0 ){
            throw new IllegalArgumentException( "The levels must not be empty" );
        }
        if( Arrays.stream(levels).anyMatch( item -> item == null || item.isEmpty() )){
            throw new IllegalArgumentException( "All levels must not be null and empty" );
        }

        this.levels = levels;
        this.value = this.level( this.size() );
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\


    @Override
    public Domain copy() {
        return new Domain( this.levels );
    }


    @Override
    public String value() {
        return this.value;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| LOCAL METHODS |---------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    /**
     * Retrieves the domain level at the specified depth. The depth is 1-based, meaning that a depth of 1 refers to the
     * top level of the domain. This method constructs the domain string up to the specified depth, joining the levels
     * with dots.
     *
     * @param x The depth of the level to retrieve. It must be greater than 0 and not exceed the number of available
     *          levels in the domain.
     *
     * @return A string containing the constructed domain up to the specified depth. If the depth is within valid range,
     *          the returned string includes the domain levels up to that depth, separated by dots. If the provided
     *          depth is 1, it returns the top level of the domain; for a depth equal to the number of levels, it
     *          returns the full domain. The string does not end with a dot.
     *
     * @throws IllegalArgumentException if the level value is less than or equal to 0, or if it exceeds the number of
     *                                  available levels.
     */
    public String level( final int x ){
        if( x <= 0){
            throw new IllegalArgumentException( "The level value must be greater than 0" );
        }
        if( x > this.size() ){
            throw new IllegalArgumentException( "The level value must not exceed the available levels" );
        }

        final StringBuilder builder = new StringBuilder();
        for( int i = (x - 1) ; i >= 0 ; i-- ){
            builder.append( this.levels[i] ).append( '.' );
        }

        return builder.substring( 0, builder.length() -1 );
    }


    /**
     * Returns an array containing the levels of the domain.
     *
     * @return An array of strings representing the domain levels.
     */
    public String[] levels(){
        return this.levels;
    }


    /**
     * Returns the number of levels in the domain.
     *
     * @return The number of levels.
     */
    public int size(){
        return this.levels.length;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| BUILDERS & VALIDATORS |-------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    /**
     * Constructs a Domain object from an array of levels.
     *
     * @param levels An array of strings representing the levels of the domain.
     *
     * @return A new Domain object representing the specified levels.
     */
    public static Domain of( final String ...levels ){
        return new Domain( levels );
    }


    /**
     * Validates if the provided levels can represent a valid Domain object.
     *
     * @param levels An array of strings representing the levels of the domain.
     *
     * @return True if the levels can be used to construct a valid Domain object; false otherwise.
     */
    public static boolean validate( final String ...levels ){
        return helperValidate( () -> Domain.of( levels ) );
    }


    /**
     * Constructs a Domain object from a string representation of the domain.
     *
     * @param value A string representing the domain, with levels separated by dots.
     *
     * @return A new Domain object representing the specified domain.
     *
     * @throws IllegalArgumentException If value is null or empty.
     */
    public static Domain of( final String value ){
        if( value == null || value.isEmpty() ){
            throw new IllegalArgumentException( "Value must be exists" );
        }

        final String[] levels = value.split( "\\." );
        final List<String> levelsInverse = new LinkedList<>();
        for( int i = (levels.length -1) ; i >= 0 ; i-- ){
            levelsInverse.add( levels[i] );
        }
        return new Domain( levelsInverse.toArray( new String[0] ));
    }


    /**
     * Validates if the provided string can represent a valid Domain object.
     *
     * @param value A string representing the domain.
     *
     * @return True if the string can be used to construct a valid Domain object; false otherwise.
     */
    public static boolean validate( final String value ){
        return helperValidate( () -> Domain.of( value ) );
    }



// ------------------------------------------------------------------------------------------------------------------ \\

}
