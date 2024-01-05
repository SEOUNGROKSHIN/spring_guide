package com.guideservice.domain.item;

import org.junit.jupiter.api.AfterEach;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }


}
