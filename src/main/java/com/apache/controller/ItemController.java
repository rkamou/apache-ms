package com.apache.controller;
 
import com.apache.model.Category;
import com.apache.model.Item;
import com.apache.service.ItemService;
import com.apache.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid; 
import java.util.List;


@RestController
@CrossOrigin(origins={"http://localhost:4200","http://localhost","http://localhost:4201","http://localhost:4203,"},allowedHeaders = "*")
@RequestMapping(value = "/apache/api/items",produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {

    @Autowired
    private ItemService itemService;

    @SuppressWarnings("unused")
	@Autowired
    private CategoryService categoryService;

    public ItemController(ItemService service, CategoryService categoryService){
        itemService=service;
        this.categoryService=categoryService;
    }

    @GetMapping(value="/list")
    public List<Item> getListItems() {
        return itemService.getItem();

    }

    @GetMapping(value="/getById/{artworkId}")
    public Item getItem(@PathVariable Integer id){
        return this.itemService.getItemById(id);
    }

    @GetMapping(value="/getByCategory/{categoryId}")
    public List<Item> getArtworkByCategory2(@PathVariable Integer categoryId){
        Category cat=new Category();
        cat.setCategoryId(categoryId);
        return this.itemService.getItemByCategory(categoryId);
       // return "good";
    }

    @PostMapping(value="/add")
    public Item addItem(@Valid @RequestBody Item item){
        return this.itemService.save(item);
    }

    @PutMapping(value = "/update/{id}")
    public Item updateBook(@Valid @RequestBody Item editedItem, @PathVariable Integer id) {
        return itemService.updateItemById(editedItem, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteArtwork(@PathVariable Integer id) { 
        itemService.deleteItem(id);
    }

}
