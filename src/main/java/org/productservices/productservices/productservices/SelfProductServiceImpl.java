package org.productservices.productservices.productservices;

import org.productservices.productservices.models.Product;
import org.springframework.stereotype.Service;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{
    @Override
//    public Product getProductById(Long id) {
    public String getProductById(Long id) {
        return null;
    }
}
