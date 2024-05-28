package org.codenaiten.notapp.infraestructure.config.context;

import org.codenaiten.notapp.application.ApplicationContext;
import org.codenaiten.notapp.application.api.SignupUseCase;
import org.codenaiten.notapp.domain.api.UserService;
import org.codenaiten.notapp.domain.port.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfig extends ApplicationContext {

    private final UserRepository userRepository;

// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Autowired
    public ContextConfig(
            final UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Bean
    @Override
    public UserRepository userRepository() {
        return this.userRepository;
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
