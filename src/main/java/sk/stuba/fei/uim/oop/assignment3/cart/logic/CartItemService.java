package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartItemRepository;

@Service
public class CartItemService implements ICartItemService{
    @Autowired
    private ICartItemRepository cartItemRepository;
}
