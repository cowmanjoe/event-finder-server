package app.attraction;

import app.util.JsonUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;

import static app.Main.attractionService;

/**
 * Created by Alec on 2017-03-18.
 */
public class AttractionController {

    public static Route fetchAllAttractions = (Request req, Response res) -> attractionService.getAttractions();

}
