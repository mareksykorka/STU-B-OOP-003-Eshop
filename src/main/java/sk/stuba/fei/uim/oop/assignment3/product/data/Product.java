package sk.stuba.fei.uim.oop.assignment3.product.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Long amount;
    private String unit;
    private Double price;

    public Product(ProductRequest r){
        this.name = r.getName();
        this.description = r.getDescription();
        this.amount = r.getAmount();
        this.unit = r.getUnit();
        this.price = r.getPrice();
    }
}
