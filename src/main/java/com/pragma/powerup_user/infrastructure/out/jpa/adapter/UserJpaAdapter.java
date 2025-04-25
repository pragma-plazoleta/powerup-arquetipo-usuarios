package com.pragma.powerup_user.infrastructure.out.jpa.adapter;

import com.pragma.powerup_user.domain.model.UserModel;
import com.pragma.powerup_user.domain.spi.IUserPersistencePort;
import com.pragma.powerup_user.infrastructure.out.jpa.entity.UserEntity;
import com.pragma.powerup_user.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.powerup_user.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    public UserJpaAdapter(IUserRepository userRepository, IUserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public UserModel saveOwner(UserModel userModel) {
        UserEntity userEntity = userRepository.save(userEntityMapper.toEntity(userModel));
        return userEntityMapper.toModel(userEntity);
    }

    @Override
    public UserModel findByCorreo(String userName) {
        return userEntityMapper.toModel(userRepository.findByCorreo(userName));
    }
}
