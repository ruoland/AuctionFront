package org.example;


import java.util.*;

public class Item {


    private Long id;

    private String material; // 아이템 종류 (예: DIAMOND_SWORD)

    private int amount; // 아이템 개수


    private List<String> lore; // 아이템 설명 (Lore)


    private Map<String, Integer> enchants; // 인첸트 정보 (예: {DAMAGE_ALL=5})

    private User seller;

    private double startPrice; // 경매 시작 가격

    private double buyPrice; // 즉시 구매 가격

    private String endTime; // 경매 종료 시간 (ISO 8601 형식)
}
