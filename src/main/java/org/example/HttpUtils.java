package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpUtils {

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static String sendRequest(String apiUrl, EnumMethod method, String body) throws IOException, InterruptedException {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json");

        switch (method) {
            case POST:
                requestBuilder.POST(HttpRequest.BodyPublishers.ofString(body));
                break;
            case PUT:
                requestBuilder.PUT(HttpRequest.BodyPublishers.ofString(body));
                break;
            case GET:
                requestBuilder.GET();
                break;
            case DELETE:
                requestBuilder.DELETE();
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 HTTP 메서드입니다: " + method);
        }

        // 요청 전송 및 응답 반환
        HttpResponse<String> response = httpClient.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();

        if (statusCode >= 200 && statusCode < 300) {
            return response.body(); // 성공 응답 반환
        } else {
            throw new RuntimeException("HTTP 요청 실패: 상태 코드 = " + statusCode + ", 응답 메시지 = " + response.body());
        }
    }
}
