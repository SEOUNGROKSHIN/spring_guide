package com.guideservice.domain;

import com.guideservice.domain.item.Item;
import com.guideservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepository itemRepository;

    /**
     * 더미 데이터 추가
     * */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("제주A" , "제주 둘레길" , 50000));
        itemRepository.save(new Item("제주B" , "제주 낚시" , 100000));

    }
}
