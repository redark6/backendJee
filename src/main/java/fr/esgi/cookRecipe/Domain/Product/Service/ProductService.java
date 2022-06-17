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

    public Product getProductById(UUID id) {
        Optional<Product> product = this.productRepository.findById(id);
        if(product.isEmpty()){
            throw NoSuchEntityException.withIdAndElem(id,"product");
        }
        return product.get();
    }

    public List<Product> getProductsByName(String name, Pageable pagination) {
        return this.productRepository.findProductByNameContainingOrderByNameAsc(name, pagination).getContent();
    }

    public List<Product> getMostResearchedProductsByName(String name, Pageable pagination) {
        return this.productRepository.findProductByNameContainingOrderByNameAsc(name, pagination).getContent();
    }

    public List<Product> getNeverResearchedProductsByName(String name, Pageable pagination) {
        return this.productRepository.findProductByNameContainingOrderByNameAsc(name, pagination).getContent();
    }

    public void deleteProductById(UUID id) {
        this.productRepository.delete(this.getProductById(id));
    }

    private void saveProduct(Product product){
        this.productRepository.save(product);
    }
}
