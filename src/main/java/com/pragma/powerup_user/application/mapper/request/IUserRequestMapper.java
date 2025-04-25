package com.pragma.powerup_user.application.mapper.request;

import com.pragma.powerup_user.application.dto.request.UserRequestDto;
import com.pragma.powerup_user.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {

    UserModel toUser(UserRequestDto userRequestDto);
}
