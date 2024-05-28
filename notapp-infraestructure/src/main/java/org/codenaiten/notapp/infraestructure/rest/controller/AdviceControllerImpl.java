package org.codenaiten.notapp.infraestructure.rest.controller;

import org.codenaiten.notapp.application.exception.SignupException;
import org.codenaiten.notapp.infraestructure.rest.api.AdviceController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class AdviceControllerImpl implements AdviceController {


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public ResponseEntity<String> signupException(final SignupException e) {
        return ResponseEntity.badRequest().body( e.getMessage() );
    }


// ------------------------------------------------------------------------------------------------------------------ \\

}
