package fa.training.restful.dao.entity;

import fa.training.restful.constant.ProductCondition;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "product_name")
    private String productName;

    @NotNull
    @Column(name = "unit_price")
    private Integer unitPrice;

    @NotNull
    @Column
    private Integer quantity;

    @Column
    private String description;

    @NotNull
    @Column
    private Integer manufacturer;

    @NotNull
    @Column
    private Integer category;

    @NotNull
    @Column
    private ProductCondition condition;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Integer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public ProductCondition getCondition() {
		return condition;
	}

	public void setCondition(ProductCondition condition) {
		this.condition = condition;
	}
}

