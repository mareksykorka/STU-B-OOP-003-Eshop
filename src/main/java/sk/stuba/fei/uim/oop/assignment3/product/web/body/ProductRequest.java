package sk.stuba.fei.uim.oop.assignment3.product.web.body;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequest {
    private String name;
    private String description;
    private Long amount;
    private String unit;
    private Double price;
}
