package org.codenaiten.notapp.infraestructure.rest.controller;

import lombok.SneakyThrows;
import org.codenaiten.notapp.application.api.LoginUseCase;
import org.codenaiten.notapp.application.api.SignupUseCase;
import org.codenaiten.notapp.application.dto.SignupDto;
import org.codenaiten.notapp.application.request.LoginRequest;
import org.codenaiten.notapp.application.request.SignupRequest;
import org.codenaiten.notapp.application.usecase.LoginUseCaseImpl;
import org.codenaiten.notapp.infraestructure.rest.api.AuthRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRestControllerImpl implements AuthRestController {

    private final SignupUseCase signupUseCase;
    private final LoginUseCase loginUseCase;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public AuthRestControllerImpl(final SignupUseCase signupUseCase, final LoginUseCase loginUseCase) {
        this.signupUseCase = signupUseCase;
        this.loginUseCase = loginUseCase;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @SneakyThrows
    @Override
    public SignupDto signup(final SignupRequest request) {
        return this.signupUseCase.run( request );
    }

    @SneakyThrows
    @Override
    public void signup(final LoginRequest request) {
        this.loginUseCase.run(request);
    }

    // ------------------------------------------------------------------------------------------------------------------ \\

}
