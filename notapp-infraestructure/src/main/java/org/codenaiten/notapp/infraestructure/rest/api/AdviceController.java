package org.codenaiten.notapp.infraestructure.rest.api;

import org.codenaiten.notapp.application.exception.LoginException;
import org.codenaiten.notapp.application.exception.SignupException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public interface AdviceController {

    @ExceptionHandler(SignupException.class)
    ResponseEntity<String> signupException(SignupException e);

    @ExceptionHandler(LoginException.class)
    ResponseEntity<String> loginException(LoginException e);

}
