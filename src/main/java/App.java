import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/cookbooks.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/about", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/about.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
