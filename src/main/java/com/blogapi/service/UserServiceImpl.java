package com.blogapi.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapi.Repository.UserRepo;
import com.blogapi.model.User;
import com.blogapi.paylode.UserDto;
import com.blogapi.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	
	

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	
	private ModelMapper mapper;
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.dtotoUser(userDto);
		User saveduser= this.userRepo.save(user);
		return this.usertoDto(saveduser);
		
		
		
	}
	@Override
	public UserDto updateUser(UserDto userDto,Long userid) {
		User user=this.userRepo.findById(userid).orElseThrow(() -> new ResourceNotFoundException("user", "id", userid));
	
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
	User saveuser=this.userRepo.save(user);
		return this.usertoDto(saveuser);
	}
	@Override
	public UserDto getUser(Long userid) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userid).orElseThrow(() -> new ResourceNotFoundException("user", "id", userid));
		return this.usertoDto(user);
	   
	
	
	}
	@Override
	public List<UserDto> getAllUser() {
		List<User> user=(List<User>) this.userRepo.findAll();
		
		List<UserDto> user1=user.stream().map(users -> this.usertoDto(users) ).collect(Collectors.toList());
		return user1;
	}
	@Override
	public void deleteUser(Long userid) {
		User user=this.userRepo.findById(userid).orElseThrow(() -> new ResourceNotFoundException("user", "id", userid));
	     this.userRepo.deleteById(userid);
	     
	}
	private User dtotoUser(UserDto userDto)
	{
	   User user = mapper.map(userDto, User.class);
	   //user.setId(userDto.getId());
	   //user.setName(userDto.getName());
	  // user.setEmail(userDto.getEmail());
	  // user.setAbout(userDto.getAbout());
	  // user.setPassword(userDto.getPassword());
	   return user;
	   
	}
	private UserDto usertoDto(User user)
	{
		UserDto userDto = mapper.map(user,UserDto.class );
		//userDto.setId(user.getId());
		//userDto.setName(user.getName());
		//userDto.setEmail(user.getEmail());
		//userDto.setAbout(user.getAbout());
		//userDto.setPassword(user.getPassword());
		return userDto;
	}

	
}
