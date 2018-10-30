package main.java.com.codecool.part1;

import java.lang.reflect.InvocationTargetException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class RootControll implements HttpHandler {

    private PageHandling pageHandling;

    RootControll(PageHandling pageHandling) {
        this.pageHandling = pageHandling;
    }

    public void handle(HttpExchange httpExchange) {

        String path = httpExchange.getRequestURI().getPath();
        System.out.println("Path = " + path);
        String firstSegment = getFirstPartOfURI(path);
        System.out.println("firstSegment = " + firstSegment);
        HttpMethod httpMethod = httpExchange.getRequestMethod().equals("GET") ? HttpMethod.GET : HttpMethod.POST;

        Class<PageHandling> aClass = PageHandling.class;

        for (Method method : aClass.getDeclaredMethods()) {


            if (method.isAnnotationPresent(WebRoute.class)) {
                Annotation annotation = method.getAnnotation(WebRoute.class);
                WebRoute webRoute = (WebRoute) annotation;

                if (webRoute.method().equals(httpMethod) && webRoute.path().equals(firstSegment)) {
                    try {
                        method.invoke(pageHandling, httpExchange);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private String getFirstPartOfURI(String path) {
        String[] parts = path.split("/");
        if(parts.length == 0)
            return "/";
        else return "/" + parts[1];

    }
}