package org.codenaiten.notapp.infraestructure.rest.controller;

import lombok.SneakyThrows;
import org.codenaiten.notapp.application.api.SignupUseCase;
import org.codenaiten.notapp.application.dto.SignupDto;
import org.codenaiten.notapp.application.request.SignupRequest;
import org.codenaiten.notapp.infraestructure.rest.api.AuthRestController;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRestControllerImpl implements AuthRestController {

    private final SignupUseCase signupUseCase;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public AuthRestControllerImpl(final SignupUseCase signupUseCase) {
        this.signupUseCase = signupUseCase;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @SneakyThrows
    @Override
    public SignupDto signup(final SignupRequest request) {
        return this.signupUseCase.run( request );
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
