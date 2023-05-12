package sk.stuba.fei.uim.oop.assignment3.product.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductRequest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Long amount;
    private String unit;
    private Double price;

    public Product(ProductRequest r) {
        this.name = r.getName();
        this.description = r.getDescription();
        this.amount = r.getAmount();
        this.unit = r.getUnit();
        this.price = r.getPrice();
    }
}
