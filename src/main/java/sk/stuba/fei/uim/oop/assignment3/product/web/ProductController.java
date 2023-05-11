package sk.stuba.fei.uim.oop.assignment3.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.logic.IProductService;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductAmount;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponse> getAllProducts() {
        return this.productService.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest requestBody) {
        return new ResponseEntity(new ProductResponse(this.productService.create(requestBody)), HttpStatus.CREATED);
    }

    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse getProduct(@PathVariable("id") Long productId) throws NotFoundException {
        return new ProductResponse(this.productService.getProductById(productId));
    }

    @PutMapping(value = "/product/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse updateProduct(@PathVariable("id") Long productId, @RequestBody  ProductRequest requestBody) throws NotFoundException {
        return new ProductResponse(this.productService.editProductById(productId, requestBody));
    }

    @DeleteMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteProduct(@PathVariable("id") Long productId) throws NotFoundException {
        this.productService.deleteProductById(productId);
    }

    @GetMapping(value = "/product/{id}/amount", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductAmount getProductAmount(@PathVariable("id") Long productId) throws NotFoundException {
        return new ProductAmount(this.productService.getProductAmountById(productId));
    }

    @PostMapping(value = "/product/{id}/amount", consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductAmount addProductAmount(@PathVariable("id") Long productId,  @RequestBody  ProductAmount requestBody) throws NotFoundException {
        return new ProductAmount(this.productService.increaseProductAmountById(productId, requestBody.getAmount()));
    }
}
