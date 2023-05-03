package sk.stuba.fei.uim.oop.assignment3.product.logic;

import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductAmount;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductEditRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();

    Product createProduct(ProductRequest request);

    Product getProductById(long id) throws NotFoundException;

    Product updateProductById(long id, ProductEditRequest request) throws NotFoundException;

    void deleteProductById(long id) throws NotFoundException;

    long getProductAmount(long id) throws NotFoundException;

    long changeProductAmount(long id, ProductAmount request) throws NotFoundException;
}
