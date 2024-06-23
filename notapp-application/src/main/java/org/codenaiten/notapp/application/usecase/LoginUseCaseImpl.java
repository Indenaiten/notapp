package org.codenaiten.notapp.application.usecase;

import org.codenaiten.notapp.application.api.LoginUseCase;
import org.codenaiten.notapp.application.exception.LoginException;
import org.codenaiten.notapp.application.request.LoginRequest;
import org.codenaiten.notapp.domain.entity.User;
import org.codenaiten.notapp.domain.port.persistence.repository.UserRepositoryPort;
import org.codenaiten.notapp.domain.port.manager.PasswordManagerPort;
import org.codenaiten.notapp.domain.vo.Email;
import org.codenaiten.notapp.domain.vo.user.UserName;

import java.util.Optional;

public class LoginUseCaseImpl implements LoginUseCase {

    public static final String MSG_ERROR_CREDENTIALS_INVALID = "Credentials are invalid";

// ------------------------------------------------------------------------------------------------------------------ \\

    private final PasswordManagerPort passwordManagerPort;
    private final UserRepositoryPort userRepositoryPort;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public LoginUseCaseImpl(
            final UserRepositoryPort userRepositoryPort,
            final PasswordManagerPort passwordManagerPort
    ) {
        this.userRepositoryPort = userRepositoryPort;
        this.passwordManagerPort = passwordManagerPort;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public void run(final LoginRequest request) throws LoginException {
        final String login = request.getLogin();

        Optional<User> optionalUser = Optional.empty();
        if( UserName.validate( login )){
            optionalUser = this.userRepositoryPort.find( UserName.of( login ));
        }
        else if( Email.validate( login )){
            optionalUser = this.userRepositoryPort.find( Email.of( login ));
        }

        final User user = optionalUser.orElseThrow(() -> new LoginException( MSG_ERROR_CREDENTIALS_INVALID ));
        final String password = this.passwordManagerPort.hash(request.getPassword(), user.getSalt());
        if( !password.equals( user.getPassword() )) {
            throw new LoginException( MSG_ERROR_CREDENTIALS_INVALID );
        }
    }


// ------------------------------------------------------------------------------------------------------------------ \\

}
