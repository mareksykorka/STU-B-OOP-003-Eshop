package sk.stuba.fei.uim.oop.assignment3.cart.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class ShoppingCart{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<ShoppingCartItem> shoppingList;
    private boolean payed;

}
