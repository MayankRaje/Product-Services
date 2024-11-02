package org.productservices.productservices.productservices;

import org.productservices.productservices.models.Product;

public interface ProductService {
    Product getProductById(Long id);
}
