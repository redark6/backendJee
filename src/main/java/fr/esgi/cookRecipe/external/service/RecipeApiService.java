package fr.esgi.cookRecipe.external.service;

import fr.esgi.cookRecipe.external.model.RecipeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@Service
public class RecipeApiService implements ApiService<RecipeApi>{

    private final RestTemplate restTemplate;

    @Autowired
    public RecipeApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<RecipeApi> searchAutocomplete(String query) throws URISyntaxException {
        String urlRecipeApi =  BASE_URL + "recipes/autocomplete?";

        RecipeApi[] result = restTemplate.getForEntity(
                new URI(urlRecipeApi +
                        "query=" + query +
                        "&number=" + numberResultAutocomplete +
                        "&apiKey=" + API_KEY),
                RecipeApi[].class).getBody();
        return Arrays.asList(result);
    }

    @Override
    public String getSearchAutocomplete(String query) {
        String result = query;
        try{
            List<RecipeApi> searchResult = this.searchAutocomplete(query);
            if(!searchResult.isEmpty()){
                result = searchResult.get(0).name;
            }
        } catch (Exception e){
            // not a big deal mak message i think
        }
        return result;
    }
}
