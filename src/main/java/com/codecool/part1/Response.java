package main.java.com.codecool.part1;

public class Response {

    public String getClickMe(){
        return "<html>" + "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>Clicker</title>" +
                "</head>" + "<body>"+
                "<br>"+ "<form method=\"POST\">" +
                "<h1>Click Me!!!</h1>" +
                "<input type=\"submit\" value=\"Get click me\">" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public String getClickMeAgain(){
        return "<html>" + "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>Second Clicker</title>" +
                "</head>" + "<body>"+
                "<br>"+ "<form method=\"POST\">" +
                "<h1>Click me Again!!!</h1>" +
                "<input type=\"submit\" value=\"Get click me again\">" +
                "</form>" +
                "</body>" +
                "</html>";

    }
}
