package sk.stuba.fei.uim.oop.assignment3.cart.web.body;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CartResponse {
    private Long id;
    private List<CartItemResponse> shoppingList;
    private Boolean payed;

    public CartResponse(Cart c) {
        this.id = c.getId();
        this.shoppingList = c.getShoppingList().stream().map(CartItemResponse::new).collect(Collectors.toList());
        this.payed = c.getPayed();
    }
}
