package fr.esgi.cookRecipe.external.service;

import fr.esgi.cookRecipe.external.model.ProductApi;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ProductApiService implements ApiService<ProductApi>{
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<ProductApi> getSearchAutocomplete(String query) {
        String urlProductApi =  BASE_URL + "food/ingredients/autocomplete?";

        ProductApi[] result = restTemplate.getForObject(urlProductApi +
                "query=" + query +
                "&number=" + numberResultAutocomplete +
                "&apiKey=" + API_KEY , ProductApi[].class);

        return List.of(result);
    }


}
