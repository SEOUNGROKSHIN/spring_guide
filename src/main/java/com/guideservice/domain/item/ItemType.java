package com.guideservice.domain.item;

public enum ItemType {

    Professional("전문가이드") , Local("현지가이드") , Guide("일반가이드");

    private final String description;

    ItemType(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
