package sk.stuba.fei.uim.oop.assignment3.product.logic;

import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductAmount;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductEditRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    Product createNewProduct(ProductRequest request) throws NotFoundException;

    Product getId(long id) throws NotFoundException;

    Product updateId(long id, ProductEditRequest request) throws NotFoundException;

    void deleteId(long id) throws NotFoundException;

    long getAmount(long id) throws NotFoundException;

    long setAmount(long id, ProductAmount request) throws NotFoundException;
}
