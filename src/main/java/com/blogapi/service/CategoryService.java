package com.blogapi.service;

import java.util.List;

import org.springframework.web.context.support.ServletContextAttributeExporter;

import com.blogapi.paylode.CategoryDto;

public interface CategoryService {

	
	CategoryDto creatapi(CategoryDto categoryDto);
	CategoryDto updateapi(CategoryDto categoryDto,Long ctgryid);
	CategoryDto getapi(Long ctgryid);
	
	List<CategoryDto> getcategory();
	void deletectgry(Long ctgry );
	
}
