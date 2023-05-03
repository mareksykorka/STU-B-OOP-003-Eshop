package sk.stuba.fei.uim.oop.assignment3.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.product.logic.ProductService;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductAmount;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductEditRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductResponse;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllProducts() {
        return new ResponseEntity(this.service.getProducts().stream().map(ProductResponse::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createProduct(@RequestBody ProductRequest requestBody) {
        return new ResponseEntity(new ProductResponse(this.service.createProduct(requestBody)), HttpStatus.CREATED);
    }

    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProduct(@PathVariable("id") Long productId) throws NotFoundException {
        return new ResponseEntity(new ProductResponse(this.service.getProductById(productId)), HttpStatus.OK);
    }

    @PutMapping(value = "/product/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProduct(@PathVariable("id") Long productId, @RequestBody ProductEditRequest requestBody) throws NotFoundException {
        return new ResponseEntity(new ProductResponse(this.service.updateProductById(productId, requestBody)), HttpStatus.OK);
    }

    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Long productId) throws NotFoundException {
        this.service.deleteProductById(productId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/product/{id}/amount", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductAmount(@PathVariable("id") Long productId) throws NotFoundException {
        return new ResponseEntity(new ProductAmount(this.service.getProductAmount(productId)), HttpStatus.OK);
    }

    @PostMapping(value = "/product/{id}/amount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addProductAmount(@PathVariable("id") Long productId, @RequestBody ProductAmount requestBody) throws NotFoundException {
        return new ResponseEntity(new ProductAmount(this.service.changeProductAmount(productId, requestBody)), HttpStatus.OK);
    }
}
