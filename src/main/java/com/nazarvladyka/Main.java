//package com.nazarvladyka;
//
//import com.nazarvladyka.domain.Hero;
//import org.springframework.web.client.RestTemplate;
//
////
////import com.nazarvladyka.domain.Hero;
////import org.springframework.web.client.RestTemplate;
////
//////
//////import jdk.nashorn.internal.parser.JSONParser;
//////import org.json.JSONObject;
//////
//////import java.io.IOException;
//////import java.io.InputStream;
//////import java.net.HttpURLConnection;
//////import java.net.MalformedURLException;
//////import java.net.URL;
//////import java.util.Scanner;
//public class Main {
////////    public static void main(String[] args) {
////////        System.out
////////                .println(jsonGetRequest("https://swapi.co/api/people/?search=Luke%20Skywalker&format=json"));
////////    }
////////
////////    private static String streamToString(InputStream inputStream) {
////////        String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
////////        return text;
////////    }
////////
////////    public static String jsonGetRequest(String urlQueryString) {
////////        String json = null;
////////        try {
////////            URL url = new URL(urlQueryString);
////////            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
////////            connection.setDoOutput(true);
////////            connection.setInstanceFollowRedirects(false);
////////            connection.setRequestMethod("GET");
////////            connection.setRequestProperty("Content-Type", "application/json");
////////            connection.setRequestProperty("charset", "utf-8");
////////            connection.connect();
////////            InputStream inStream = connection.getInputStream();
////////            json = streamToString(inStream); // input stream to string
////////        } catch (IOException ex) {
////////            ex.printStackTrace();
////////        }
////////        return json;
////////    }
//////    public static void main(String[] args) throws IOException {
//////        URL url = new URL("https://swapi.co/api/people/?search=Luke%20Skywalker&format=json");
//////        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//////        conn.setRequestMethod("GET");
//////        conn.setRequestProperty("Content-Type", "application/json");
//////        conn.setRequestProperty("charset", "utf-8");
//////        conn.connect();
//////
//////        String inline = "";
//////        Scanner sc = new Scanner(url.openStream());
//////        while(sc.hasNext())
//////        {
//////            inline += sc.nextLine();
//////        }
//////        System.out.println("\nJSON data in string format");
//////        System.out.println(inline);
//////        JSONParser parse = new JSONParser();
//////        JSONObject jobj = (JSONObject)parse.parse(inline);
//////
//////        sc.close();
//////    }
//public static void main(String[] args) {
//    RestTemplate restTemplate = new RestTemplate();
//    Hero hero = restTemplate.getForObject("https://swapi.co/api/people/1", Hero.class);
//    hero = restTemplate.getForObject("https://swapi.co/api/people/2", Hero.class);
//
//    System.out.println(hero);
//}
//
//
//}
////
