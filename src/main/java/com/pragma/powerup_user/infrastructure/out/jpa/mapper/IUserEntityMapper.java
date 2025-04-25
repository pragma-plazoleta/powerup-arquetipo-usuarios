package com.pragma.powerup_user.infrastructure.out.jpa.mapper;

import com.pragma.powerup_user.domain.model.UserModel;
import com.pragma.powerup_user.infrastructure.out.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IUserEntityMapper {

    UserEntity toEntity(UserModel userModel);

    UserModel toModel(UserEntity userEntity);
}
