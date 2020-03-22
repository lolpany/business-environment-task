package controllers;

import db.DbExecutionContext;
import models.ShopPosition;
import models.ShopPositionMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@Singleton
public class ShopPositionController extends Controller {

    private HttpExecutionContext httpExecutionContext;
    private DbExecutionContext dbExecutionContext;
    private SqlSessionFactory sqlSessionFactory;

    @Inject
    public ShopPositionController(HttpExecutionContext httpExecutionContext, DbExecutionContext dbExecutionContext,
                                  SqlSessionFactory sqlSessionFactory) {
        this.httpExecutionContext = httpExecutionContext;
        this.dbExecutionContext = dbExecutionContext;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @BodyParser.Of(BodyParser.Json.class)
    public CompletionStage<Result> create(Http.Request request) {
        Optional<ShopPosition> person = request.body().parseJson(ShopPosition.class);
        ShopPosition shopPosition = person.orElse(null);
        if (shopPosition != null) {
            return supplyAsync(() -> {
                try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
                    sqlSession.getMapper(ShopPositionMapper.class).insert(person.get());
                    sqlSession.commit();
                    return person.get().getId();
                }
            }, dbExecutionContext)
                    .thenApplyAsync(sequence -> ok(Long.toString(sequence)), httpExecutionContext);
        } else {
            return supplyAsync(() -> status(404), httpExecutionContext);
        }
    }

    public CompletionStage<Result> read(Long id) {
        return supplyAsync(() -> sqlSessionFactory.openSession().getMapper(ShopPositionMapper.class)
                .select(id), dbExecutionContext)
                .thenApplyAsync(shopPosition -> ok(Json.toJson(shopPosition)), httpExecutionContext);
    }

    public Result update(Http.Request request) {
        return ok(Json.toJson(2));
    }

    public Result delete(Long id) {
        return ok(Json.toJson(2));
    }

    public Result search() {
        return ok(Json.toJson(2));
    }
}
