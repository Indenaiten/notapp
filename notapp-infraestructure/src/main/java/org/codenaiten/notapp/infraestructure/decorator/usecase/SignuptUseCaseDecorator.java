package org.codenaiten.notapp.infraestructure.decorator.usecase;

import jakarta.transaction.Transactional;
import org.codenaiten.notapp.application.api.SignupUseCase;
import org.codenaiten.notapp.application.dto.SignupDto;
import org.codenaiten.notapp.application.exception.LoginException;
import org.codenaiten.notapp.application.exception.SignupException;
import org.codenaiten.notapp.application.request.LoginRequest;
import org.codenaiten.notapp.application.request.SignupRequest;

public class SignuptUseCaseDecorator implements SignupUseCase {

    private final SignupUseCase signupUseCase;

    public SignuptUseCaseDecorator(final SignupUseCase signupUseCase) {
        this.signupUseCase = signupUseCase;
    }

    @Transactional( rollbackOn = { SignupException.class })
    @Override
    public SignupDto run( final SignupRequest request ) throws SignupException {
        return this.signupUseCase.run( request );
    }
}
