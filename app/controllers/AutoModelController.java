package controllers;

import db.DbExecutionContext;
import models.AutoModel;
import models.AutoModelMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@Singleton
public class AutoModelController extends Controller {

    private HttpExecutionContext httpExecutionContext;
    private DbExecutionContext dbExecutionContext;
    private SqlSessionFactory sqlSessionFactory;

    @Inject
    public AutoModelController(HttpExecutionContext httpExecutionContext, DbExecutionContext dbExecutionContext,
                               SqlSessionFactory sqlSessionFactory) {
        this.httpExecutionContext = httpExecutionContext;
        this.dbExecutionContext = dbExecutionContext;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public CompletionStage<Result> create(Http.Request request) {
        AutoModel autoModel = request.body().parseJson(AutoModel.class).orElse(null);
        if (autoModel != null) {
            return supplyAsync(() -> {
                try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
                    sqlSession.getMapper(AutoModelMapper.class).insert(autoModel);
                    sqlSession.commit();
                    return autoModel.getId();
                }
            }, dbExecutionContext)
                    .thenApplyAsync(sequence -> ok(Long.toString(sequence)), httpExecutionContext);
        } else {
            return supplyAsync(() -> status(404), httpExecutionContext);
        }
    }

    public CompletionStage<Result> read(Long id) {
        return supplyAsync(() -> sqlSessionFactory.openSession().getMapper(AutoModelMapper.class)
                .select(id), dbExecutionContext)
                .thenApplyAsync(shopPosition -> ok(Json.toJson(shopPosition)), httpExecutionContext);
    }

    public CompletionStage<Result> update(Http.Request request) {
        AutoModel autoModel = request.body().parseJson(AutoModel.class).orElse(null);
        return supplyAsync(() -> sqlSessionFactory.openSession().getMapper(AutoModelMapper.class)
                .update(autoModel), dbExecutionContext)
                .thenApplyAsync(count -> count == 1 ? ok() : status(404), httpExecutionContext);
    }

    public CompletionStage<Result> delete(Long id) {
        return supplyAsync(() -> sqlSessionFactory.openSession().getMapper(AutoModelMapper.class)
                .delete(id), dbExecutionContext)
                .thenApplyAsync(count -> count == 1 ? ok() : status(404), httpExecutionContext);
    }
}
