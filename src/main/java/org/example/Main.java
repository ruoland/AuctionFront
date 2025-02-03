package org.example;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        String apiUrl = "http://localhost:8080/api/items/name/test";
        Gson gson = new Gson();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("요청 성공: " + response.body());
            } else {
                System.out.println("요청 실패: 상태 코드 = " + response.statusCode());
            }
        } catch (IOException e) {
            System.err.println("IO 예외 발생: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("요청이 중단되었습니다: " + e.getMessage());
        }

    }
}