package com.blogapi.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapi.paylode.UserDto;
import com.blogapi.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	//post create user
	@PostMapping("/create")
	public ResponseEntity<UserDto> createuser(@RequestBody  UserDto userDto)
	{
		UserDto user=userService.createUser(userDto);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	
	//put update user
	@PutMapping("/{userid}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userid") Long uid)
	{
	  UserDto userDto2=this.userService.updateUser(userDto, uid);	
	  return ResponseEntity.ok(userDto2);
	}
	
	//get get user
	@GetMapping("/{userid}")
	public ResponseEntity<UserDto> getbyid(@PathVariable("userid") Long uid)
	{
	   UserDto uDto=this.userService.getUser(uid);
	   return ResponseEntity.ok(uDto);
	}
	
	// deleteS delete user
	@DeleteMapping("/{userid}")
	public ResponseEntity<ResponseApi> delete(@PathVariable("userid") Long uid)
	{
		this.userService.deleteUser(uid);
		return new ResponseEntity(new ResponseApi("deleted successfully",true),HttpStatus.OK);
	}
	//get all users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getall()
	{
		return ResponseEntity.ok(this.userService.getAllUser());
	}
	

}
