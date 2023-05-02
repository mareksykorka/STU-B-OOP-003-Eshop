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
    public List<Product> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Product createNewProduct(ProductRequest request) throws NotFoundException {
        return this.repository.save(new Product(request));
    }

    @Override
    public Product getId(long id) throws NotFoundException {
        Product p = this.repository.findProductById(id);
        if (p == null) {
            throw new NotFoundException();
        }
        return p;
    }

    @Override
    public Product updateId(long id, ProductEditRequest request) throws NotFoundException {
        Product p = this.getId(id);
        if (request.getName() != null) {
            p.setName(request.getName());
        }
        if (request.getDescription() != null) {
            p.setDescription(request.getDescription());
        }
        return this.repository.save(p);
    }

    @Override
    public void deleteId(long id) throws NotFoundException {
        Product p = this.repository.findProductById(id);
        if (p == null) {
            throw new NotFoundException();
        }
        this.repository.delete(p);
    }

    @Override
    public long getAmount(long id) throws NotFoundException {
        return this.getId(id).getAmount();
    }

    @Override
    public long setAmount(long id, ProductAmount request) throws NotFoundException {
        Product p = this.getId(id);
        p.setAmount(p.getAmount() + request.getAmount());
        this.repository.save(p);
        return p.getAmount();
    }
}
