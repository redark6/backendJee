package fr.esgi.cookRecipe.exposition.Controller;

import fr.esgi.cookRecipe.application.userQueriesCommandsEvents.commands.*;
import fr.esgi.cookRecipe.application.userQueriesCommandsEvents.queries.*;
import fr.esgi.cookRecipe.exposition.UserDTO.*;
import kernel.CommandBus;
import kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    private  CommandBus commandBus;
    private  QueryBus queryBus;

    @Autowired
    public UserController(CommandBus commandBus, QueryBus queryBus){
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    public UserController(){
    }
    /**
     * Pour créer un compte
     **/
    @PostMapping(value = "/create", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createAccount(@RequestBody @Valid CreateAccountDTO request){
        final CreateAccount createAccount = new CreateAccount(request);
        commandBus.send(createAccount);
        return ResponseEntity.ok().build();
    }

    /**
     * Pour récuperer un compte par id
     **/
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserDTO> getUserProfilById(@PathVariable(value="id") String id){
        final RetrieveUserById retrieveUserById = new RetrieveUserById(id);
        final UserDTO result = queryBus.send(retrieveUserById);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour la recherche d'utilisateur
    **/
    @GetMapping(value = "/search/{usernamelike}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UsersDTO> searchUserProfil(@PathVariable(value="usernamelike") String usernamelike, @RequestParam(name = "limit") int limit, @RequestParam(name = "offset") int offset){
        final RetrieveUsersByUserNameLike retrieveUsersByNameLike = new RetrieveUsersByUserNameLike(usernamelike,limit,offset);
        final UsersDTO result = queryBus.send(retrieveUsersByNameLike);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour récuperer son compte
     **/
    @GetMapping(value = "/me", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserMeDTO> getConnectedUserProfil(){
        final RetrieveUserMe retrieveUserMe = new RetrieveUserMe();
        final UserMeDTO result = queryBus.send(retrieveUserMe);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour mettre à jour son mail
     **/
    @PatchMapping(value = "/me/updatemail", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity modifyMail(@RequestBody @Valid ModifyMailDTO request){
        final UpdateMail updateMail = new UpdateMail(request);
        commandBus.send(updateMail);
        return ResponseEntity.ok().build();
    }

    /**
     * Pour mettre à jour son mot de passe
     **/
    @PatchMapping(value = "/me/updatepassword", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity modifyPassword(@RequestBody @Valid ModifyPasswordDTO request){
        final UpdatePassword updatePassword = new UpdatePassword(request);
        commandBus.send(updatePassword);
        return ResponseEntity.ok().build();
    }

}
