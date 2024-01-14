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
        itemRepository.save(new Item("제주A" , "제주 둘레길" , "제주 둘레길은 제주도를 한 바퀴 도는 산책로를 의미합니다. 이 둘레길은 제주도의 아름다운 자연경관과 다양한 명소들을 경험하며 걷는 즐거움을 제공합니다. 아래는 제주 둘레길의 주요 특징과 몇 가지 추천 지점입니다." , 50000));
        itemRepository.save(new Item("제주B" , "제주 낚시" , "제주는 다양한 낚시 체험을 즐길 수 있는 지역으로 유명합니다. 아름다운 해안선과 풍부한 어종들이 낚시를 즐기기에 좋은 환경을 제공하고 있습니다. 여기에는 몇 가지 제주에서 즐길 수 있는 주요 낚시 활동과 관련된 정보가 있습니다." , 100000));

    }
}
