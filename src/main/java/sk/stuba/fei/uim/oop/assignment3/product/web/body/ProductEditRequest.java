package sk.stuba.fei.uim.oop.assignment3.product.web.body;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductEditRequest {
    private String name;
    private String description;
}
