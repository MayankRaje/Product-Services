package org.productservices.productservices.dtos;

import lombok.Getter;
import lombok.Setter;
import org.productservices.productservices.models.Category;
@Setter
public class fakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

}
