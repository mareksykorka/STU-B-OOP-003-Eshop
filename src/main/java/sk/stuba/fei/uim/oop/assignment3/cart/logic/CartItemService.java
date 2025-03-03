package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartItemRepository;

import java.util.List;

@Service
public class CartItemService implements ICartItemService {
    @Autowired
    private ICartItemRepository cartItemRepository;

    @Override
    public CartItem create(Long productId) {
        CartItem cartItem = new CartItem();
        cartItem.setProductId(productId);
        return this.save(cartItem);
    }

    @Override
    public CartItem getCartItemFromCart(List<CartItem> shoppingList, Long productId) {
        for (CartItem cartItem : shoppingList) {
            if (cartItem.getProductId().equals(productId)) {
                return cartItem;
            }
        }
        return null;
    }

    @Override
    public CartItem save(CartItem cartItem) {
        this.cartItemRepository.save(cartItem);
        return cartItem;
    }
}
