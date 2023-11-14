package com.qa.gorest.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(Include.NON_NULL)
public class Products {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("price")
	private int price;
	
	@JsonProperty("category")
	private String category;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("image")
	private String image;
	
	
	public Products(String title, int price, String category, String description, String image) {
		this.title = title;
		this.price = price;
		this.category = category;
		this.description = description;
		this.image = image;
	}
    
    

}
