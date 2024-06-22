package org.codenaiten.notapp.infraestructure.config.context;

import org.codenaiten.notapp.application.ApplicationFactory;
import org.codenaiten.notapp.application.api.LoginUseCase;
import org.codenaiten.notapp.application.api.SignupUseCase;
import org.codenaiten.notapp.domain.api.UserService;
import org.codenaiten.notapp.domain.port.repository.UserRepositoryPort;
import org.codenaiten.notapp.domain.port.manager.PasswordManagerPort;
import org.codenaiten.notapp.infraestructure.decorator.service.UseServiceDecorator;
import org.codenaiten.notapp.infraestructure.decorator.usecase.LoginUseCaseDecorator;
import org.codenaiten.notapp.infraestructure.decorator.usecase.SignuptUseCaseDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringContextConfig extends ApplicationFactory {

    private final ApplicationContext applicationContext;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\
    @Autowired
    public SpringContextConfig( final ApplicationContext applicationContext ) {
        this.applicationContext = applicationContext;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| USE CASE BEANS |--------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Bean
    @Override
    public SignupUseCase signupUseCase() {
        return new SignuptUseCaseDecorator( super.signupUseCase() );
    }

    @Bean
    @Override
    public LoginUseCase loginUseCase() {
        return new LoginUseCaseDecorator( super.loginUseCase() );
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| SERVICES |--------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public UserService userService() {
        return new UseServiceDecorator( super.userService() );
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public UserRepositoryPort userRepositoryPort() {
        return this.applicationContext.getBean( UserRepositoryPort.class );
    }

    @Override
    public PasswordManagerPort passHasherServicePort() {
        return this.applicationContext.getBean( PasswordManagerPort.class );
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
