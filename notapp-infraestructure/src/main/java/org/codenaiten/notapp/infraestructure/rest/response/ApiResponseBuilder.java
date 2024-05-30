package org.codenaiten.notapp.infraestructure.rest.response;

public class ApiResponseBuilder{

    private ApiErrorCode code;
    private String message;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public ApiResponseBuilder( final ApiErrorCode code ) {
        this.code = code;
    }

    public ApiResponseBuilder( final int code ) {
        this.code = ApiErrorCode.of( code );
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| SETTER METHODS |--------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public ApiResponseBuilder message( final String message ){
        this.message = message;
        return this;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| BUILDER METHODS |-------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public <T> ApiResponse<T> build( final T data){
        return new ApiResponse<>( this.code, this.message, data );
    }

    public ApiResponse<Void> build(){
        return new ApiResponse<>( this.code, this.message, null );
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}