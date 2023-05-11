package sk.stuba.fei.uim.oop.assignment3.product.logic;

import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductAmount;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductResponse;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product create(ProductRequest request);
    Product getProductById(Long id) throws NotFoundException;
    Product editProductById(Long id, ProductRequest request) throws NotFoundException;
    boolean deleteProductById(Long id) throws NotFoundException;
    Long getProductAmountById(Long id) throws NotFoundException;
    Long increaseProductAmountById(Long productId, Long amount) throws NotFoundException;
    Long decreaseProductAmountById(Long productId, Long amount) throws NotFoundException;
}
