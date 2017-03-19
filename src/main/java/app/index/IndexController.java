package app.index;

import app.Main;
import app.attraction.Attraction;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static app.Main.attractionService;

/**
 * Created by Alec on 2017-03-18.
 */
public class IndexController {

    public static Route serveIndexPage = (Request req, Response res) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("businesses", Main.attractionService.getAttractions());
        return ViewUtil.render(req, model, "/views/index.vm");
    };

    public static Route addNewAttraction = (Request req, Response res) -> {
        attractionService.createAttraction(
                req.queryParams("name"),
                Float.parseFloat(req.queryParams("latitude")),
                Float.parseFloat(req.queryParams("longitude")),
                Attraction.Type.valueOf(req.queryParams("type")),
                req.queryParams("description")
        );
        return IndexController.serveIndexPage.handle(req, res);
    };
}
