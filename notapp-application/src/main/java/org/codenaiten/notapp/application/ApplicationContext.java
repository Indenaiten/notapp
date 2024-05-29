package org.codenaiten.notapp.application;

import org.codenaiten.notapp.application.api.LoginUseCase;
import org.codenaiten.notapp.application.api.SignupUseCase;
import org.codenaiten.notapp.application.usecase.LoginUseCaseImpl;
import org.codenaiten.notapp.application.usecase.SignupUseCaseImpl;
import org.codenaiten.notapp.domain.DomainContext;

public abstract class ApplicationContext extends DomainContext {


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
