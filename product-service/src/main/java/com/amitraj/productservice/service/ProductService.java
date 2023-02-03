package com.amitraj.productservice.service;

import com.amitraj.productservice.dto.ProductRequest;
import com.amitraj.productservice.dto.ProductResponse;
import com.amitraj.productservice.model.Product;
import com.amitraj.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;



    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder().name(productRequest.getName())
                                            .price(productRequest.getPrice())
                .description(productRequest.getDescription()).build();

        productRepository.save(product);

        log.info("Product {} is saved",product.getId());
    }



    public List<ProductResponse> getAllProduct() {
        List<Product> products=productRepository.findAll();
          return products.stream().map(product -> mapToProductResponse(product)).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId()).name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }


}
