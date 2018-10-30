package main.java.com.codecool.part1;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class App {

    public static void main(String[] args) throws Exception {
        PageHandling pageHandling = new PageHandling();
        HttpServer server = HttpServer.create(new InetSocketAddress(8877), 0);
        server.createContext("/", new RootControll(pageHandling));
        server.setExecutor(null);
        server.start();

    }
}