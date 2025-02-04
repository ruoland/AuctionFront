package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


public class Main {

    static Gson gson = new Gson();

    public static void main(String[] args) {
        // 입찰 테스트
        bidItem(UUID.randomUUID().toString(), 20300);

        // 최근 아이템 조회 테스트
        List<Item> items = getRecentItems();
        items.forEach(item -> System.out.println("최근 등록된 아이템: " + item.getMaterial()));
    }
    public static void bidItem(String userId, double price) {
        String apiUrl = "http://localhost:8080/api/items/67a1aea6087af53906b7e0a8/bid";
        BidRequest bidRequest = new BidRequest(userId, price);

        try {
            String responseBody = HttpUtils.sendRequest(apiUrl, EnumMethod.POST, gson.toJson(bidRequest));
            Item item = gson.fromJson(responseBody, Item.class);
            System.out.println("현재 입찰가: " + item.getCurrentBid());
        } catch (IOException | InterruptedException e) {
            System.err.println("입찰 요청 실패: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("서버 오류: " + e.getMessage());
        }
    }

    public static void addItems(Item item) {
        String apiUrl = "http://localhost:8080/api/items";

        try {
            HttpUtils.sendRequest(apiUrl, EnumMethod.POST, gson.toJson(item));
            System.out.println("아이템이 성공적으로 추가되었습니다.");
        } catch (IOException | InterruptedException e) {
            System.err.println("아이템 추가 실패: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("서버 오류: " + e.getMessage());
        }
    }
    public static List<Item> getRecentItems() {
        String apiUrl = "http://localhost:8080/api/items/get/recent";
        try {
            String responseBody = HttpUtils.sendRequest(apiUrl, EnumMethod.GET, null);
            Type listType = new TypeToken<List<Item>>() {}.getType();
            return gson.fromJson(responseBody, listType);
        } catch (IOException | InterruptedException e) {
            System.err.println("최근 아이템 조회 실패: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("서버 오류: " + e.getMessage());
        }

        return Collections.emptyList();
    }

    public static List<Item> getItemsByName(String material) {
        String apiUrl = "http://localhost:8080/api/items/get/material/" + material;

        try {
            String responseBody = HttpUtils.sendRequest(apiUrl, EnumMethod.GET, null);
            Type listType = new TypeToken<List<Item>>() {}.getType();
            return gson.fromJson(responseBody, listType);
        } catch (IOException | InterruptedException e) {
            System.err.println("아이템 검색 실패: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("서버 오류: " + e.getMessage());
        }

        return Collections.emptyList();
    }

}
