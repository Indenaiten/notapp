package org.codenaiten.notapp.infraestructure.rest.controller;

import org.codenaiten.notapp.application.exception.LoginException;
import org.codenaiten.notapp.application.exception.SignupException;
import org.codenaiten.notapp.infraestructure.rest.api.AdviceController;
import org.codenaiten.notapp.infraestructure.rest.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class AdviceControllerImpl implements AdviceController {


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\


    @Override
    public ResponseEntity<ApiResponse<Void>> exception( final Exception e ) {
        e.printStackTrace();
        final ApiResponse<Void> response = ApiResponse.error().message( "Error !" ).build();
        return ResponseEntity.internalServerError().body( response );
    }


    @Override
    public ResponseEntity<ApiResponse<Void>> signupException( final SignupException e ) {
        final ApiResponse<Void> response = ApiResponse.error().message( e.getMessage() ).build();
        return ResponseEntity.badRequest().body( response );
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> loginException( final LoginException e ) {
        final ApiResponse<Void> response = ApiResponse.error().message( e.getMessage() ).build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body( response );
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
