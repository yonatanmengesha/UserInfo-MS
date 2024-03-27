package com.jotech.userinfo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jotech.userinfo.dto.UserDTO;
import com.jotech.userinfo.entity.User;
import com.jotech.userinfo.mapper.UserMapper;
import com.jotech.userinfo.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;

	public List<UserDTO> findAllUsers() {
		
		List<User>  userList = userRepo.findAll();
		
		List<UserDTO> userDtoList = userList.stream().map(user -> UserMapper.INSTANCE.mapUserToUserDTO(user))
				                                                                     .collect(Collectors.toList());
		
		return userDtoList;
	}

	public UserDTO addUser(UserDTO userDTO) {
		  User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDtoToUser(userDTO));
		  
		return  UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
		  
		
	}

	public ResponseEntity<UserDTO> fetchUserDetailById(Integer userId) {
		Optional<User> fetchedUser = userRepo.findById(userId);
		if(fetchedUser.isPresent()) {
			return new ResponseEntity<>( UserMapper.INSTANCE.mapUserToUserDTO(fetchedUser.get()),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
	}

}
