package fr.esgi.cookRecipe.external.service;

import fr.esgi.cookRecipe.external.model.RecipeApi;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RecipeApiService implements ApiService<RecipeApi>{

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<RecipeApi> getSearchAutocomplete(String query) {
        String urlRecipeApi =  BASE_URL + "recipes/autocomplete?";

        RecipeApi[] result = restTemplate.getForObject(urlRecipeApi +
                "query=" + query +
                "&number=" + numberResultAutocomplete +
                "&apiKey=" + API_KEY , RecipeApi[].class);

        return List.of(result);
    }
}
