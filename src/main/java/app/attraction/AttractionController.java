package app.attraction;

import app.index.IndexController;
import app.util.Geometry;
import app.util.JsonUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.*;

import static app.Main.attractionService;

/**
 * Created by Alec on 2017-03-18.
 */
public class AttractionController {

    public static Route fetchAllAttractions = (Request req, Response res) -> attractionService.getAttractions();

    public static Route fetchAttractionsByDistance = (Request req, Response res) -> {
        double latitude = Double.parseDouble(req.queryParams("lat"));
        double longitude = Double.parseDouble(req.queryParams("lon"));
        List<Attraction> attractions = new ArrayList<Attraction>();
        for (Attraction a : attractionService.getAttractions()) {
            attractions.add(a);
        }
        Collections.sort(attractions, new Comparator<Attraction>() {
            public int compare(Attraction a1, Attraction a2) {
                Double dist1 = Geometry.distance(
                        a1.getLatitude(), a1.getLongitude(),
                        latitude, longitude);
                Double dist2 = Geometry.distance(
                        a2.getLatitude(), a2.getLongitude(),
                        latitude, longitude);
                return dist1.compareTo(dist2);
            }
        });

        return attractions;
    };
}
