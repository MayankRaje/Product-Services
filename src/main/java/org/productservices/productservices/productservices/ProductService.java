package org.productservices.productservices.productservices;

import org.productservices.productservices.dtos.GenericProductDto;
import org.productservices.productservices.models.Product;

public interface ProductService {
    GenericProductDto createProduct(GenericProductDto product);

    //Product getProductById(Long id);
    //Product getProductById(Long id);
    GenericProductDto getProductById(Long id);
}
