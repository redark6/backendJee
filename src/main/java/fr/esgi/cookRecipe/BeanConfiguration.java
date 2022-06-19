package fr.esgi.cookRecipe;

import fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.commands.AddProduct;
import fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.commands.AddProductCommandHandler;
import fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.commands.DeleteProductById;
import fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.commands.DeleteProductHandler;
import fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries.*;
import fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.commands.AddRecipe;
import fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.commands.AddRecipeHandler;
import fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries.*;
import fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.commands.*;
import fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.queries.RetrieveRecipesSocial;
import fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.queries.RetrieveRecipesSocialHandler;
import fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.commands.*;
import fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.queries.*;
import fr.esgi.cookRecipe.Domain.Util.Service.MeasureUniteService;
import fr.esgi.cookRecipe.Domain.Product.Service.NutriScoreService;
import fr.esgi.cookRecipe.Domain.Product.Service.ProductService;
import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Domain.Social.Service.*;
import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
import kernel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class BeanConfiguration {
/*
    private final ApplicationContext context;

    @Autowired
    public BeanConfiguration(ApplicationContext context){
        this.context = context;
    }

    public UserAccountService userAccountService() {
        return this.context.getBean(UserAccountService.class);
    }

    public MeasureUniteService measureUniteService() {
        return this.context.getBean(MeasureUniteService.class);
    }

    public NutriScoreService nutriScoreService() {
        return this.context.getBean(NutriScoreService.class);
    }

    public ProductService productService() {
        return this.context.getBean(ProductService.class);
    }

    public RecipeService recipeService() {
        return this.context.getBean(RecipeService.class);
    }

    public CategoryService categoryService() {
        return this.context.getBean(CategoryService.class);
    }

    public CommentService commentService() {
        return this.context.getBean(CommentService.class);
    }

    public LikeService likeService() {
        return this.context.getBean(LikeService.class);
    }

    public RateService rateService() {
        return this.context.getBean(RateService.class);
    }

    public UserCommentRecipeService userCommentRecipeService() {
        return this.context.getBean(UserCommentRecipeService.class);
    }

    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        //listenerMap.put(CreateUserEvent.class, List.of(new CreateUserEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();

        commandHandlerMap.put(AddProduct.class, new AddProductCommandHandler(productService(),nutriScoreService(),measureUniteService()));
        commandHandlerMap.put(DeleteProductById.class, new DeleteProductHandler(productService()));

        commandHandlerMap.put(AddRecipe.class, new AddRecipeHandler(productService(),recipeService(),userAccountService()));

        commandHandlerMap.put(AddCommentRecipe.class, new AddCommentRecipeHandler(commentService(),userCommentRecipeService()));
        commandHandlerMap.put(DeleteCommentRecipe.class, new DeleteCommentRecipeHandler(commentService(),userCommentRecipeService()));
        commandHandlerMap.put(LikeRecipe.class, new LikeRecipeHandler(likeService(), recipeService()));
        commandHandlerMap.put(RateRecipe.class, new RateRecipeHandler(rateService(),categoryService(),recipeService()));
        commandHandlerMap.put(UnlikeRecipe.class, new UnlikeRecipeHandler(likeService(), recipeService()));

        commandHandlerMap.put(CreateAccount.class, new CreateAccountHandler(userAccountService()));
        commandHandlerMap.put(UpdateMail.class, new UpdateMailHandler(userAccountService()));
        commandHandlerMap.put(UpdatePassword.class, new UpdatePasswordHandler(userAccountService()));

        return new SimpleCommandBus(commandHandlerMap);
    }

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap = new HashMap<>();

        queryHandlerMap.put(RetrieveMostResearchedProductsByName.class, new RetrieveMostResearchedProductsByNameHandler(productService()));
        queryHandlerMap.put(RetrieveNeverResearchedProductsByName.class, new RetrieveNeverResearchedProductsByNameHandler(productService()));
        queryHandlerMap.put(RetrieveNutriScoreById.class, new RetrieveNutriScoreByIdHandler(nutriScoreService()));
        queryHandlerMap.put(RetrieveNutriScores.class, new RetrieveNutriScoresHandler(nutriScoreService()));
        queryHandlerMap.put(RetrieveProductById.class, new RetrieveProductByIdHandler(productService()));
        queryHandlerMap.put(RetrieveProducts.class, new RetrieveProductsHandler(productService()));
        queryHandlerMap.put(RetrieveProductsByName.class, new RetrieveProductsByNameHandler(productService()));

        queryHandlerMap.put(RetrieveMostResearchedRecipesByName.class, new RetrieveMostResearchedRecipesByNameHandler(recipeService()));
        queryHandlerMap.put(RetrieveNeverResearchedRecipesByName.class, new RetrieveNeverResearchedRecipesByNameHandler(recipeService()));
        queryHandlerMap.put(RetrieveRecipeById.class, new RetrieveRecipeByIdHandler(recipeService()));
        queryHandlerMap.put(RetrieveRecipes.class, new RetrieveRecipesHandler(recipeService()));
        queryHandlerMap.put(RetrieveRecipesByName.class, new RetrieveRecipesByNameHandler(recipeService()));
        queryHandlerMap.put(RetrieveRecipesByProductId.class, new RetrieveRecipesByProductIdHandler(recipeService()));
        queryHandlerMap.put(RetrieveRecipesByProductName.class, new RetrieveRecipesByProductNameHandler(recipeService()));
        queryHandlerMap.put(RetrieveRecipesByUserId.class, new RetrieveRecipesByUserIdHandler(userAccountService()));

        queryHandlerMap.put(RetrieveRecipesSocial.class, new RetrieveRecipesSocialHandler(rateService(),categoryService(),recipeService(),commentService(),userCommentRecipeService()));

        queryHandlerMap.put(RetrieveUserById.class, new RetrieveUserByIdHandler(userAccountService()));
        queryHandlerMap.put(RetrieveUserMe.class, new RetrieveUserMeHandler(userAccountService()));
        queryHandlerMap.put(RetrieveUsersByUserNameLike.class, new RetrieveUsersByUserNameLikeHandler(userAccountService()));

        return new SimpleQueryBus(queryHandlerMap);
    }
 */
}
