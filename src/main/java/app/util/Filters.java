package app.util;

import spark.Filter;
import spark.Request;
import spark.Response;

/**
 * Created by Alec on 2017-03-18.
 */
public class Filters {

    public static Filter addTrailingSlashes = (Request req, Response res) -> {
        if (!req.pathInfo().endsWith("/")) {
            res.redirect(req.pathInfo() + "/");
        }
    };
}
