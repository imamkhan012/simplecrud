package com.blogapi.service;

import java.util.List;

import com.blogapi.model.User;
import com.blogapi.paylode.UserDto;



public interface UserService {
	
 	UserDto createUser(UserDto userDto);
 	//UserDto updateUser(UserDto userDto, Integer userid);
 	//UserDto getUser(Integer userid);
    List<UserDto> getAllUser();
    //void deleteUser(Integer userid); 
	UserDto updateUser(UserDto userDto, Long uid);
	UserDto getUser(Long userid);
	void deleteUser(Long userid);

}
