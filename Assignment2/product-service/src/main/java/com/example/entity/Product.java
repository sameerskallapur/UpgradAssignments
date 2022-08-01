package com.example.entity;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
   @Id	
   private String id;
   @NotBlank
   private String name;
   private String bigImage;
   private String thumbNail;
   private String description;
   private String shortDescription;
   private int ratings;
   private float price;
   private boolean isActive;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBigImage() {
	return bigImage;
}
public void setBigImage(String bigImage) {
	this.bigImage = bigImage;
}
public String getThumbNail() {
	return thumbNail;
}
public void setThumbNail(String thumbNail) {
	this.thumbNail = thumbNail;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getShortDescription() {
	return shortDescription;
}
public void setShortDescription(String shortDescription) {
	this.shortDescription = shortDescription;
}
public int getRatings() {
	return ratings;
}
public void setRatings(int ratings) {
	this.ratings = ratings;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}
   
   
   
}
