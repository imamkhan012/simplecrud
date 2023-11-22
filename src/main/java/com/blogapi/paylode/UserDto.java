package com.blogapi.paylode;




import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	
	
	
	private long id;
	
	
	private String name;
	
	
    private String email;
	private String about;
	private String password;

}
