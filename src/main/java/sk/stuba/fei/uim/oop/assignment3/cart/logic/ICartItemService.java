package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;

import java.util.List;

public interface ICartItemService {
    CartItem create(Long productId);
    CartItem getCartItemFromCart(List<CartItem> shoppingList, Long productId);
    CartItem save(CartItem cartItem);
}
