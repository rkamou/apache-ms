package com.apache.service;

import com.apache.model.Item; 

import java.util.List;

public interface ItemService {
    public Item save(Item item);
    public List<Item> getItem();
    public List<Item> getItemByCategory(Integer catId);

    public Item getItemById(Integer id);
    public Item updateItemById(Item item,Integer Id);
    public Item deleteItem(Integer id);

}
