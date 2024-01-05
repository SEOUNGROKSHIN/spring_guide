package com.guideservice.domain.item;

import lombok.Data;

import java.util.List;

@Data
public class Item {

    private Long id;
    private String itemName;
    private String itemCourse;
    private Integer price;

    private Boolean open;
    private List<String> guideType; //가이드 타입

    public Item() {
    }

    public Item(Long id, String itemName, String itemCourse, Integer price, Boolean open, List<String> regions) {
        this.id = id;
        this.itemName = itemName;
        this.itemCourse = itemCourse;
        this.price = price;
        this.open = open;
        this.guideType = regions;
    }
}
