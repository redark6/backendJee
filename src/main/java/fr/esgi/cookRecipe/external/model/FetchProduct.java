package fr.esgi.cookRecipe.external.model;

import java.util.List;

public class FetchProduct {

    public List<SousObjet> results;

    public int offset;

    public int number;

    public int totalResults;

    public class SousObjet {

        public int id;

        public String name;

        public String image;
    }
}


