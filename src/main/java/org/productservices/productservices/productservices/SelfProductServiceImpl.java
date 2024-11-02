package org.productservices.productservices.productservices;

import org.productservices.productservices.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{
    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
//    public Product getProductById(Long id) {
//    public String getProductById(Long id) {
//        return null;
//    }

    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return List.of();
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }
    public GenericProductDto updateProduct(GenericProductDto product) {
        return null;
    }
}
