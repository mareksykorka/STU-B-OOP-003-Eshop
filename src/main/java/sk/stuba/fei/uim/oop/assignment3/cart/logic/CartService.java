package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.aspectj.weaver.ast.Not;
import org.aspectj.weaver.patterns.NotTypePattern;
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
        Cart cart = getCartById(cartId);

        if(cart.getPayed() || !this.productService.isInStock(request.getProductId(), request.getAmount())){
            throw new IllegalOperationException();
        }

        CartItem cartItem = this.cartItemService.getCartItem(cart.getShoppingList(),request.getProductId());

        if(cartItem == null) {
            CartItem newCartItem = this.cartItemService.create(request.getProductId());
            newCartItem.setAmount(request.getAmount());
            this.cartItemService.save(newCartItem);
            cart.getShoppingList().add(newCartItem);
        } else {
            cartItem.setAmount(cartItem.getAmount() + request.getAmount());
            this.cartItemService.save(cartItem);
        }

        this.productService.decreaseProductAmountById(request.getProductId(), request.getAmount());

        this.cartRepository.save(cart);
        return cart;
    }

    @Override
    public Double payCartById(Long cartId) throws NotFoundException, IllegalOperationException {
        Cart cart = getCartById(cartId);

        if(cart.getPayed()){
            throw new IllegalOperationException();
        }

        cart.setPayed(true);
        double totalPrice = 0;
        for (CartItem cartItem:cart.getShoppingList()) {
            totalPrice = totalPrice + (cartItem.getAmount() * (this.productService.getProductById(cartItem.getProductId()).getPrice()));
        }

        this.cartRepository.save(cart);
        return totalPrice;
    }


}
