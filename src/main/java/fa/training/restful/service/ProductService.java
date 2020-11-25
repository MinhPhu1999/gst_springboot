package fa.training.restful.service;


import fa.training.restful.constant.ProductCondition;
import fa.training.restful.dao.entity.Product;
import fa.training.restful.dto.request.ProductRequest;
import fa.training.restful.dto.response.ProductResponse;
import fa.training.restful.map.ProductMap;
import fa.training.restful.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductImageService productImageService;

    @Autowired
    ProductMap productMap;

    public ProductResponse addProduct(ProductRequest request) throws FileNotFoundException {
        String imageName = StringUtils.cleanPath(request.getImage().getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (imageName.contains("..")) {
                throw new FileNotFoundException();
            }

            Product newProduct = productRepository.save(Product.builder()
                                                    .id(request.getId())
                                                    .productName(request.getName())
                                                    .unitPrice(request.getPrice())
                                                    .quantity(request.getQuantity())
                                                    .description(request.getDescription())
                                                    .manufacturer(request.getManufacturer())
                                                    .category(request.getCategory())
                                                    .condition(ProductCondition.fromInteger(request.getCondition()))
                                                    .build());

            productImageService.storeImage(request.getImage(), newProduct.getId());

            return productMap.mapResult(newProduct);
        } catch (IOException ex) {
            throw new FileNotFoundException();
        }
    }

    public List<ProductResponse> getListProduct(){
        try {
            List<Product> productList = productRepository.findAll();

            List<ProductResponse> responses = new ArrayList<>();
            productList.forEach(item -> {
                responses.add(productMap.mapResult(item));
            });
            return responses;
        }catch (Exception e){
            return new ArrayList<>();
        }
    }

    @Transactional
    public ProductResponse getProductDetail(Integer id){
        try {
            return productMap.mapResult(productRepository.getOne(id));
        }catch (Exception e){
            return null;
        }
    }

    @Transactional
    public void deleteProductById(Integer id){
        try {
            productImageService.deleteProductImage(id);
            productRepository.deleteById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
