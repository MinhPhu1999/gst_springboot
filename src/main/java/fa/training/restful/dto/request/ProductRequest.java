package fa.training.restful.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private Integer price;
    @NotNull
    private Integer quantity;

    private String description;
    
	@NotNull
    private Integer manufacturer;

    @NotNull
    private Integer category;

    @NotNull
    private Integer condition;

    private MultipartFile image;

//    public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Integer getPrice() {
//		return price;
//	}
//
//	public void setPrice(Integer price) {
//		this.price = price;
//	}
//
//	public Integer getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(Integer quantity) {
//		this.quantity = quantity;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public Integer getManufacturer() {
//		return manufacturer;
//	}
//
//	public void setManufacturer(Integer manufacturer) {
//		this.manufacturer = manufacturer;
//	}
//
//	public Integer getCategory() {
//		return category;
//	}
//
//	public void setCategory(Integer category) {
//		this.category = category;
//	}
//
//	public Integer getCondition() {
//		return condition;
//	}
//
//	public void setCondition(Integer condition) {
//		this.condition = condition;
//	}
//
//	public MultipartFile getImage() {
//		return image;
//	}
//
//	public void setImage(MultipartFile image) {
//		this.image = image;
//	}
//

}
