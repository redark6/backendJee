package fr.esgi.cookRecipe.exposition.Controller;

import fr.esgi.cookRecipe.application.productQueriesCommandsEvents.queries.*;
import fr.esgi.cookRecipe.application.productQueriesCommandsEvents.commands.*;
import fr.esgi.cookRecipe.exposition.ProductDTO.*;
import fr.esgi.cookRecipe.external.service.FetchProductService;
import kernel.CommandBus;
import kernel.NoSuchEntityException;
import kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

@RestController
@RequestMapping("product")
public class ProductController {

    private  CommandBus commandBus;
    private  QueryBus queryBus;
    private FetchProductService fetchProductService;

    @Autowired
    public ProductController(CommandBus commandBus, QueryBus queryBus, FetchProductService fetchProductService){
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.fetchProductService = fetchProductService;
    }

    public ProductController(){
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
    public ProductsDTO searchProductByname(@PathVariable(value="name",required = true) String name,@RequestParam(name = "limit") int limit,@RequestParam(name = "offset") int offset, @RequestParam(name = "autocomplete",required = false ,defaultValue = "false") boolean autocomplete){
        final RetrieveProductsByName retrieveProductByName = new RetrieveProductsByName(name, limit, offset,autocomplete);
        final ProductsDTO result = queryBus.send(retrieveProductByName);
        return result;
    }

    /**
     * Pour récuperer un produit par id
     **/
    @GetMapping(value = "/id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(value="id") String id, @RequestParam(name = "research",required = false) String research){
        final RetrieveProductById retrieveProductById = new RetrieveProductById(id, research);
        final ProductDTO result = queryBus.send(retrieveProductById);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour récuperer les nutriscores
     **/
    @GetMapping(value = "/nutriscore/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NutriScoresDTO> getAllNutriScore(){
        final RetrieveNutriScores retrieveNutriScores = new RetrieveNutriScores();
        final NutriScoresDTO result = queryBus.send(retrieveNutriScores);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour récuperer les unités
     **/
    @GetMapping(value = "/measure/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MeasuresUniteDTO> getAllMeasure(){
        final RetrieveMeasureUnite retrieveMeasureUnite = new RetrieveMeasureUnite();
        final MeasuresUniteDTO result = queryBus.send(retrieveMeasureUnite);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour récuperer un nutriscore par id
     **/
    @GetMapping(value ="/nutriscore/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NutriScoreDTO> getNutriScoreById(@PathVariable(value="id") String id){
        final RetrieveNutriScoreById retrieveNutriScoreById = new RetrieveNutriScoreById(id);
        final NutriScoreDTO result = queryBus.send(retrieveNutriScoreById);
        return ResponseEntity.ok(result);
    }

    /**
     * Pour récuperer les produits les plus rechercher
     **/
    @GetMapping(value ="/search/most/{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<ProductsDTO> getMostResearchedProducts(@PathVariable(value="name",required = true) String name,@RequestParam(name = "limit") int limit,@RequestParam(name = "offset") int offset, @RequestParam(name = "autocomplete",required = false ,defaultValue = "false") boolean autocomplete){
            final RetrieveMostResearchedProductsByName retrieveMostResearchedProductsByName = new RetrieveMostResearchedProductsByName(name,limit,offset,autocomplete);
            final ProductsDTO result = queryBus.send(retrieveMostResearchedProductsByName);
            return ResponseEntity.ok(result);
    }

    /**
     * Pour récuperer les produits jamais rechercher
     **/
    @GetMapping(value ="/search/never/{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductsDTO> getNeverResearchedProducts(@PathVariable(value="name",required = true) String name,@RequestParam(name = "limit") int limit,@RequestParam(name = "offset") int offset, @RequestParam(name = "autocomplete",required = false ,defaultValue = "false") boolean autocomplete){
        final RetrieveNeverResearchedProductsByName retrieveNeverResearchedProductsByName = new RetrieveNeverResearchedProductsByName(name,limit,offset,autocomplete);
        final ProductsDTO result = queryBus.send(retrieveNeverResearchedProductsByName);
        return ResponseEntity.ok(result);
    }


    @GetMapping(value = "/test/fetchData")
    public ResponseEntity<Void> fetchProductFromSpoon() throws URISyntaxException {
        this.fetchProductService.fetchProducts();
        return ResponseEntity.ok().build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchEntityException.class)
    public String handleEntityExceptions(
            NoSuchEntityException ex) {
        return ex.getMessage();
    }
}
