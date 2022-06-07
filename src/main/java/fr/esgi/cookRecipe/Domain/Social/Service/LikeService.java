package fr.esgi.cookRecipe.Domain.Social.Service;

import fr.esgi.cookRecipe.Domain.Social.Repository.LikeRepository;
import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    private final LikeRepository likeRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public List<Product> getLikesByRecipe() {
        return null;
    }

    public void putLike(Product product) {
        this.saveProduct(product);
    }

    private void saveProduct(Product product) {
        this.likeRepository.save(product);
    }
}
