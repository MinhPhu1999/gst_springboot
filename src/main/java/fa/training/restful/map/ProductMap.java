package fa.training.restful.map;


import fa.training.restful.dao.entity.Category;
import fa.training.restful.dao.entity.Manufacturer;
import fa.training.restful.dao.entity.Product;
import fa.training.restful.dto.response.ProductResponse;
import fa.training.restful.repository.CategoryRepository;
import fa.training.restful.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class ProductMap {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ManufacturerRepository manufacturerRepository;

    public ProductResponse mapResult(Product product){

        String imageLink = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/product-images/")
                .path(product.getId().toString())
                .toUriString();

        Category category = categoryRepository.getOne(product.getCategory());
        Manufacturer manufacturer = manufacturerRepository.getOne(product.getManufacturer());

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getProductName())
                .price(product.getUnitPrice())
                .quantity(product.getQuantity())
                .description(product.getDescription())
                .manufacturer(manufacturer.getName())
                .category(category.getName())
                .condition(product.getCondition().toString())
                .image(imageLink)
                .build();
    }
}

