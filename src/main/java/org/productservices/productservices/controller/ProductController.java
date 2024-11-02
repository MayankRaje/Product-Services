package org.productservices.productservices.controller;

import org.productservices.productservices.dtos.GenericProductDto;
import org.productservices.productservices.models.Product;
import org.productservices.productservices.productservices.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/products")
@RequestMapping("api/v1/products")
public class ProductController {
//  @Autowired //DI via field
    private ProductService productService;
    //DI via constructor //best one
    public ProductController (@Qualifier("fakeStoreProductService") ProductService productService) {//spring will create object of this ProductController (IOC)
        this.productService = productService;
    }

//    @Autowired
//    public void setProductService(ProductService productService) {//DI via setter
//        this.productService = productService;
//    }
//    @GetMapping("/products") //removed due to request mapping
      @GetMapping
    public List<GenericProductDto> getAllProducts() {
//        return List.of(new GenericProductDto(),
//                       new GenericProductDto());
          return productService.getAllProducts();
    }
   // http://localhost:8080/products/123?=456
//    @GetMapping("/products/{id}")
      @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
        //return "here is product id "+id;
    }
//    @DeleteMapping("/products/{id}")
    //M==>1
//      @DeleteMapping("{id}")
//    public GenericProductDto deleteProductById(@PathVariable("id") Long id) {
//        return productService.deleteProduct(id);
//    }
    //M==>2
    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) {
        ResponseEntity<GenericProductDto> response= new ResponseEntity<>(
                productService.deleteProduct(id),
                HttpStatus.OK
        );
        return response;
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        //return "created new product item with name :"+ product.getTitle();
        return productService.createProduct(product);
    }
    @PutMapping("{}")
    public GenericProductDto updateProductsById(@RequestBody GenericProductDto product){
        return productService.createProduct(product);
    }

}
