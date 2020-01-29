package com.apache.repository;
 
import com.apache.model.Category;
import com.apache.model.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query("select i from Item i where i.category.categoryId = ?1")
    public List<Item> findItemByCategory2(Integer id);

   // @Query("select art from artworks art")
    //public List<Artwork> getAllArtworks();

    Optional<List<Item>> findItemByCategory(Category category);

}
