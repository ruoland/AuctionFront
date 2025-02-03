package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ItemStackDTO {
    private String material = "test";
    private int amount = 0;
    private java.util.List<String> lore = new ArrayList<>();
    private Map<String, Integer> enchants = HashMap.newHashMap(1);

    private String sellerId = "1234";
    private double startPrice = 2;
    private double buyPrice = 10;
    private String endTime = "";

}
