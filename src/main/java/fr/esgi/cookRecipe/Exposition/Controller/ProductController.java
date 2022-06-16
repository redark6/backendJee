package fr.esgi.cookRecipe.Exposition.Controller;

import fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries.*;
import fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.commands.AddProduct;
import fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.commands.DeleteProductById;
import fr.esgi.cookRecipe.Exposition.ProductDTO.*;
import kernel.CommandBus;
import kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("product")
public class ProductController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    public ProductController(CommandBus commandBus, QueryBus queryBus){
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    /**
     * Pour créer un produit
     **/
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity AddProduct(@RequestBody @Valid AddProductDTO request){
        final AddProduct addProduct = new AddProduct(request);
        commandBus.send(addProduct);
        return ResponseEntity.ok().build();
    }

    /**
     * Pour récuperer tout les produits
     **/
    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductsDTO> getAllProducts(){
        final RetrieveProducts retrieveProducts = new RetrieveProducts();
        final ProductsDTO result = queryBus.send(retrieveProducts);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour récuperer les produits paginé par nom (recherche)
     **/
    @GetMapping(value = "/search/{name}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductsDTO> searchProductByname(@PathVariable(value="name") String name,@RequestParam(name = "limit") int limit,@RequestParam(name = "offset") int offset){
        final RetrieveProductsByName retrieveProductByName = new RetrieveProductsByName(name, limit, offset);
        final ProductsDTO result = queryBus.send(retrieveProductByName);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour récuperer un produit par id
     **/
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(value="id") String id){
        final RetrieveProductById retrieveProductById = new RetrieveProductById(id);
        final ProductDTO result = queryBus.send(retrieveProductById);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour supprimer un produit par id ( faudrais supprimer toutes les recettes associer, ed point a enlever surement)
     **/
    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteProduct(@PathVariable(value="id") String id){
        final DeleteProductById deleteProductById = new DeleteProductById(id);
        commandBus.send(deleteProductById);
        return ResponseEntity.ok().build();
    }

    /**
     * Pour récuperer les nutriscores
     **/
    @GetMapping(value = "/nutriscore/all", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NutriScoresDTO> getAllNutriScore(){
        final RetrieveNutriScores retrieveNutriScores = new RetrieveNutriScores();
        final NutriScoresDTO result = queryBus.send(retrieveNutriScores);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour récuperer un nutriscore par id
     **/
    @GetMapping(value ="/nutriscore/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NutriScoreDTO> getNutriScoreById(@PathVariable(value="id") String id){
        final RetrieveNutriScoreById retrieveNutriScoreById = new RetrieveNutriScoreById(id);
        final NutriScoreDTO result = queryBus.send(retrieveNutriScoreById);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour récuperer les produits les plus rechercher
     **/
    @GetMapping(value ="/search/most/{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<ProductsDTO> getMostResearchedProducts(@PathVariable(value="name") String name,@RequestParam(name = "limit") int limit,@RequestParam(name = "offset") int offset){
            final RetrieveMostResearchedProductsByName retrieveMostResearchedProductsByName = new RetrieveMostResearchedProductsByName(name,limit,offset);
            final ProductsDTO result = queryBus.send(retrieveMostResearchedProductsByName);
            return ResponseEntity.ok(result);
    }

    /**
     * Pour récuperer les produits jamais rechercher
     **/
    @GetMapping(value ="/search/never/{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductsDTO> getNeverResearchedProducts(@PathVariable(value="name") String name,@RequestParam(name = "limit") int limit,@RequestParam(name = "offset") int offset){
        final RetrieveNeverResearchedProductsByName retrieveNeverResearchedProductsByName = new RetrieveNeverResearchedProductsByName(name,limit,offset);
        final ProductsDTO result = queryBus.send(retrieveNeverResearchedProductsByName);
        return ResponseEntity.ok(result);
    }
}
