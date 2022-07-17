package fr.esgi.cookRecipe.external.service;

import fr.esgi.cookRecipe.domain.product.entity.NutriScore;
import fr.esgi.cookRecipe.domain.product.entity.Product;
import fr.esgi.cookRecipe.domain.product.service.NutriScoreService;
import fr.esgi.cookRecipe.domain.product.service.ProductService;
import fr.esgi.cookRecipe.domain.util.entity.MeasureUnit;
import fr.esgi.cookRecipe.domain.util.service.MeasureUniteService;
import fr.esgi.cookRecipe.external.model.FetchProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class FetchProductService {

    String API_KEY = "c9c2b04bc0be4d2b8f4a60d758447577";
    String BASE_URL = "https://api.spoonacular.com/";

    private final RestTemplate restTemplate;
    private final ProductService productService;
    private final NutriScoreService nutriScoreService;
    private final MeasureUniteService measureUniteService;

    @Autowired
    public FetchProductService(RestTemplate restTemplate, ProductService productService, NutriScoreService nutriScoreService,MeasureUniteService measureUniteService) {
        this.restTemplate = restTemplate;
        this.productService = productService;
        this.nutriScoreService = nutriScoreService;
        this.measureUniteService = measureUniteService;

    }

    public void fetchProducts() throws URISyntaxException {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<NutriScore> nutriscores = this.nutriScoreService.getAllNutriScores();
        System.out.println("nutriscores : "+nutriscores);
        System.out.println("size :"+nutriscores.size());

        for (int i = 0; i < alphabet.length()-1; i++) {
            offsetMethod(alphabet.charAt(i),0,100, nutriscores);
        }
    }

    public void offsetMethod(char letter, int offset, int number, List<NutriScore> nutriScores) throws URISyntaxException {
        String urlFetch = BASE_URL + "food/ingredients/search?";
        FetchProduct result = restTemplate.getForEntity(
                new URI(urlFetch +
                        "query=" + letter +
                        "&offset=" + offset +
                        "&number=" + number +
                        "&apiKey=" + API_KEY),
                FetchProduct.class).getBody();

        result.results.forEach(product -> {
            MeasureUnit unite = measureUniteService.getMeasureUniteByUnite("g");
            Product newProduct = new Product();
            newProduct.setId(UUID.nameUUIDFromBytes(Integer.toString(10).getBytes()));
            newProduct.setName(product.name);
            newProduct.setMeasure(unite);
            newProduct.setNutriScore(generateNutriscore(nutriScores));
            this.productService.addProduct(newProduct);
        });

        if(offset+ number < result.totalResults){
            this.offsetMethod(letter, offset + 100, number + 100, nutriScores);
        }
    }


    private NutriScore generateNutriscore(List<NutriScore> nutriScores){
        Random r = new Random();
        int number = r.nextInt(nutriScores.size());
        return nutriScores.get(number);
    }

}
