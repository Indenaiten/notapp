package org.codenaiten.notapp.infraestructure.decorator.usecase;

import jakarta.transaction.Transactional;
import org.codenaiten.notapp.application.api.LoginUseCase;
import org.codenaiten.notapp.application.exception.LoginException;
import org.codenaiten.notapp.application.request.LoginRequest;

public class LoginUseCaseDecorator implements LoginUseCase {

    private final LoginUseCase loginUseCase;

    public LoginUseCaseDecorator( final LoginUseCase loginUseCase ) {
        this.loginUseCase = loginUseCase;
    }

    @Transactional( rollbackOn = { LoginException.class })
    @Override
    public void run( final LoginRequest request ) throws LoginException {
        this.loginUseCase.run( request );
    }
}
