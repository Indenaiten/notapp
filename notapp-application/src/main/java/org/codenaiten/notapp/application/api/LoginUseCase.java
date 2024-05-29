package org.codenaiten.notapp.application.api;

import org.codenaiten.notapp.application.dto.SignupDto;
import org.codenaiten.notapp.application.exception.LoginException;
import org.codenaiten.notapp.application.exception.SignupException;
import org.codenaiten.notapp.application.request.LoginRequest;
import org.codenaiten.notapp.application.request.SignupRequest;

public interface LoginUseCase {

    void run(LoginRequest request) throws LoginException;
}
