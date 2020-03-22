package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Singleton;

import static play.mvc.Results.ok;

@Singleton
public class AutoModelController extends Controller {
    public Result create() {
        return ok(Json.toJson(2));
    }

    public Result read() {
        return ok(Json.toJson(2));
    }

    public Result update() {
        return ok(Json.toJson(2));
    }

    public Result delete() {
        return ok(Json.toJson(2));
    }
}
