package controllers;

import db.DbExecutionContext;
import models.ShopPosition;
import models.ShopPositionMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Singleton;

import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.function.Function;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import static play.mvc.Results.ok;
import static play.mvc.Results.status;

@Singleton
public class ShopPositionController extends Controller {

    HttpExecutionContext httpExecutionContext;
    DbExecutionContext dbExecutionContext;
    SqlSessionFactory sqlSessionFactory;

    @Inject
    public ShopPositionController(HttpExecutionContext httpExecutionContext, DbExecutionContext dbExecutionContext,
                                  SqlSessionFactory sqlSessionFactory) {
        this.httpExecutionContext = httpExecutionContext;
        this.dbExecutionContext = dbExecutionContext;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public CompletionStage<Result> create(Http.Request request) {
        Optional<ShopPosition> person = request.body().parseJson(ShopPosition.class);
        ShopPosition shopPosition = person.orElse(null);
        if (shopPosition != null) {
            return supplyAsync(() -> sqlSessionFactory.openSession().getMapper(ShopPositionMapper.class)
                    .insert(person.get()), dbExecutionContext)
                    .thenApplyAsync(count -> count == 1 ? ok() : status(404), (Executor) httpExecutionContext);
        } else {
            return supplyAsync(() -> status(404), (Executor) httpExecutionContext);
        }
    }

    public Result read(long id) {
        return ok(Json.toJson(2));
    }

    public Result update() {
        return ok(Json.toJson(2));
    }

    public Result delete() {
        return ok(Json.toJson(2));
    }

    public Result search() {
        return ok(Json.toJson(2));
    }
}
