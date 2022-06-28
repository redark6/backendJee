package fr.esgi.cookRecipe;

import fr.esgi.cookRecipe.application.productQueriesCommandsEvents.commands.AddProduct;
import fr.esgi.cookRecipe.application.productQueriesCommandsEvents.commands.AddProductCommandHandler;
import fr.esgi.cookRecipe.application.productQueriesCommandsEvents.commands.DeleteProductById;
import fr.esgi.cookRecipe.application.productQueriesCommandsEvents.commands.DeleteProductHandler;
import fr.esgi.cookRecipe.application.productQueriesCommandsEvents.queries.*;
import fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.commands.AddRecipe;
import fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.commands.AddRecipeHandler;
import fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.queries.*;
import fr.esgi.cookRecipe.application.socialQueriesCommandsEvents.commands.*;
import fr.esgi.cookRecipe.application.socialQueriesCommandsEvents.queries.RetrieveRecipesSocial;
import fr.esgi.cookRecipe.application.socialQueriesCommandsEvents.queries.RetrieveRecipesSocialHandler;
import fr.esgi.cookRecipe.application.userQueriesCommandsEvents.commands.*;
import fr.esgi.cookRecipe.application.userQueriesCommandsEvents.queries.*;
import fr.esgi.cookRecipe.domain.util.service.LogService;
import fr.esgi.cookRecipe.domain.util.service.MeasureUniteService;
import fr.esgi.cookRecipe.domain.product.service.NutriScoreService;
import fr.esgi.cookRecipe.domain.product.service.ProductService;
import fr.esgi.cookRecipe.domain.recipe.service.RecipeService;
import fr.esgi.cookRecipe.domain.social.service.*;
import fr.esgi.cookRecipe.domain.user.service.UserAccountService;
import kernel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class BeanConfiguration {

    @Autowired private DataSource dataSource;

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager() {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

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

    public LogService logService() {
        return this.context.getBean(LogService.class);
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

        commandHandlerMap.put(AddProduct.class, new AddProductCommandHandler(productService(),nutriScoreService(),measureUniteService(), logService()));
        commandHandlerMap.put(DeleteProductById.class, new DeleteProductHandler(productService()));

        commandHandlerMap.put(AddRecipe.class, new AddRecipeHandler(productService(),recipeService(),userAccountService(), logService()));

        commandHandlerMap.put(AddCommentRecipe.class, new AddCommentRecipeHandler(userAccountService(),commentService(),recipeService()));
        commandHandlerMap.put(DeleteCommentRecipe.class, new DeleteCommentRecipeHandler(commentService()));
        commandHandlerMap.put(LikeRecipe.class, new LikeRecipeHandler(likeService(), recipeService(), userAccountService()));
        commandHandlerMap.put(RateRecipe.class, new RateRecipeHandler(rateService(),categoryService(),recipeService(), userAccountService()));

        commandHandlerMap.put(CreateAccount.class, new CreateAccountHandler(userAccountService()));
        commandHandlerMap.put(UpdateMail.class, new UpdateMailHandler(userAccountService()));
        commandHandlerMap.put(UpdatePassword.class, new UpdatePasswordHandler(userAccountService()));

        return new SimpleCommandBus(commandHandlerMap);
    }

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap = new HashMap<>();

        queryHandlerMap.put(RetrieveMostResearchedProductsByName.class, new RetrieveMostResearchedProductsByNameHandler(logService()));
        queryHandlerMap.put(RetrieveNeverResearchedProductsByName.class, new RetrieveNeverResearchedProductsByNameHandler(logService()));
        queryHandlerMap.put(RetrieveNutriScoreById.class, new RetrieveNutriScoreByIdHandler(nutriScoreService()));
        queryHandlerMap.put(RetrieveNutriScores.class, new RetrieveNutriScoresHandler(nutriScoreService()));
        queryHandlerMap.put(RetrieveProductById.class, new RetrieveProductByIdHandler(productService(), logService(), userAccountService()));
        queryHandlerMap.put(RetrieveProducts.class, new RetrieveProductsHandler(productService()));
        queryHandlerMap.put(RetrieveProductsByName.class, new RetrieveProductsByNameHandler(productService()));

        queryHandlerMap.put(RetrieveMostResearchedRecipesByName.class, new RetrieveMostResearchedRecipesByNameHandler(logService()));
        queryHandlerMap.put(RetrieveNeverResearchedRecipesByName.class, new RetrieveNeverResearchedRecipesByNameHandler(logService()));
        queryHandlerMap.put(RetrieveRecipeById.class, new RetrieveRecipeByIdHandler(recipeService(), logService(), userAccountService()));
        queryHandlerMap.put(RetrieveRecipes.class, new RetrieveRecipesHandler(recipeService()));
        queryHandlerMap.put(RetrieveRecipesByName.class, new RetrieveRecipesByNameHandler(recipeService()));
        queryHandlerMap.put(RetrieveRecipesByProductId.class, new RetrieveRecipesByProductIdHandler(recipeService()));
        queryHandlerMap.put(RetrieveRecipesByProductName.class, new RetrieveRecipesByProductNameHandler(recipeService()));
        queryHandlerMap.put(RetrieveRecipesByUserId.class, new RetrieveRecipesByUserIdHandler(userAccountService(), recipeService()));

        queryHandlerMap.put(RetrieveRecipesSocial.class, new RetrieveRecipesSocialHandler(rateService(),categoryService(),recipeService(),commentService(), likeService(), userAccountService()));

        queryHandlerMap.put(RetrieveUserById.class, new RetrieveUserByIdHandler(userAccountService(), recipeService(), commentService()));
        queryHandlerMap.put(RetrieveUserMe.class, new RetrieveUserMeHandler(userAccountService(), recipeService(), commentService()));
        queryHandlerMap.put(RetrieveUsersByUserNameLike.class, new RetrieveUsersByUserNameLikeHandler(userAccountService()));

        return new SimpleQueryBus(queryHandlerMap);
    }

}
