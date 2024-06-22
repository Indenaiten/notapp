package org.codenaiten.notapp.domain.vo.user;

import org.codenaiten.notapp.domain.core.vo.ValueObject;

import java.io.Serial;
import java.util.UUID;

public class UserId extends ValueObject<UUID> {

    /**
     * A unique version identifier for the Serializable class. This ID is used during the deserialization process to
     * verify that the sender and receiver of a serialized object maintain compatible versions of the class, ensuring
     * that the object can be correctly deserialized.
     */
    @Serial
    private static final long serialVersionUID = 1L;

// ------------------------------------------------------------------------------------------------------------------ \\

    private final UUID value;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public UserId( final UUID value ){
        if( value == null ){
            throw new IllegalArgumentException( "The User ID must not be null" );
        }

        this.value = value;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public UserId copy() {
        return new UserId( this.value );
    }

    @Override
    public UUID value() {
        return this.value;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| BUILDERS & VALIDATORS |-------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public static UserId of( final String id ){
        return new UserId( UUID.fromString( id ));
    }

    public static UserId random(){
        return new UserId( UUID.randomUUID() );
    }

    public static boolean validate( final String id ){
        return helperValidate( () -> UserId.of( id ));
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
