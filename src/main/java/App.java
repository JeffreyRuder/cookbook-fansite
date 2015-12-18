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

    get("/contact", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/contact.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/receipt", (request, response) -> {
      HashMap model = new HashMap();
      String title = request.queryParams("title");
      String author = request.queryParams("author");

      model.put("title", title);
      model.put("author", author);
      model.put("template", "templates/receipt.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/receipt2", (request, response) -> {
      HashMap model = new HashMap();
      String rating = request.queryParams("rating");

      model.put("rating", rating);
      model.put("template", "templates/receipt2.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/receipt3", (request, response) -> {
      HashMap model = new HashMap();
      String email = request.queryParams("email");

      model.put("email", email);
      model.put("template", "templates/receipt3.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
