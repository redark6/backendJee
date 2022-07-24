package fr.esgi.cookRecipe.exposition.Controller;

import fr.esgi.cookRecipe.application.socialQueriesCommandsEvents.commands.*;
import fr.esgi.cookRecipe.application.socialQueriesCommandsEvents.queries.*;
import fr.esgi.cookRecipe.exposition.SocialDTO.AddCommentRecipeDTO;
import fr.esgi.cookRecipe.exposition.SocialDTO.RateRecipeDTO;
import fr.esgi.cookRecipe.exposition.SocialDTO.RecipeSocialDTO;
import kernel.CommandBus;
import kernel.NoSuchEntityException;
import kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("social")
public class SocialController {

    private  CommandBus commandBus;
    private  QueryBus queryBus;

    @Autowired
    public SocialController(CommandBus commandBus, QueryBus queryBus){
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    public SocialController(){
    }

    /**
     * Pour commenter une recette
     **/
    @PostMapping(value = "/comment",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity commentRecipe(@RequestBody @Valid AddCommentRecipeDTO request){
        final AddCommentRecipe addCommentRecipe = new AddCommentRecipe(request);
        commandBus.send(addCommentRecipe);
        return ResponseEntity.ok().build();
    }

    /**
     * Pour supprimer un commentaire ( à qui nous appartient )
     **/
    @DeleteMapping(value = "/deletecomment/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteCommentRecipe(@PathVariable(value="id") String commentId){
        final DeleteCommentRecipe deleteComment = new DeleteCommentRecipe(commentId);
        commandBus.send(deleteComment);
        return ResponseEntity.ok().build();
    }

    /**
     * Pour évaluer une recette
     **/
    @PostMapping(value = "/rate",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity rateRecipe(@RequestBody @Valid RateRecipeDTO request){
        final RateRecipe rating = new RateRecipe(request);
        commandBus.send(rating);
        return ResponseEntity.ok().build();
    }

    /**
     * Pour liker une recette
     **/
    @PostMapping(value = "/like/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity likeRecipe(@PathVariable(value="id") String recipeId){
        final LikeRecipe liking = new LikeRecipe(recipeId, true);
        commandBus.send(liking);
        return ResponseEntity.ok().build();
    }

    /**
     * Pour retirer le like d'une recette
     **/
    @PostMapping(value = "/unlike/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity unlikeRecipe(@PathVariable(value="id") String recipeId){
        final LikeRecipe liking = new LikeRecipe(recipeId, false);
        commandBus.send(liking);
        return ResponseEntity.ok().build();
    }

    /**
     * Pour récuperer la partie social d'une recette
     **/
    @GetMapping(value = "/recipesocial/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecipeSocialDTO> getRecipeSocial(@PathVariable(value="id") String recipeId){
        final RetrieveRecipesSocial retrieveRecipesSocial = new RetrieveRecipesSocial(recipeId);
        final RecipeSocialDTO result = queryBus.send(retrieveRecipesSocial);
        return ResponseEntity.ok(result);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchEntityException.class)
    public String handleEntityExceptions(
            NoSuchEntityException ex) {
        return ex.getMessage();
    }
}


