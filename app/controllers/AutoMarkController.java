package controllers;

import play.libs.Json;
import play.mvc.Result;

import static play.mvc.Results.ok;

public class AutoMarkController {

    public Result create() {
        return ok(Json.toJson());
    }

    public Result read() {
        return ok(Json.toJson());
    }

    public Result update() {
        return ok(Json.toJson());
    }

    public Result delete() {
        return ok(Json.toJson());
    }
}