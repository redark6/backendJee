package fr.esgi.cookRecipe.Exposition.Controller;

import fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries.RetrieveNutriScoreById;
import fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries.RetrieveNutriScores;
import fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.commands.AddProduct;
import fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.commands.DeleteProductById;
import fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries.RetrievePaginatedProducts;
import fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries.RetrieveProductById;
import fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries.RetrieveProductByName;
import fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries.RetrieveProducts;
import fr.esgi.cookRecipe.Exposition.ProductDTO.*;
import kernel.CommandBus;
import kernel.QueryBus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("product")
public class ProductController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public ProductController(CommandBus commandBus, QueryBus queryBus){
         this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity AddProduct(@RequestBody @Valid AddProductDTO request){
        final AddProduct addProduct = new AddProduct(request);
        commandBus.send(addProduct);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductsDTO> getAllProducts(){
        final RetrieveProducts retrieveProducts = new RetrieveProducts();
        final ProductsDTO result = queryBus.send(retrieveProducts);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/paginatedproducts",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductsDTO> getPaginatedProductList(@RequestParam(name = "limit") int limit,@RequestParam(name = "offset") int offset){
        final RetrievePaginatedProducts retrievePaginatedProducts = new RetrievePaginatedProducts(limit,offset);
        final ProductsDTO result = queryBus.send(retrievePaginatedProducts);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(value="id") String id){
        final RetrieveProductById retrieveProductById = new RetrieveProductById(id);
        final ProductDTO result = queryBus.send(retrieveProductById);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/name/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductDTO> getProductByName(@PathVariable(value="name") String name){
        final RetrieveProductByName retrieveProductByName = new RetrieveProductByName(name);
        final ProductDTO result = queryBus.send(retrieveProductByName);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteProduct(@PathVariable(value="id") String id){
        final DeleteProductById deleteProductById = new DeleteProductById(id);
        commandBus.send(deleteProductById);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/nutriscore/all", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NutriScoresDTO> getAllNutriScore(){
        final RetrieveNutriScores retrieveNutriScores = new RetrieveNutriScores();
        final NutriScoresDTO result = queryBus.send(retrieveNutriScores);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value ="/nutriscore/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NutriScoreDTO> getNutriScoreById(@PathVariable(value="id") String id){
        final RetrieveNutriScoreById retrieveNutriScoreById = new RetrieveNutriScoreById(id);
        final NutriScoreDTO result = queryBus.send(retrieveNutriScoreById);
        return ResponseEntity.ok(result);
    }
}
