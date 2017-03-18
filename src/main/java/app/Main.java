package app;

import app.attraction.AttractionController;
import app.attraction.AttractionService;
import app.util.JsonUtil;

import static spark.Spark.*;
/**
 * Created by Alec on 2017-03-18.
 */
public class Main {

    public static AttractionService attractionService;

    public static void main(String[] args) {

        attractionService = new AttractionService();
        port(9859);
        get("/attractions/", AttractionController.fetchAllAttractions, JsonUtil.json());
    }
}
