package org.productservices.productservices.productservices;

import org.productservices.productservices.dtos.GenericProductDto;
import org.productservices.productservices.dtos.fakeStoreProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestUrl="https://fakestoreapi.com/products/{id}";
    private String createProductRequestUrl="https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    @Override
    public GenericProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<GenericProductDto>response=restTemplate.postForEntity(createProductRequestUrl,product,GenericProductDto.class);//if 2 variale put both by comma,,
        //response.getStatusCode();
        return response.getBody();
    }
    @Override
//    public Product getProductById(Long id) {
//    public String getProductById(Long id) {
//        //return new Product();
//    public Product getProductById(Long id) {
//        //return new Product();
//        RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<fakeStoreProductDto>response=restTemplate.getForEntity(getProductRequestUrl, fakeStoreProductDto.class ,id);//if 2 variale put both by comma,,
//        //response.getStatusCode();
//        return "here is product id "+id;
//        //return null;
//    }

    public GenericProductDto getProductById(Long id) {
        //return new Product();
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<fakeStoreProductDto>response=restTemplate.getForEntity(getProductRequestUrl, fakeStoreProductDto.class ,id);//if 2 variale put both by comma,,
        //response.getStatusCode();

        fakeStoreProductDto dto=response.getBody();

        GenericProductDto productDto=new GenericProductDto();
        productDto.setImage(dto.getImage());
        productDto.setDescription(dto.getDescription());
        productDto.setTitle(dto.getTitle());
        productDto.setPrice(dto.getPrice());
        //return "here is product id "+id;
        //return null;
        return productDto;
    }

}
