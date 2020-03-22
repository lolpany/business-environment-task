package db;

import akka.actor.ActorSystem;
import play.api.libs.concurrent.CustomExecutionContext;

import javax.inject.Singleton;

@Singleton
public class DbExecutionContext extends CustomExecutionContext {

    public DbExecutionContext(ActorSystem system, String name) {
        super(system, "db-dispatcher");
    }

}
