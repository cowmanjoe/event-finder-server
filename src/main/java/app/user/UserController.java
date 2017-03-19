package app.user;

import spark.Response;
import spark.Route;
import app.util.JsonUtil;
import spark.Request;

import java.util.HashMap;

import static app.Main.userService;

/**
 * Created by David on 2017-03-18.
 */
public class UserController {

    public static Route fetchAllUsers = (Request req, Response res) -> userService.getUsers();

}
