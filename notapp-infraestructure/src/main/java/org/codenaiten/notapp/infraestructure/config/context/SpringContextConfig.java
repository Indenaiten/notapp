package org.codenaiten.notapp.infraestructure.config.context;

import jakarta.annotation.PostConstruct;
import org.codenaiten.notapp.application.ApplicationFactory;
import org.codenaiten.notapp.application.api.LoginUseCase;
import org.codenaiten.notapp.application.api.SignupUseCase;
import org.codenaiten.notapp.domain.port.repository.UserRepositoryPort;
import org.codenaiten.notapp.domain.port.service.PassHasherServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringContextConfig extends ApplicationFactory {

    private final ApplicationContext springContext;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\
    @Autowired
    public SpringContextConfig(final ApplicationContext springContext) {
        this.springContext = springContext;
    }


// ------------------------------------------------------------------------------------------------------------------ \\
// ---| USE CASES BEANS |-------------------------------------------------------------------------------------------- \\
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
    public UserRepositoryPort userRepositoryPort() {
        return this.springContext.getBean( UserRepositoryPort.class );
    }

    @Override
    public PassHasherServicePort passHasherServicePort() {
        return this.springContext.getBean( PassHasherServicePort.class );
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
