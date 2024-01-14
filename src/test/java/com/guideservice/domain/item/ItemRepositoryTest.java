package com.guideservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    public void save() {
        Item item = new Item("제주A", "제주 둘레길", "test detail" , 50000);
        item.setItemName("제주 가이드 신승록 입니다");
        item.setItemCourse("제주도 서귀포에서 시작해서 안목해변까지 가는 코스 입니다.");
        item.setPrice(80000);
        System.out.println(item);
    }

}
