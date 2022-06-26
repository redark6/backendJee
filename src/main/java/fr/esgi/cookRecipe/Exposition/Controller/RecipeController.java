package fr.esgi.cookRecipe.Exposition.Controller;

import fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.commands.AddRecipe;
import fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries.*;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.AddRecipeDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipeDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipesDTO;
import kernel.CommandBus;
import kernel.QueryBus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("recipe")
public class RecipeController {

    private  CommandBus commandBus;
    private  QueryBus queryBus;

    public RecipeController(CommandBus commandBus, QueryBus queryBus){
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    public RecipeController(){
    }

    /**
     * Pour créer une recette
     **/
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity AddRecipe(@RequestBody @Valid AddRecipeDTO request){
        final AddRecipe addRecipe = new AddRecipe(request);
        commandBus.send(addRecipe);
        return ResponseEntity.ok().build();
    }

    /**
     * Pour recuperer toutes les recettes
     **/
    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecipesDTO> getAllRecipe(){
        final RetrieveRecipes retrieveRecipes = new RetrieveRecipes();
        final RecipesDTO result = queryBus.send(retrieveRecipes);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour la recherche
     **/
    @GetMapping(value = "/search/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecipesDTO> getRecipeByName(@PathVariable(value="name") String name, @RequestParam(name = "limit") int limit,@RequestParam(name = "offset") int offset){
        final RetrieveRecipesByName retrieveRecipesByName = new RetrieveRecipesByName(name, limit, offset);
        final RecipesDTO result = queryBus.send(retrieveRecipesByName);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour recuperer une reccette par id
     **/
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable(value="id") String id,@RequestParam(name = "research", required = false) String research){
        final RetrieveRecipeById retrieveRecipeById = new RetrieveRecipeById(id,research);
        final RecipeDTO result = queryBus.send(retrieveRecipeById);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour recuperer les reccette par nom de produit
     **/
    @GetMapping(value = "/product/name/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecipesDTO> getRecipesByProductName(@PathVariable(value="name") String productName, @RequestParam(name = "limit") int limit,@RequestParam(name = "offset") int offset){
        final RetrieveRecipesByProductName retrieveRecipesByProductName = new RetrieveRecipesByProductName(productName, limit, offset);
        final RecipesDTO result = queryBus.send(retrieveRecipesByProductName);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour recuperer les reccette par id de produit
     **/
    @GetMapping(value = "/search/product/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecipesDTO> getRecipesByProductId(@PathVariable(value="id") String productId, @RequestParam(name = "limit") int limit,@RequestParam(name = "offset") int offset){
        final RetrieveRecipesByProductId retrieveRecipesByProductId = new RetrieveRecipesByProductId(productId, limit, offset);
        final RecipesDTO result = queryBus.send(retrieveRecipesByProductId);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour recuperer les recette d'un utilisateur
     **/
    @GetMapping(value = "/user/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecipesDTO> getRecipesByUserId(@PathVariable(value="id") String userId){
        final RetrieveRecipesByUserId retrieveRecipesByUserId = new RetrieveRecipesByUserId(userId);
        final RecipesDTO result = queryBus.send(retrieveRecipesByUserId);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour recuperer les recettes les plus rechercher
     **/
    @GetMapping(value ="/search/most/{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecipesDTO> getMostResearchedRecipes(@PathVariable(value="name") String name,@RequestParam(name = "limit") int limit,@RequestParam(name = "offset") int offset){
        final RetrieveMostResearchedRecipesByName retrieveMostResearchedRecipesByName = new RetrieveMostResearchedRecipesByName(name,limit, offset);
        final RecipesDTO result = queryBus.send(retrieveMostResearchedRecipesByName);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour recuperer les recettes jamais rechercher
     **/
    @GetMapping(value ="/search/never/{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecipesDTO> getNeverResearchedRecipes(@PathVariable(value="name") String name, @RequestParam(name = "limit") int limit,@RequestParam(name = "offset") int offset){
        final RetrieveNeverResearchedRecipesByName retrieveNeverResearchedRecipesByName = new RetrieveNeverResearchedRecipesByName(name, limit, offset);
        final RecipesDTO result = queryBus.send(retrieveNeverResearchedRecipesByName);
        return ResponseEntity.ok(result);
    }
}
