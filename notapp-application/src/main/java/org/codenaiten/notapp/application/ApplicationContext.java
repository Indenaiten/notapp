package org.codenaiten.notapp.application;

import org.codenaiten.notapp.application.api.SignupUseCase;
import org.codenaiten.notapp.application.usecase.SignupUseCaseImpl;
import org.codenaiten.notapp.domain.DomainContext;
import org.codenaiten.notapp.domain.api.UserService;
import org.codenaiten.notapp.domain.port.UserRepository;
import org.codenaiten.notapp.domain.service.UserServiceImpl;

public abstract class ApplicationContext extends DomainContext {


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| USECASE |---------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public SignupUseCase signupUseCase(){
        return new SignupUseCaseImpl( this.userService() );
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
