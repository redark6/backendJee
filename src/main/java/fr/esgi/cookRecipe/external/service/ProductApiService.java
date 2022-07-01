package fr.esgi.cookRecipe.external.service;

import fr.esgi.cookRecipe.external.model.ProductApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductApiService implements ApiService<ProductApi>{
    private final RestTemplate restTemplate;

    @Autowired
    public ProductApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ProductApi> searchAutocomplete(String query) throws URISyntaxException {
        String urlProductApi =  BASE_URL + "food/ingredients/autocomplete?";

        ProductApi[] result = restTemplate.getForEntity(
                new URI(urlProductApi +
                        "query=" + query +
                        "&number=" + numberResultAutocomplete +
                        "&apiKey=" + API_KEY),
                ProductApi[].class).getBody();
        return Arrays.asList(result);
    }

    @Override
    public String getSearchAutocomplete(String query) {
        String result = query;
        try{
            List<ProductApi> searchResult = this.searchAutocomplete(query);
            if(!searchResult.isEmpty()){
                result = searchResult.get(0).name;
            }
        } catch (Exception e){
            // not a big deal mak message i think
        }
        return result;
    }
}
