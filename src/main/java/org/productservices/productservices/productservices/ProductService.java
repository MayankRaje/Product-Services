package org.productservices.productservices.productservices;

import org.productservices.productservices.dtos.GenericProductDto;
import org.productservices.productservices.exceptions.NotFoundException;

import java.util.*;

public interface ProductService {
    GenericProductDto createProduct(GenericProductDto product);

    //Product getProductById(Long id);
    //Product getProductById(Long id);
    GenericProductDto getProductById(Long id) throws NotFoundException;
    List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProduct(Long id);
    GenericProductDto updateProduct(GenericProductDto product);

}
