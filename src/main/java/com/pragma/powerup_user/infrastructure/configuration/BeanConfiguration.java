package com.pragma.powerup_user.infrastructure.configuration;

import com.pragma.powerup_user.domain.api.IAuthServicePort;
import com.pragma.powerup_user.domain.api.IUserServicePort;
import com.pragma.powerup_user.domain.spi.IBCryptPort;
import com.pragma.powerup_user.domain.spi.ISecurityPort;
import com.pragma.powerup_user.domain.spi.IUserPersistencePort;
import com.pragma.powerup_user.domain.usecase.AuthUseCase;
import com.pragma.powerup_user.domain.usecase.UserUseCase;
import com.pragma.powerup_user.domain.validate.UserValidate;
import com.pragma.powerup_user.infrastructure.out.jpa.adapter.UserJpaAdapter;
import com.pragma.powerup_user.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.powerup_user.infrastructure.out.jpa.repository.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final UserValidate userValidate;
    private final ISecurityPort securityPort;
    private final IBCryptPort ibCryptPort;

    public BeanConfiguration(IUserRepository userRepository, IUserEntityMapper userEntityMapper, UserValidate userValidate, ISecurityPort securityPort, IBCryptPort ibCryptPort) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
        this.userValidate = userValidate;
        this.securityPort = securityPort;
        this.ibCryptPort = ibCryptPort;
    }

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort(), userValidate, securityPort, ibCryptPort);
    }

    @Bean
    public IAuthServicePort authServicePort () {
        return new AuthUseCase(userPersistencePort(), securityPort);
    }

}