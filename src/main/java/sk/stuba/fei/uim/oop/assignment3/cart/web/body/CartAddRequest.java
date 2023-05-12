package sk.stuba.fei.uim.oop.assignment3.cart.web.body;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartAddRequest{
    private Long productId;
    private Long amount;
}
