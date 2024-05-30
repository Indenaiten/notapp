package org.codenaiten.notapp.infraestructure.rest.controller;

import lombok.SneakyThrows;
import org.codenaiten.notapp.application.api.LoginUseCase;
import org.codenaiten.notapp.application.api.SignupUseCase;
import org.codenaiten.notapp.application.dto.SignupDto;
import org.codenaiten.notapp.application.request.LoginRequest;
import org.codenaiten.notapp.application.request.SignupRequest;
import org.codenaiten.notapp.application.usecase.LoginUseCaseImpl;
import org.codenaiten.notapp.infraestructure.rest.api.AuthRestController;
import org.codenaiten.notapp.infraestructure.rest.response.ApiErrorCode;
import org.codenaiten.notapp.infraestructure.rest.response.ApiResponse;
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
    public ApiResponse<SignupDto> signup(final SignupRequest request) {
        final SignupDto result = this.signupUseCase.run( request );
        return ApiResponse.success().message( "User Register Succesfully" ).build( result );
    }

    @SneakyThrows
    @Override
    public ApiResponse<Void> login(final LoginRequest request) {
        this.loginUseCase.run(request);
        return ApiResponse.success().message( "Login Succesfully" ).build();
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
