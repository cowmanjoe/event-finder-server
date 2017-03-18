package app.util;

import org.apache.velocity.app.VelocityEngine;
import spark.ModelAndView;
import spark.Request;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Map;

/**
 * Created by Alec on 2017-03-18.
 */
public class ViewUtil {

    public static String render(Request req, Map<String, Object> model, String path) {
        model.put("postAttraction", "/addAttraction");
        ModelAndView modelAndView = new ModelAndView(model, path);
        return strictVelocityEngine().render(modelAndView);
    }

    private static VelocityTemplateEngine strictVelocityEngine() {
        VelocityEngine configuredEngine = new VelocityEngine();
        configuredEngine.setProperty("runtime.references.strict", true);
        configuredEngine.setProperty("resource.loader", "class");
        configuredEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        return new VelocityTemplateEngine(configuredEngine);
    }
}
