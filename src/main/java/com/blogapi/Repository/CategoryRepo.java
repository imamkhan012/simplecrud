package com.blogapi.Repository;

import org.springframework.data.repository.CrudRepository;

import com.blogapi.model.Category;

public interface CategoryRepo extends CrudRepository<Category,Long>{

}
