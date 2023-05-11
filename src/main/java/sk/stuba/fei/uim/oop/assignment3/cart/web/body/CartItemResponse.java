package sk.stuba.fei.uim.oop.assignment3.cart.web.body;

import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;

public class CartItemResponse {
    private Long productId;
    private Long amount;

    public CartItemResponse(CartItem cItem){
        this.productId = cItem.getProductId();
        this.amount = cItem.getAmount();
    }
}
