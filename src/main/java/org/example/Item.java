package org.example;

import java.util.List;
import java.util.Map;

public class Item {
    private String id; // MongoDB의 _id 필드
    private String material="test"; // 아이템 종류
    private int amount=0; // 아이템 개수
    private List<String> lore; // 아이템 설명
    private Map<String, Integer> enchants; // 인첸트 정보
    private double startPrice=2; // 경매 시작 가격
    private double currentBid = startPrice;// 입찰 가격
    private double buyPrice=20; // 즉시 구매 가격
    private String userId;
    private String displayName;

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    // Getter와 Setter (Lombok 사용 가능)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<String> getLore() {
        return lore;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    public Map<String, Integer> getEnchants() {
        return enchants;
    }

    public void setEnchants(Map<String, Integer> enchants) {
        this.enchants = enchants;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }
}
