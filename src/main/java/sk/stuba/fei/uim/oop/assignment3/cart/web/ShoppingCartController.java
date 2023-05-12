package sk.stuba.fei.uim.oop.assignment3.cart.web;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.logic.ICartService;
import sk.stuba.fei.uim.oop.assignment3.cart.web.body.CartAddRequest;
import sk.stuba.fei.uim.oop.assignment3.cart.web.body.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

@RestController
public class ShoppingCartController {

    @Autowired
    private ICartService cartService;

    @PostMapping(value = "/cart", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> createCart() {
        return new ResponseEntity(new CartResponse(this.cartService.create()), HttpStatus.CREATED);
    }

    @GetMapping(value = "/cart/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CartResponse createCart(@PathVariable("id") Long cartId) throws NotFoundException {
        return new CartResponse(this.cartService.getCartById(cartId));
    }

    @DeleteMapping(value = "/cart/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCart(@PathVariable("id") Long cartId) throws NotFoundException {
        this.cartService.deleteCartById(cartId);
    }

    @PostMapping(value = "/cart/{id}/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CartResponse addItemToCart(@PathVariable("id") Long cartId, @RequestBody CartAddRequest bodyRequest) throws NotFoundException, IllegalOperationException {
        return new CartResponse(this.cartService.addItemToCartById(cartId, bodyRequest));
    }

    @GetMapping(value = "/cart/{id}/pay", produces = MediaType.TEXT_PLAIN_VALUE)
    public String payCart(@PathVariable("id") Long cartId) throws NotFoundException, IllegalOperationException {
        return "" + this.cartService.payCartById(cartId);
    }

}
