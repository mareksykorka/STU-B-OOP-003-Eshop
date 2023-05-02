package sk.stuba.fei.uim.oop.assignment3.product.logic;

import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductAmount;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductEditRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductRequest;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    Product createNewProduct(ProductRequest request);

    Product getId(long id);

    Product updateId(long id, ProductEditRequest request);

    void deleteId(long id);

    long getAmount(long id);

    long setAmount(long id, ProductAmount request);
}
