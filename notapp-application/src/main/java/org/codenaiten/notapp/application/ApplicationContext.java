package org.codenaiten.notapp.application;

import org.codenaiten.notapp.application.api.SignupUseCase;
import org.codenaiten.notapp.application.usecase.SignupUseCaseImpl;
import org.codenaiten.notapp.domain.DomainContext;

public abstract class ApplicationContext extends DomainContext {


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| USECASE |---------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public SignupUseCase signupUseCase(){
        return new SignupUseCaseImpl( this.userService() );
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
