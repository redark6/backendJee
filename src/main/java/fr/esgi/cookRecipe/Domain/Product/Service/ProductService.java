package fr.esgi.cookRecipe.Domain.Product.Service;

import fr.esgi.cookRecipe.Domain.Product.Repository.ProductRepository;
import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import kernel.NoSuchEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product){
        this.saveProduct(product);
    }

    public List<Product> getAllProducts() {
        Iterable<Product> products = this.productRepository.findAll();
        return Streamable.of(products).toList();
    }

    public List<Product> getPaginatedProductList(Pageable pagination) {
        return this.productRepository.findAll(pagination).getContent();
    }

    public Product getProductById(UUID id) {
        Optional<Product> product = this.productRepository.findById(id);
        if(product.isEmpty()){
            throw NoSuchEntityException.withIdAndElem(id,"product");
        }
        return product.get();
    }

    public Product getProductByName(String name) {
        Optional<Product> product = this.productRepository.getProductByName(name);
        if(product.isEmpty()){
            throw NoSuchEntityException.withNameAndElem(name,"product");
        }
        return product.get();
    }

    public void deleteProductById(UUID id) {
        this.productRepository.delete(this.getProductById(id));
    }

    private void saveProduct(Product product){
        this.productRepository.save(product);
    }
}