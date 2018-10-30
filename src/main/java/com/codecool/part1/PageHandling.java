package main.java.com.codecool.part1;

import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.io.OutputStream;


public class PageHandling {

    String response;
    Redirect redirect = new Redirect();
    Response generateResponse = new Response();

    @WebRoute(method = HttpMethod.GET, path = "/clickMe")
    void handleGetClickMe(HttpExchange httpExchange) throws IOException {
        response = generateResponse.getClickMe();
        sendResponse(httpExchange);
    }

    @WebRoute(method = HttpMethod.GET, path = "/clickMeAgain")
    void handleGetClickMeAgain(HttpExchange httpExchange) throws IOException {
        response = generateResponse.getClickMeAgain();
        sendResponse(httpExchange);
    }

    @WebRoute(method = HttpMethod.POST, path = "/clickMe")
    void handlePostClickMe(HttpExchange httpExchange) throws IOException {
        redirect.redirectToPath(httpExchange, "/clickMeAgain");
    }

    @WebRoute(method = HttpMethod.POST, path = "/clickMeAgain")
    void handlePostClickMeAgain(HttpExchange httpExchange) throws IOException {
        redirect.redirectToPath(httpExchange, "/clickMe");
    }

    void sendResponse(HttpExchange httpExchange) throws IOException {
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}