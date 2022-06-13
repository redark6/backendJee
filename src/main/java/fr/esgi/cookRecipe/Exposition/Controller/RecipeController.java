package fr.esgi.cookRecipe.Exposition.Controller;

import fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.commands.AddRecipe;
import fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries.*;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.AddRecipeDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipeDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipesDTO;
import kernel.CommandBus;
import kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("recipe")
public class RecipeController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    public RecipeController(CommandBus commandBus, QueryBus queryBus){
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity AddRecipe(@RequestBody @Valid AddRecipeDTO request){
        final AddRecipe addRecipe = new AddRecipe(request);
        commandBus.send(addRecipe);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecipesDTO> getAllRecipe(){
        final RetrieveRecipes retrieveRecipes = new RetrieveRecipes();
        final RecipesDTO result = queryBus.send(retrieveRecipes);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/paginatedrecipes",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecipesDTO> getPaginatedRecipeList(@RequestParam(name = "limit") int limit,@RequestParam(name = "offset") int offset){
        final RetrievePaginatedRecipes retrievePaginatedRecipes = new RetrievePaginatedRecipes(limit,offset);
        final RecipesDTO result = queryBus.send(retrievePaginatedRecipes);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable(value="id") String id){
        final RetrieveRecipeById retrieveRecipeById = new RetrieveRecipeById(id);
        final RecipeDTO result = queryBus.send(retrieveRecipeById);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour la recherche
    **/
    @GetMapping(value = "/name/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecipesDTO> getRecipeByName(@PathVariable(value="name") String name){
        final RetrieveRecipesByName retrieveProductByName = new RetrieveRecipesByName(name);
        final RecipesDTO result = queryBus.send(retrieveProductByName);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour la recherche
    **/
    @GetMapping(value = "/product/name/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecipesDTO> getRecipesByProductName(@PathVariable(value="name") String name){
        final RetrieveRecipesByProductName retrieveRecipesByProductName = new RetrieveRecipesByProductName(name);
        final RecipesDTO result = queryBus.send(retrieveRecipesByProductName);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/product/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecipesDTO> getRecipesByProductId(@PathVariable(value="id") String id){
        final RetrieveRecipesByProductId retrieveRecipesByProductId = new RetrieveRecipesByProductId(id);
        final RecipesDTO result = queryBus.send(retrieveRecipesByProductId);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/user/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecipesDTO> getRecipesByUserId(@PathVariable(value="id") String id){
        final RetrieveRecipesByUserId retrieveRecipesByUserId = new RetrieveRecipesByUserId(id);
        final RecipesDTO result = queryBus.send(retrieveRecipesByUserId);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/product/name/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecipesDTO> getRecipesByProductName(@PathVariable(value="name") String name){
        final RetrieveRecipesByProductName retrieveRecipesByProductName = new RetrieveRecipesByProductName(name);
        final RecipesDTO result = queryBus.send(retrieveRecipesByProductName);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value ="/research/{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecipesDTO> getMostResearchedRecipes(@PathVariable(value="name") String name,@RequestParam(name = "limit") int limit,@RequestParam(name = "offset") int offset){
       final RetrieveMostResearchedRecipesByName retrieveMostResearchedRecipesByName = new RetrieveMostResearchedRecipesByName(name,limit,offset);
       final RecipesDTO result = queryBus.send(retrieveMostResearchedRecipesByName);
        return ResponseEntity.ok(result);
   }

    @GetMapping(value ="/research/neverresearched", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecipesDTO> getNeverResearchedRecipes(@RequestParam(name = "limit") int limit,@RequestParam(name = "offset") int offset){
        final RetrieveNeverResearchedRecipesByName retrieveNeverResearchedRecipesByName = new RetrieveNeverResearchedRecipesByName(limit,offset);
        final RecipesDTO result = queryBus.send(retrieveNeverResearchedRecipesByName);
        return ResponseEntity.ok(result);
    }
}
