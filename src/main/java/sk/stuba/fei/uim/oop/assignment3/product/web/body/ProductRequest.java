package sk.stuba.fei.uim.oop.assignment3.product.web.body;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private Long amount;
    private String unit;
    private Double price;
}
