package com.cafe24.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.lms.domain.Category;
import com.cafe24.lms.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    public boolean saveCategory(Category category){
	return (categoryRepository.save(category) != null);
    }
    
    public List<Category> getCategoryList() {
	return categoryRepository.findAll();
    }
    
    public Category getCategory(Long no){
	return categoryRepository.findOne(no);
    }
    
    public void remove(){
	categoryRepository.deleteAll();
    }
}
