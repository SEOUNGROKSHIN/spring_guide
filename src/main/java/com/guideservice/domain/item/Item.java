package com.guideservice.domain.item;

import lombok.Data;

import java.util.List;

@Data
public class Item {

    private Long id;
    private String itemName;
    private String itemCourse;

    private String detail;
    private Integer price;
    private List<String> regions;//상품 지역
    private Boolean open; //판매 여부
    private ItemType itemType; // 상품 타입
    public Item() {
    }

    public Item(String itemName, String itemCourse, String detail , Integer price) {
        this.itemName = itemName;
        this.detail = detail;
        this.itemCourse = itemCourse;
        this.price = price;
    }

}
