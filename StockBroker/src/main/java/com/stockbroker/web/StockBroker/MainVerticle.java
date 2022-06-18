package com.stockbroker.web.StockBroker;


import com.stockbroker.web.StockBroker.assets.AssetRestApi;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainVerticle extends AbstractVerticle {
  private static final Logger LOG = LoggerFactory.getLogger(MainVerticle.class);
  public static void main(String[] args) {
    var vertx=Vertx.vertx();
    vertx.exceptionHandler(error ->{
      LOG.error("Unhandled: {}",error);
    });
    vertx.deployVerticle(new MainVerticle(), ar ->{
      if(ar.failed()){
        LOG.error("Fail in deploying {}",ar.cause());
      }
      LOG.info("Deployed : {}",MainVerticle.class.getName());

    });

  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    final Router route = Router.router(vertx);
    AssetRestApi.attach(route);


    vertx.createHttpServer().requestHandler(route)
      .exceptionHandler(error -> LOG.error("HHTP SERVER ERROR : ", error))
      .listen(8888, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server started on port 8888");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }
}
