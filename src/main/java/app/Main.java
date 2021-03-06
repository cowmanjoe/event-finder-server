package app;

import app.attraction.AttractionController;
import app.attraction.AttractionService;
import app.index.IndexController;
import app.user.UserController;
import app.user.UserService;
import app.util.Filters;
import app.util.JsonUtil;

import static spark.Spark.*;
/**
 * Created by Alec on 2017-03-18.
 */
public class Main {

    public static AttractionService attractionService;
    public static UserService userService;

    public static void main(String[] args) {
	    userService = new UserService();
        attractionService = new AttractionService();



	    port(9859);

	    before("*", Filters.addTrailingSlashes);

        get("/attractions/", AttractionController.fetchAllAttractions, JsonUtil.json());
        get("/attractionsNear/", AttractionController.fetchAttractionsByDistance, JsonUtil.json()); 

        get("/index/", IndexController.serveIndexPage);
        post("/index/", IndexController.addNewAttraction);

        get("/users/", UserController.fetchAllUsers, JsonUtil.json());

        get("/addUser/", UserController.serveAddUserPage(false, false));
        post("/addUser/", UserController.addNewUser);
    }
}
