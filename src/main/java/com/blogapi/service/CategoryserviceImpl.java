package com.blogapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapi.Repository.CategoryRepo;
import com.blogapi.Repository.UserRepo;
import com.blogapi.exception.ResourceNotFoundException;
import com.blogapi.model.Category;
import com.blogapi.paylode.CategoryDto;

@Service
public class CategoryserviceImpl implements CategoryService {
	
	
	@Autowired
	CategoryRepo categoryRepo;
	@Autowired
	ModelMapper mapper;

	@Override
	public CategoryDto creatapi(CategoryDto categoryDto) {
		
		Category category=this.CategryDtotoCategory(categoryDto);
		Category category2=categoryRepo.save(category);
		return this.categorytoDto(category2);
	}

	@Override
	public CategoryDto updateapi(CategoryDto categoryDto, Long ctgryid) {
		 Category category=this.categoryRepo.findById(ctgryid)
				 
			.orElseThrow(() -> new ResourceNotFoundException("user", "id", ctgryid));
		     category.setId(categoryDto.getId());
		    
		     category.setDescription(categoryDto.getTitle());
		     category.setDescription(categoryDto.getDescription());
		     
		    Category category2=this.categoryRepo.save(category);
		   return this.categorytoDto(category2);
		     
		     
		
	}

	@Override
	public CategoryDto getapi(Long ctgryid) {
		 Category category=this.categoryRepo.findById(ctgryid).orElseThrow(() -> new ResourceNotFoundException("user", "id", ctgryid));
		return this.categorytoDto(category);
	}

	@Override
	public List<CategoryDto> getcategory() {
	    List<Category>categories=(List<Category>) this.categoryRepo.findAll();
	   List<CategoryDto> ctgCategories= categories.stream().map(ctgry -> this.categorytoDto(ctgry) ).collect(Collectors.toList());
		return ctgCategories;
	}

	@Override
	public void deletectgry(Long ctgry) {
	    
		Category category=this.categoryRepo.findById(ctgry).orElseThrow(() -> new ResourceNotFoundException("user", "id", ctgry));
		this.categoryRepo.delete(category);
	}
	
	private Category CategryDtotoCategory(CategoryDto categoryDto)
	{
		Category ctCategory=mapper.map(categoryDto, Category.class);
		return ctCategory;
	}
	private CategoryDto categorytoDto(Category category)
	{
		CategoryDto categoryDto=mapper.map(category, CategoryDto.class);
		return categoryDto;
		
	}

}
