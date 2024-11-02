package org.productservices.productservices.controller;

import org.productservices.productservices.dtos.GenericProductDto;
import org.productservices.productservices.models.Product;
import org.productservices.productservices.productservices.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
    public void getAllProducts() {

    }
   // http://localhost:8080/products/123?=456
//    @GetMapping("/products/{id}")
      @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
        //return "here is product id "+id;
    }
//    @DeleteMapping("/products/{id}")
      @DeleteMapping("{id}")
    public void deleteProductById(String name) {

    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        //return "created new product item with name :"+ product.getTitle();
        return productService.createProduct(product);
    }
    @PutMapping("{}")
    public void updateProductsById(){

    }
}
