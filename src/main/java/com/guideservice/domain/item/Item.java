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

    private Boolean open; //판매 여부
    private List<String> guideType; //가이드 타입

    public Item() {
    }

    public Item(String itemName, String itemCourse, Integer price) {
        this.itemName = itemName;
        this.itemCourse = itemCourse;
        this.price = price;
    }

}
