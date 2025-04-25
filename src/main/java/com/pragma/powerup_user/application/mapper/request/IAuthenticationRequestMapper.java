package com.pragma.powerup_user.application.mapper.request;

import com.pragma.powerup_user.application.dto.request.AuthenticationRequestDto;
import com.pragma.powerup_user.application.dto.response.AuthenticationResponseDto;
import com.pragma.powerup_user.domain.model.AuthenticationTokenModel;
import com.pragma.powerup_user.domain.model.AuthenticationUserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.http.ResponseEntity;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IAuthenticationRequestMapper {

    AuthenticationUserModel toModel (AuthenticationRequestDto authenticationRequestDto);

    AuthenticationResponseDto toDto (AuthenticationTokenModel authenticationTokenModel);

}
