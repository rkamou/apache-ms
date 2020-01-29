package com.apache.service.impl;
 
import com.apache.model.Category;
import com.apache.repository.CategoryRepository;
import com.apache.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

//    public CategoryImpl(CategoryRepository categoryRepository){
//        this.categoryRepository=categoryRepository;
//    }

    @Override
    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return this.categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category update(Category category, Integer categoryId) {
            return categoryRepository.findById(categoryId)

                    .map(categoryToUpdate -> {

                        categoryToUpdate.setName(category.getName());

                        categoryToUpdate.setDescription(category.getDescription());

                        return categoryRepository.save(categoryToUpdate);

                    }).orElseGet(() -> {

                        return categoryRepository.save(category);

                    });


    }

    @Override
    public Category delete(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
        return null;
    }
}
