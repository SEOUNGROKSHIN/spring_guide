package com.guideservice.domain.item;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

@Component
public class ItemValidation {

    public void validate(Object target, Errors errors) {

        Item item = (Item) target;

        // 상품 이름은 필수 입니다.
        if (!StringUtils.hasText(item.getItemName())) {
            errors.rejectValue("itemName", "required.item.itemName");
        }
        // 상품 코스이름은 필수 입니다.
        if(!StringUtils.hasText(item.getItemCourse())) {
            errors.rejectValue("itemCourse", "required.item.itemCourse");
        }
        // 상품 상세는 필수 입니다.
        if(!StringUtils.hasText(item.getDetail())) {
            errors.rejectValue("detail", "required.item.detail");
        }
        // 가격은 10000 이상 10만원 이하
        if(item.getPrice() == null || item.getPrice() <= 10000 || item.getPrice() >= 100000)
            errors.rejectValue("price", "range.item.price" , new Object[]{10000, 100000}, null);


    }
}
