package modal;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class Response{
	private List<String> images;
	private int price;
	private String description;
	private String title;
	private int categoryId;

}
