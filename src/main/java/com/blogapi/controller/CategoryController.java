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

import com.blogapi.paylode.CategoryDto;

import com.blogapi.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	
	CategoryService categoryService;
	
	
	@PostMapping("/")
	private ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto)
	{
		//create
		
		 CategoryDto categoryDto2=this.categoryService.creatapi(categoryDto);
		 return new ResponseEntity<CategoryDto>(categoryDto2, HttpStatus.CREATED);
	}
		//update
		 @PutMapping("/{uid}")
		 private ResponseEntity<CategoryDto> update(@RequestBody CategoryDto categoryDto, @PathVariable Long uid)
			{
			     CategoryDto categoryDto2=this.categoryService.updateapi(categoryDto, uid );
				 return new ResponseEntity<CategoryDto>(categoryDto2, HttpStatus.OK);
			}
		 
		//get
		 @GetMapping("/{uid}")
		 private ResponseEntity<CategoryDto> getbyid(@PathVariable Long uid)
		 {
			 CategoryDto categoryDto=this.categoryService.getapi(uid);
			 return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.FOUND);
		 }
		//getAll
		 @GetMapping("/")
			public ResponseEntity<List<CategoryDto>> getall()
			{
				return ResponseEntity.ok(this.categoryService.getcategory());
			}
		 
		//delete
		 @DeleteMapping("/{uid}")
		 private ResponseEntity<ResponseApi> delete(@PathVariable Long uid)
		 {
			 this.categoryService.deletectgry(uid);
			 return new ResponseEntity<ResponseApi>(new ResponseApi("api successfully deleted",true),HttpStatus.OK);
		 }
		
	

}
