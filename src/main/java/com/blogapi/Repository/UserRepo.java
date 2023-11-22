package com.blogapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.blogapi.model.User;

public interface UserRepo extends CrudRepository<User, Long> {

}
