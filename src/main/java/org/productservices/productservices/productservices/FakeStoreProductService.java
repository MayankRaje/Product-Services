package org.productservices.productservices.productservices;

import org.productservices.productservices.models.Product;
import org.springframework.stereotype.Service;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    @Override
    public Product getProductById(Long id) {
        return new Product();
        //return null;
    }
}
