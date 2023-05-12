package sk.stuba.fei.uim.oop.assignment3.product.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductRequest;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product create(ProductRequest request) {
        Product product = new Product(request);
        this.productRepository.save(product);
        return product;
    }

    @Override
    public Product getProductById(Long id) throws NotFoundException {
        Product product = this.productRepository.findProductById(id);
        if (product == null) {
            throw new NotFoundException();
        }
        return product;
    }

    @Override
    public Product editProductById(Long id, ProductRequest request) throws NotFoundException {
        Product product = this.getProductById(id);
        if (request.getName() != null) {
            product.setName(request.getName());
        }
        if (request.getDescription() != null) {
            product.setDescription(request.getDescription());
        }
        this.productRepository.save(product);
        return product;
    }

    @Override
    public void deleteProductById(Long id) throws NotFoundException {
        Product product = this.getProductById(id);
        this.productRepository.deleteById(product.getId());
    }

    @Override
    public Long getProductAmountById(Long id) throws NotFoundException {
        Product product = this.getProductById(id);
        return product.getAmount();
    }

    @Override
    public Long increaseProductAmountById(Long id, Long amount) throws NotFoundException {
        Product product = this.getProductById(id);
        product.setAmount(product.getAmount() + amount);
        this.productRepository.save(product);
        return product.getAmount();
    }

    @Override
    public Long decreaseProductAmountById(Long id, Long amount) throws NotFoundException {
        Product product = this.getProductById(id);
        product.setAmount(product.getAmount() - amount);
        this.productRepository.save(product);
        return product.getAmount();
    }

    @Override
    public boolean isInStock(Long productId, Long amount) throws NotFoundException{
        return this.getProductById(productId).getAmount() >= amount;
    }

}
