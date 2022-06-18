package com.stockbroker.web.StockBroker;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class NewMainFromScratch {

  public static void main(String[] args) {
  var vertx=  Vertx.vertx();

    HttpServer httpServer = vertx.createHttpServer();
    Router router = Router.router(vertx);
    router.route().handler(routingContext -> {
      HttpServerResponse response = routingContext.response();
      response.putHeader("content-type","text/plain");
      response.end("Hello MR Mohamed From scratch");
    });


    httpServer.requestHandler(router).listen(8080);

  }

}
