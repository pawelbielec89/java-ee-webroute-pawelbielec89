package main.java.com.codecool.part1;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public class Redirect {

    public void redirectToPath(HttpExchange httpExchange, String path) throws IOException {
        httpExchange.getResponseHeaders().add("Location", path);
        httpExchange.sendResponseHeaders(301, -1);
    }
}
