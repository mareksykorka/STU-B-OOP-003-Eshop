package sk.stuba.fei.uim.oop.assignment3.product.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Long amount;
    private String unit;
    private Double price;

    public Product(ProductRequest p) {
        this.name = p.getName();
        this.description = p.getDescription();
        this.amount = p.getAmount();
        this.unit = p.getUnit();
        this.price = p.getPrice();
    }
}
