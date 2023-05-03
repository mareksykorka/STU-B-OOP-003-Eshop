package sk.stuba.fei.uim.oop.assignment3.product.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.product.data.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductAmount;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductEditRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> getProducts() {
        return this.repository.findAll();
    }

    @Override
    public Product createProduct(ProductRequest request) {
        return this.repository.save(new Product(request));
    }

    @Override
    public Product getProductById(long id) throws NotFoundException {
        Product p = this.repository.findProductById(id);
        if (p == null) {
            throw new NotFoundException();
        }
        return p;
    }

    @Override
    public Product updateProductById(long id, ProductEditRequest request) throws NotFoundException {
        Product p = this.getProductById(id);
        if (request.getName() != null) {
            p.setName(request.getName());
        }
        if (request.getDescription() != null) {
            p.setDescription(request.getDescription());
        }
        return this.repository.save(p);
    }

    @Override
    public void deleteProductById(long id) throws NotFoundException {
        this.repository.delete(getProductById(id));
    }

    @Override
    public long getProductAmount(long id) throws NotFoundException {
        return this.getProductById(id).getAmount();
    }

    @Override
    public long changeProductAmount(long id, ProductAmount request) throws NotFoundException {
        Product p = this.getProductById(id);
        p.setAmount(p.getAmount() + request.getAmount());
        this.repository.save(p);
        return p.getAmount();
    }
}
