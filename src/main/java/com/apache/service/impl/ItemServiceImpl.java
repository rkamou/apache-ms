package com.apache.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apache.model.Item;
import com.apache.repository.ItemRepository;
import com.apache.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

//    public ArtworkServiceImpl(ArtworkRepository artworkRepository){
//        this.artworkRepository=artworkRepository;
//    }

    @Override
    public Item save(Item artwork) {
        return this.itemRepository.save(artwork);
    }

    @Override
    public List<Item> getItem() {
        return this.itemRepository.findAll();
    }

    @Override
    public List<Item> getItemByCategory(Integer id) {
        return this.itemRepository.findItemByCategory2(id);
    }

    public Item getItemById(Integer  id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Item updateItemById(Item item, Integer id) {

        return itemRepository.findById(id)

                .map(itemToUpdate -> {

                    itemToUpdate.setName(item.getName());

                    itemToUpdate.setDescription(item.getDescription());

                    itemToUpdate.setShippingWeight(item.getShippingWeight());

                    itemToUpdate.setArtiste(item.getArtiste());

                    itemToUpdate.setCategory(item.getCategory());

                    itemToUpdate.setImage1(item.getImage1());
                    itemToUpdate.setImage2(item.getImage2());
                    itemToUpdate.setImage3(item.getImage3());
                    itemToUpdate.setNewPrice(item.getNewPrice());
                    itemToUpdate.setRecommended(item.getRecommended());

                    return itemRepository.save(itemToUpdate);

                }).orElseGet(() -> {

                    return itemRepository.save(item);

                });

    }

    public Item deleteItem(Integer id) {
         itemRepository.deleteById(id);
         return null;
    }
}
