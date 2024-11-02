package org.productservices.productservices.productservices;

import org.productservices.productservices.dtos.fakeStoreProductDto;
import org.productservices.productservices.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestUrl="https://fakestoreapi.com/products/{id}";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    @Override
//    public Product getProductById(Long id) {
    public String getProductById(Long id) {
        //return new Product();
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<fakeStoreProductDto>response=restTemplate.getForEntity(getProductRequestUrl, fakeStoreProductDto.class ,id);//if 2 variale put both by comma,,
        //response.getStatusCode();
        return "here is product id "+id;
        //return null;
    }
}
