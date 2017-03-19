package app.user;

import app.util.ViewUtil;
import spark.Response;
import spark.Route;
import app.util.JsonUtil;
import spark.Request;

import java.util.HashMap;
import java.util.Map;

import static app.Main.userService;

/**
 * Created by David on 2017-03-18.
 */
public class UserController {

    public static Route fetchAllUsers = (Request req, Response res) -> userService.getUsers();

    public static Route addNewUser = (Request req, Response res) -> {
        if (userService.addUser(req.queryParams("username"))) {
            Map<String, Object> model = new HashMap<>();
            model.put("userAdded", true);
            model.put("userAddFailed", false);
            return ViewUtil.render(req, model, "/views/addUser.vm");
        }
        else {
            Map<String, Object> model = new HashMap<>();
            model.put("userAdded", false);
            model.put("userAddFailed", true);
            return ViewUtil.render(req, model, "/views/addUser.vm");
        }
    };


    public static Route serveAddUserPage(boolean userAdded, boolean userAddFailed) {
        Map<String, Object> model = new HashMap<>();
        model.put("userAdded", userAdded);
        model.put("userAddFailed", userAddFailed);
        return (Request req, Response res) -> ViewUtil.render(req, model, "/views/addUser.vm");
    }

}
