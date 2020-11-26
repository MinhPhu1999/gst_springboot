package fa.training.restful.controllers;

import fa.training.restful.dto.request.ProductRequest;
import fa.training.restful.dto.response.ProductResponse;
import fa.training.restful.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("add")
    public ProductResponse addProduct(
            @ModelAttribute("name") String name,
            @ModelAttribute("price") Integer price,
            @ModelAttribute("quantity") Integer quantity,
            @ModelAttribute("des") String des,
            @ModelAttribute("manu") Integer manu,
            @ModelAttribute("cate") Integer cate,
            @ModelAttribute("condition") Integer condition,
            @Valid @ModelAttribute("image") MultipartFile image
            ) throws FileNotFoundException {

        return productService.addProduct(ProductRequest.builder()
                                        .name(name)
                                        .price(price)
                                        .quantity(quantity)
                                        .description(des)
                                        .manufacturer(manu)
                                        .category(cate)
                                        .condition(condition)
                                        .image(image)
                                        .build());
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@Valid @PathVariable Integer id){
        productService.deleteProductById(id);
    }

    @GetMapping
    public List<ProductResponse> getProductList(){
        return productService.getListProduct();
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@Valid @PathVariable Integer id){
        return productService.getProductDetail(id);
    }

}
