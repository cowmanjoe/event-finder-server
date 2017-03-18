package app.util;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by Alec on 2017-03-18.
 */
public class JsonUtil {

    public static String toJson(Object object) { return new Gson().toJson(object); }

    public static ResponseTransformer json() { return JsonUtil::toJson; }
}
