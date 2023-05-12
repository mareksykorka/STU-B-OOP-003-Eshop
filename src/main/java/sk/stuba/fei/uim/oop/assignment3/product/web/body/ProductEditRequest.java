package sk.stuba.fei.uim.oop.assignment3.product.web.body;

import lombok.Data;

@Data
public class ProductEditRequest {
    private String name;
    private String description;
}
