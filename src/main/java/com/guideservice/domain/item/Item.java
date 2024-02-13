package com.guideservice.domain.item;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Item {

    private Long id;
    @NotBlank(message = "상품 이름은 필수 입니다.")
    private String itemName;
    @NotBlank(message = "상품 코스는 필수 입니다.")
    private String itemCourse;
    @NotBlank(message = "상품 상세는 필수 입니다.")
    private String detail;
    @NotNull(message = "상품 가격은 필수 입니다.")
    @Min(10000) @Max(100000)
    private Integer price;
    @NotNull(message = "상품 지역을 선택하세요.")
    private List<String> regions;//상품 지역
    @NotNull(message = "판매 여부를 체크해주세요.")
    private Boolean open; //판매 여부
    @NotNull(message = "상품 타입을 선택 해주세요.")
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
