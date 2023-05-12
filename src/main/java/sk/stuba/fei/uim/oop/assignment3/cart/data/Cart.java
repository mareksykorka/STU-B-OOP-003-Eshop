package sk.stuba.fei.uim.oop.assignment3.cart.data;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(orphanRemoval = true)
    private List<CartItem> shoppingList;
    private Boolean payed;

    public Cart() {
        this.shoppingList = new ArrayList<CartItem>();
        this.payed = false;
    }
}
