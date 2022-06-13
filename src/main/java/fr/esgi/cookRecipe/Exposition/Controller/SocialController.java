package fr.esgi.cookRecipe.Exposition.Controller;

import fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.commands.*;
import fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.queries.RetrieveRecipesSocial;
import fr.esgi.cookRecipe.Exposition.SocialDTO.AddCommentRecipeDTO;
import fr.esgi.cookRecipe.Exposition.SocialDTO.RateRecipeDTO;
import fr.esgi.cookRecipe.Exposition.SocialDTO.RecipesSocialDTO;
import kernel.CommandBus;
import kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("social")
public class SocialController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    public SocialController(CommandBus commandBus, QueryBus queryBus){
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(value = "/comment}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity commentRecipe(@RequestBody @Valid AddCommentRecipeDTO request){
        final AddCommentRecipe addCommentRecipe = new AddCommentRecipe(request);
        commandBus.send(addCommentRecipe);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/deletecomment}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteCommentRecipe(@RequestBody @Valid DeleteCommentRecipeDTO request){
        final DeleteCommentRecipe deleteComment = new DeleteCommentRecipe(request);
        commandBus.send(deleteComment);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/rate}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity rateRecipe(@RequestBody @Valid RateRecipeDTO request){
        final RateRecipe rating = new RateRecipe(request);
        commandBus.send(rating);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/like}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity likeRecipe(@RequestBody @Valid LikeDTO request){
        final LikeRecipe liking = new LikeRecipe(request);
        commandBus.send(liking);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/unlike}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity unlikeRecipe(@RequestBody @Valid LikeDTO request){
        final UnlikeRecipe unliking = new UnlikeRecipe(request);
        commandBus.send(unliking);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/recipesocial", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecipesSocialDTO> getRecipeSocial(){
        final RetrieveRecipesSocial retrieveRecipesSocial = new RetrieveRecipesSocial();
        final RecipesSocialDTO result = queryBus.send(retrieveRecipesSocial);
        return ResponseEntity.ok(result);
    }
}
