package com.stockbroker.web.StockBroker.assets;

import com.stockbroker.web.StockBroker.MainVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AssetRestApi {
  private static final Logger LOG = LoggerFactory.getLogger(AssetRestApi.class);

  public static void attach(Router parent){
    parent.get("/assets").handler(contex ->{
      final JsonArray response = new JsonArray();
      response
        .add(new JsonObject().put("1","AXD"))
        .add(new JsonObject().put("2","EXE"))
        .add(new JsonObject().put("3","QWE"))
        .add(new JsonObject().put("4","RTY"));
      LOG.info("path {} respond with {} " ,contex.normalizedPath() , response.encode());
contex.response().end(response.toBuffer());
    });

  }
}
