package sk.stuba.fei.uim.oop.assignment3.cart.web.body;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;

@Getter
public class CartItemResponse {
    private Long productId;
    private Long amount;

    public CartItemResponse(CartItem cItem){
        this.productId = cItem.getProductId();
        this.amount = cItem.getAmount();
    }
}
