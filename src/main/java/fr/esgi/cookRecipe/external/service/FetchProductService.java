package fr.esgi.cookRecipe.external.service;

import fr.esgi.cookRecipe.external.model.FetchProduct;
import fr.esgi.cookRecipe.external.model.ProductApi;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@Service
public class FetchProductService {

    String API_KEY = "c9c2b04bc0be4d2b8f4a60d758447577";
    String BASE_URL = "https://api.spoonacular.com/";

    private final RestTemplate restTemplate;

    public FetchProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void fetchProducts() throws URISyntaxException {
//        String urlProductApi =  BASE_URL + "food/ingredients/autocomplete?";

        this.alphabet();

    }

    public void alphabet() throws URISyntaxException {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < alphabet.length()-1; i++) {
            offset(alphabet.charAt(i),0,100);
        }
    }

    public void offset(char letter, int offset, int number) throws URISyntaxException {
        String urlFetch = "https://api.spoonacular.com/food/ingredients/search?";
        FetchProduct result = restTemplate.getForEntity(
                new URI(urlFetch +
                        "query=" + letter +
                        "&offset=" + offset +
                        "&number=" + number +
                        "&apiKey=" + API_KEY),
                FetchProduct.class).getBody();
    }
}
