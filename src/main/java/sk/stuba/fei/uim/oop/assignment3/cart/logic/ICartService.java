package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.web.body.CartAddRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

public interface ICartService {
    Cart create();

    Cart getCartById(Long id) throws NotFoundException;

    void deleteCartById(Long id) throws NotFoundException;

    Cart addItemToCartById(Long id, CartAddRequest request) throws NotFoundException, IllegalOperationException;
}
