package com.pascostudios.realtydemo.model;

import java.util.UUID;

public class Properties {
	
	 private String propertyName, thumbnailUrl;
	 private String address;
	 private String image1,image2,image3,image4;
	 private String description;
	 private double price;
	 private UUID id;
	 private int bedrooms,bathrooms;
	 
	 
	 
	 
	 public Properties(){
	    	
	    	id = UUID.randomUUID();
	    	
	    }
	    
	 
	 
	 
	 
	 
	    
	    public String getDescription() {
		return description;
	}







	public void setDescription(String description) {
		this.description = description;
	}







	public int getBedrooms() {
		return bedrooms;
	}







	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}







	public int getBathrooms() {
		return bathrooms;
	}







	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}







		public Properties(String propertyName, String thumbnailUrl,
			String description, String address, String image1, String image2,
			String image3, String image4, String description1, double price, int bedroom, int bathroom) {
		super();
		this.propertyName = propertyName;
		this.thumbnailUrl = thumbnailUrl;
		this.bedrooms = bedroom;
		this.bathrooms = bathroom;
		this.address = address;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.description = description1;
		this.price = price;
	
	}


		public String getPropertyName() {
		return propertyName;
	}



	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}


	public String getThumbnailUrl() {
		return thumbnailUrl;
	}


	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}






	public String getAddress() {
		return address;
	}






	public void setAddress(String address) {
		this.address = address;
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






	public String getImage4() {
		return image4;
	}






	public void setImage4(String image4) {
		this.image4 = image4;
	}








	public double getPrice() {
		return price;
	}






	public void setPrice(double price) {
		this.price = price;
	}






	public UUID getId() {
		return id;
	}






	public void setId(UUID id) {
		this.id = id;
	}






		
	    
		


		

		

	  

}
