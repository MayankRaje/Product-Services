package org.productservices.productservices.productservices;

import org.productservices.productservices.dtos.GenericProductDto;
import org.productservices.productservices.dtos.fakeStoreProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestUrl="https://fakestoreapi.com/products/{id}";
    private String createProductRequestUrl="https://fakestoreapi.com/products";
    private String postProductRequestUrl="https://fakestoreapi.com/products";
    private String specificProductRequestUrl="https://fakestoreapi.com/products/{id}";


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

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<fakeStoreProductDto>response=restTemplate.getForEntity(postProductRequestUrl, List<fakeStoreProductDto>.class);//if 2 variale put both by comma,,
        //response.getStatusCode();//compile error

        ResponseEntity<fakeStoreProductDto[]>response=restTemplate.getForEntity(postProductRequestUrl, fakeStoreProductDto[].class);//if 2 variale put both by comma,,
        //response.getStatusCode();//compile error

        List<GenericProductDto> answer=new ArrayList<>();
        System.out.println(answer.getClass().getName());//print externally


//        for(fakeStoreProductDto dto:response.getBody()){ //compile error
//            GenericProductDto product=new GenericProductDto();
//            product.setImage(dto.getImage());
//            product.setDescription(dto.getDescription());
//            product.setTitle(dto.getTitle());
//            product.setPrice(dto.getPrice());
//            product.setPrice(dto.getPrice());
//        }
       // return List.of();

        for(fakeStoreProductDto dto:response.getBody()){ //compile error
            GenericProductDto product=new GenericProductDto();
            product.setImage(dto.getImage());
            product.setDescription(dto.getDescription());
            product.setTitle(dto.getTitle());
            product.setPrice(dto.getPrice());
            product.setCategory(dto.getCategory());

            answer.add(product);
        }
             return answer;

    }

//    @Override //==> M==>1
//    public GenericProductDto deleteProduct(Long id) {
//        RestTemplate restTemplate =restTemplateBuilder.build();
//
//        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(fakeStoreProductDto.class);
//        ResponseExtractor<ResponseEntity<fakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(fakeStoreProductDto.class);
//        ResponseEntity<fakeStoreProductDto> response= restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor,id);
//
//        fakeStoreProductDto dto=response.getBody();
//
//        GenericProductDto productDto=new GenericProductDto();
//        productDto.setImage(dto.getImage());
//        productDto.setDescription(dto.getDescription());
//        productDto.setTitle(dto.getTitle());
//        productDto.setPrice(dto.getPrice());
//        //return "here is product id "+id;
//        //return null;
//        return productDto;
//
//        //return response.getBody();
//    }

    private GenericProductDto convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto fakeStoreProductDto) {

        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        return product;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        RestTemplate restTemplate =restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(fakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<fakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(fakeStoreProductDto.class);
        ResponseEntity<fakeStoreProductDto> response= restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor,id);

        fakeStoreProductDto dto=response.getBody();
        return convertFakeStoreProductIntoGenericProduct(dto);
    }
    @Override
    public GenericProductDto updateProduct(GenericProductDto product) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<GenericProductDto>response=restTemplate.postForEntity(createProductRequestUrl,product,GenericProductDto.class);//if 2 variale put both by comma,,
        //response.getStatusCode();
        return response.getBody();
        //return null;
    }

}
