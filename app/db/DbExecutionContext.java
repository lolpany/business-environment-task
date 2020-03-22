package db;

import akka.actor.ActorSystem;
import play.api.libs.concurrent.CustomExecutionContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DbExecutionContext extends CustomExecutionContext {

    @Inject
    public DbExecutionContext(ActorSystem system, String name) {
        super(system, "db-dispatcher");
    }

}
