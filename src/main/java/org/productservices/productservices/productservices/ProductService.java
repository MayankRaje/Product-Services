package org.productservices.productservices.productservices;

import org.productservices.productservices.dtos.GenericProductDto;

import java.util.*;

public interface ProductService {
    GenericProductDto createProduct(GenericProductDto product);

    //Product getProductById(Long id);
    //Product getProductById(Long id);
    GenericProductDto getProductById(Long id);
    List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProduct(Long id);
    GenericProductDto updateProduct(GenericProductDto product);

}
