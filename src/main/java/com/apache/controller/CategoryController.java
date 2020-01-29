package com.apache.controller;

import com.apache.model.Category; 
import com.apache.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins={"http://localhost:4200","http://localhost","http://localhost:4201"},allowedHeaders = "*")
@RequestMapping(value = "/eartwork/api/categories",produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController( CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping(value="/list")
    public List<Category> getList() {
        return categoryService.getCategories();

    }

    @GetMapping(value="/getById/{categoryId}")
    public Category getArtwork(@PathVariable Integer artworkId){
        return this.categoryService.getCategoryById(artworkId);
    }

    @PostMapping(value="/add")
    public Category addArtwork(@Valid @RequestBody Category category){
        return this.categoryService.save(category);
    }

    @PutMapping(value = "/update/{categoryId}")

    public Category updateBook(@Valid @RequestBody Category editedCategory, @PathVariable Integer categoryId) {

        return categoryService.update(editedCategory, categoryId);

    }
    @DeleteMapping(value = "/delete/{categoryId}")

    public void delete(@PathVariable Integer categoryId) {
        //Delete artwork
        categoryService.delete(categoryId);

    }



}
