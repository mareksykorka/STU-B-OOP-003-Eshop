package sk.stuba.fei.uim.oop.assignment3.cart.web.body;

import lombok.Getter;

@Getter
public class CartAddRequest{
    private Long productId;
    private Long amount;
}
