package org.codenaiten.notapp.application.usecase.proxy;

import org.codenaiten.notapp.application.api.LoginUseCase;
import org.codenaiten.notapp.application.exception.LoginException;
import org.codenaiten.notapp.application.request.LoginRequest;

public class LoginUseCaseProxy implements LoginUseCase {

    private final LoginUseCase loginUseCase;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public LoginUseCaseProxy( final LoginUseCase loginUseCase ) {
        this.loginUseCase = loginUseCase;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public void run( final LoginRequest request ) throws LoginException {
        this.loginUseCase.run( request );
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
