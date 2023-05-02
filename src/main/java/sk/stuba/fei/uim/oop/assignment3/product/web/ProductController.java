package sk.stuba.fei.uim.oop.assignment3.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.product.logic.ProductService;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductAmount;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductEditRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductResponse;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/product")
    public List<ProductResponse> getAllProducts() {
        return this.service.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody ProductRequest request) {
        try {
            return new ResponseEntity(new ProductResponse(this.service.createNewProduct(request)), HttpStatus.CREATED);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/product/{id}")
    public ProductResponse getAllProducts(@PathVariable("id") Long id) throws NotFoundException {
        return new ProductResponse(this.service.getId(id));
    }

    @PutMapping("/product/{id}")
    public ProductResponse updateProduct(@PathVariable("id") Long id, @RequestBody ProductEditRequest request) throws NotFoundException  {
        return new ProductResponse(this.service.updateId(id, request));
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") Long id) throws NotFoundException  {
        this.service.deleteId(id);
    }

    @GetMapping("/product/{id}/amount")
    public ProductAmount getProductAmount(@PathVariable("id") Long id) throws NotFoundException  {
        return new ProductAmount(this.service.getAmount(id));
    }

    @PostMapping("/product/{id}/amount")
    public ProductAmount setProductAmount(@PathVariable("id") Long id, @RequestBody ProductAmount request) throws NotFoundException  {
        return new ProductAmount(this.service.setAmount(id, request));
    }
}
