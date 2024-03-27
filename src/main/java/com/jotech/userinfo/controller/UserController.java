package com.jotech.userinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jotech.userinfo.dto.UserDTO;
import com.jotech.userinfo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
		
		       UserDTO  savedUser =     userService.addUser(userDTO);
		       
		  return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}
	@GetMapping("/fetchAllUsers")
	public ResponseEntity<List<UserDTO>>  fetchAllUsers(){
		
		List<UserDTO>  users = userService.findAllUsers();
		
		
		return new ResponseEntity<>(users,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/fetchUserById/{userId}")
	public ResponseEntity<UserDTO> fetchUserDetailById(@PathVariable Integer userId){
				
		return userService.fetchUserDetailById(userId);
		
	}

}
