package com.deploy.prakrikum1.mapper;


import com.deploy.prakrikum1.model.dto.UserDto;
import com.deploy.prakrikum1.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    UserDto toUserDtoData(User user);
}
