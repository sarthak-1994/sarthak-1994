package modal;

import lombok.Data;
import lombok.Getter;

import java.util.List;

public class Product {
	private List<String> images;
	private int price;
	private String description;
	private String title;
	private int categoryId;

	public void setImages(List<String> images){
		this.images = images;
	}

    public void setPrice(int price){
		this.price = price;
	}

    public void setDescription(String description){
		this.description = description;
	}

    public void setTitle(String title){
		this.title = title;
	}

    public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}

}
