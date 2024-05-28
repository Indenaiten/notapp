package org.codenaiten.notapp.application.api;

import org.codenaiten.notapp.application.dto.SignupDto;
import org.codenaiten.notapp.application.exception.SignupException;
import org.codenaiten.notapp.application.request.SignupRequest;

public interface SignupUseCase {

    SignupDto run(SignupRequest request) throws SignupException;
}
