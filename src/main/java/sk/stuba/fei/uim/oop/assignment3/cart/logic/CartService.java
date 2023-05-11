package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartItemRepository;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRepository;
import sk.stuba.fei.uim.oop.assignment3.cart.web.body.CartAddRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.product.logic.IProductService;

@Service
public class CartService implements ICartService{

    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private ICartItemService cartItemService;

    @Autowired
    private IProductService productService;

    @Override
    public Cart create() {
        Cart cart = new Cart();
        this.cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart getCartById(Long id) throws NotFoundException {
        Cart cart = this.cartRepository.findCartById(id);
        if(cart == null){
            throw new NotFoundException();
        }
        return cart;
    }

    @Override
    public void deleteCartById(Long id) throws NotFoundException {
        Cart cart = this.getCartById(id);
        this.cartRepository.deleteById(cart.getId());
    }

    @Override
    public Cart addItemToCartById(Long cartId, CartAddRequest request) throws NotFoundException, IllegalOperationException {
        //TODO
        return null;
    }
}
