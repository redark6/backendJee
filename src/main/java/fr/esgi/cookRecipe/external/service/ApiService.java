package fr.esgi.cookRecipe.external.service;

import java.net.URISyntaxException;
import java.util.List;

public interface ApiService <T>{
    String API_KEY = "c9c2b04bc0be4d2b8f4a60d758447577";
    String BASE_URL = "https://api.spoonacular.com/";
    int numberResultAutocomplete = 1;

    List<T> searchAutocomplete(String query) throws URISyntaxException;
    String getSearchAutocomplete(String query);
}
