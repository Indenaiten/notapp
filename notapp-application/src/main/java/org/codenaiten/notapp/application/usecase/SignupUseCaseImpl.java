package org.codenaiten.notapp.application.usecase;

import org.codenaiten.notapp.application.api.SignupUseCase;
import org.codenaiten.notapp.application.dto.SignupDto;
import org.codenaiten.notapp.application.exception.SignupException;
import org.codenaiten.notapp.application.request.SignupRequest;
import org.codenaiten.notapp.domain.type.Email;
import org.codenaiten.notapp.domain.type.LastName;
import org.codenaiten.notapp.domain.type.Name;
import org.codenaiten.notapp.domain.entity.User;
import org.codenaiten.notapp.domain.api.UserService;
import org.codenaiten.notapp.domain.exception.CreateUserException;
import org.codenaiten.notapp.domain.type.user.UserName;

public class SignupUseCaseImpl implements SignupUseCase {

    private final UserService userService;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    public SignupUseCaseImpl(final UserService userService) {
        this.userService = userService;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public SignupDto run(final SignupRequest request) throws SignupException {
        if( !UserName.validate( request.getUsername() ) ||
            !Email.validate( request.getEmail() ) ||
            !Name.validate( request.getName() ) ||
            !LastName.validate( request.getLastname() )){
            throw new SignupException( "Data are invalid");
        }

        final UserName username = UserName.of(request.getUsername());
        final Email email = Email.of(request.getEmail());
        final Name name = Name.of(request.getName());
        final LastName lastName = LastName.of(request.getLastname());

        try {
            final User user = this.userService.create(username, email, request.getPassword(), name, lastName );
            return new SignupDto(user);
        } catch (final CreateUserException e) {
            throw new SignupException( e.getMessage() );
        }
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
