package com.fernedix.ticketmanagement.auth.mapper;

import com.fernedix.ticketmanagement.auth.dto.RegisterRequest;
import com.fernedix.ticketmanagement.auth.dto.RegisterResponse;
import com.fernedix.ticketmanagement.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "roles", ignore = true)
    User toEntity(RegisterRequest request);

    RegisterResponse toResponse(User user);

}