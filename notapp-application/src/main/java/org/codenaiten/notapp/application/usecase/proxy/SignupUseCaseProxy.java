package org.codenaiten.notapp.application.usecase.proxy;

import org.codenaiten.notapp.application.api.SignupUseCase;
import org.codenaiten.notapp.application.dto.SignupDto;
import org.codenaiten.notapp.application.exception.SignupException;
import org.codenaiten.notapp.application.request.SignupRequest;
import org.codenaiten.notapp.domain.port.persistence.manager.TransactionalManagerPort;

public class SignupUseCaseProxy implements SignupUseCase {

    private final SignupUseCase signupUseCase;
    private final TransactionalManagerPort transactionalManagerPort;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public SignupUseCaseProxy(
            final SignupUseCase signupUseCase,
            final TransactionalManagerPort transactionalManagerPort
    ) {
        this.signupUseCase = signupUseCase;
        this.transactionalManagerPort = transactionalManagerPort;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public SignupDto run( final SignupRequest request ) throws SignupException {
        return this.transactionalManagerPort.run( () -> this.signupUseCase.run( request ) )
                .throwException( SignupException.class )
                .result();
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
