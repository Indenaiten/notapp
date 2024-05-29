package org.codenaiten.notapp.infraestructure.config.context;

import org.codenaiten.notapp.application.ApplicationContext;
import org.codenaiten.notapp.application.api.SignupUseCase;
import org.codenaiten.notapp.domain.api.UserService;
import org.codenaiten.notapp.domain.port.repository.UserRepositoryPort;
import org.codenaiten.notapp.domain.port.service.PassHasherServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfraestructureContext extends ApplicationContext {

    private final UserRepositoryPort userRepositoryPort;
    private final PassHasherServicePort passHasherServicePort;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Autowired
    public InfraestructureContext(
            final UserRepositoryPort userRepositoryPort,
            final PassHasherServicePort passHasherServicePort
    ) {
        this.userRepositoryPort = userRepositoryPort;
        this.passHasherServicePort = passHasherServicePort;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public UserRepositoryPort userRepositoryPort() {
        return this.userRepositoryPort;
    }

    @Override
    public PassHasherServicePort passHasherServicePort() {
        return this.passHasherServicePort;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| SERVICE |---------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Bean
    @Override
    public UserService userService() {
        return super.userService();
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| USE CASE |--------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Bean
    @Override
    public SignupUseCase signupUseCase() {
        return super.signupUseCase();
    }


// ------------------------------------------------------------------------------------------------------------------ \\

}
