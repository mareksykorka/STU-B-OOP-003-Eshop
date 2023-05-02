package sk.stuba.fei.uim.oop.assignment3.product.web.body;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

@Getter
public class ProductResponse {
    private long id;
    private String name;
    private String description;
    private long amount;
    private String unit;
    private double price;

    public ProductResponse(Product p) {
        this.id = p.getId();
        this.name = p.getName();
        this.description = p.getDescription();
        this.amount = p.getAmount();
        this.unit = p.getUnit();
        this.price = p.getPrice();
    }
}
