package controllers;

import akka.actor.ActorSystem;
import play.api.libs.concurrent.CustomExecutionContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class HttpExecutionContext extends CustomExecutionContext {

    @Inject
    public HttpExecutionContext(ActorSystem system, String name) {
        super(system, "http-dispatcher");
    }

}
