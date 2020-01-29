package com.apache.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="items")
public class Item {

    public Item(){}

//    public Artwork(String name, String description, String artiste, double shippingWeight, double amount, Category category) {
//        this.name = name;
//        this.description = description;
//        this.artiste = artiste;
//        this.shippingWeight = shippingWeight;
//        this.amount = amount;
//        this.category = category;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer artworkId;

    @Column(nullable = false)
    private String name;

    private String description;
    private String artiste;
    private double shippingWeight;

    @Column(nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private Category category;

    private String image1;
    private String image2;
    private String image3;
    private double newPrice;
    private Integer recommended;

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Images> ImagesList;

    public Integer getArtworkId() {
        return artworkId;
    }

    public void setArtworkId(Integer artworkId) {
        this.artworkId = artworkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public double getShippingWeight() {
        return shippingWeight;
    }

    public void setShippingWeight(double shippingWeight) {
        this.shippingWeight = shippingWeight;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public Integer getRecommended() {
        return recommended;
    }

    public void setRecommended(Integer recommended) {
        this.recommended = recommended;
    }

    

    public List<Images> getImagesList() {
		return ImagesList;
	}

	public void setImagesList(List<Images> imagesList) {
		ImagesList = imagesList;
	}

	@Override
    public String toString() {
        return "Artwork{" +
                "artworkId=" + artworkId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", artiste='" + artiste + '\'' +
                ", shippingWeight=" + shippingWeight +
                ", amount=" + amount +
                ", category=" + category +
                ", image1='" + image1 + '\'' +
                ", image2='" + image2 + '\'' +
                ", image3='" + image3 + '\'' +
                ", newPrice=" + newPrice +
                ", recommended=" + recommended +
                '}';
    }
}
