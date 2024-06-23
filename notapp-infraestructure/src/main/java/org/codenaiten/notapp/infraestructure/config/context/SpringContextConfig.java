package org.codenaiten.notapp.infraestructure.config.context;

import org.codenaiten.notapp.application.ApplicationFactory;
import org.codenaiten.notapp.application.api.LoginUseCase;
import org.codenaiten.notapp.application.api.SignupUseCase;
import org.codenaiten.notapp.domain.port.manager.PasswordManagerPort;
import org.codenaiten.notapp.domain.port.persistence.manager.TransactionalManagerPort;
import org.codenaiten.notapp.domain.port.persistence.repository.UserRepositoryPort;
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
        return super.signupUseCase();
    }

    @Bean
    @Override
    public LoginUseCase loginUseCase() {
        return super.loginUseCase();
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public TransactionalManagerPort transactionalManagerPort() {
        return this.applicationContext.getBean( TransactionalManagerPort.class );
    }

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
