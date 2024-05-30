package org.codenaiten.notapp.infraestructure.rest.api;

import org.codenaiten.notapp.application.exception.LoginException;
import org.codenaiten.notapp.application.exception.SignupException;
import org.codenaiten.notapp.infraestructure.rest.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public interface AdviceController {

    @ExceptionHandler(Exception.class)
    ResponseEntity<ApiResponse<Void>> exception(Exception e);

    @ExceptionHandler(SignupException.class)
    ResponseEntity<ApiResponse<Void>> signupException(SignupException e);

    @ExceptionHandler(LoginException.class)
    ResponseEntity<ApiResponse<Void>> loginException(LoginException e);

}
