package com.blogapi.Repository;

import org.springframework.data.repository.CrudRepository;

import com.blogapi.model.Post;

public interface PostRepo extends CrudRepository<Post, Long> {

	
	
}
