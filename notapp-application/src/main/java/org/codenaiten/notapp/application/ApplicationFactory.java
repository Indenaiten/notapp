package org.codenaiten.notapp.application;

import org.codenaiten.notapp.application.api.LoginUseCase;
import org.codenaiten.notapp.application.api.SignupUseCase;
import org.codenaiten.notapp.application.usecase.LoginUseCaseImpl;
import org.codenaiten.notapp.application.usecase.SignupUseCaseImpl;
import org.codenaiten.notapp.domain.DomainFactory;

public abstract class ApplicationFactory extends DomainFactory {

// ------------------------------------------------------------------------------------------------------------------ \\
// ---| USE CASE |--------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public SignupUseCase signupUseCase(){
        return new SignupUseCaseImpl( this.userService() );
    }

    public LoginUseCase loginUseCase(){
        return new LoginUseCaseImpl( this.userRepositoryPort(), this.passHasherServicePort() );
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
