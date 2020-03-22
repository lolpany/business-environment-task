package controllers;

import db.DbExecutionContext;
import models.AutoMark;
import models.AutoMarkMapper;
import models.ShopPosition;
import models.ShopPositionMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Singleton;

import java.util.Optional;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import static play.mvc.Results.ok;

@Singleton
public class AutoMarkController  extends Controller  {

    private HttpExecutionContext httpExecutionContext;
    private DbExecutionContext dbExecutionContext;
    private SqlSessionFactory sqlSessionFactory;

    @Inject
    public AutoMarkController(HttpExecutionContext httpExecutionContext, DbExecutionContext dbExecutionContext,
                                  SqlSessionFactory sqlSessionFactory) {
        this.httpExecutionContext = httpExecutionContext;
        this.dbExecutionContext = dbExecutionContext;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public CompletionStage<Result> create(Http.Request request) {
        AutoMark autoMark = request.body().parseJson(AutoMark.class).orElse(null);
        if (autoMark != null) {
            return supplyAsync(() -> {
                try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
                    sqlSession.getMapper(AutoMarkMapper.class).insert(autoMark);
                    sqlSession.commit();
                    return autoMark.getId();
                }
            }, dbExecutionContext)
                    .thenApplyAsync(sequence -> ok(Long.toString(sequence)), httpExecutionContext);
        } else {
            return supplyAsync(() -> status(404), httpExecutionContext);
        }
    }

    public CompletionStage<Result> read(Long id) {
        return supplyAsync(() -> sqlSessionFactory.openSession().getMapper(AutoMarkMapper.class)
                .select(id), dbExecutionContext)
                .thenApplyAsync(shopPosition -> ok(Json.toJson(shopPosition)), httpExecutionContext);
    }

    public CompletionStage<Result> update(Http.Request request) {
        AutoMark autoMark = request.body().parseJson(AutoMark.class).orElse(null);
        return supplyAsync(() -> sqlSessionFactory.openSession().getMapper(AutoMarkMapper.class)
                .update(autoMark), dbExecutionContext)
                .thenApplyAsync(count -> count == 1 ? ok() : status(404), httpExecutionContext);
    }

    public CompletionStage<Result> delete(Long id) {
        return supplyAsync(() -> sqlSessionFactory.openSession().getMapper(AutoMarkMapper.class)
                .delete(id), dbExecutionContext)
                .thenApplyAsync(count -> count == 1 ? ok() : status(404), httpExecutionContext);
    }
}
