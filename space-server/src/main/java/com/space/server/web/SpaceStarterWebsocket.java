package com.space.server.web;

import org.eclipse.jetty.websocket.api.Session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static spark.Spark.*;

/**
 * Starts the space websocket server component
 * Created by superernie77 on 26.10.2016.
 */

public class SpaceStarterWebsocket {

    // maps the websocket session against the space player id
    static Map<Session, Integer> userUsernameMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        port(8080);

        staticFileLocation("/static");
        staticFiles.expireTime(600L);

		webSocket("/api", SpaceWebsocketHandler.class);

        init();
    }
}