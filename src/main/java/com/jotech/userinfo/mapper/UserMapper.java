package com.jotech.userinfo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jotech.userinfo.dto.UserDTO;
import com.jotech.userinfo.entity.User;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	User mapUserDtoToUser(UserDTO userDTO);
	UserDTO mapUserToUserDTO(User user);
}
