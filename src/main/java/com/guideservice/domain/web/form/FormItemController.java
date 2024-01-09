package com.guideservice.domain.web.form;

import com.guideservice.domain.item.Item;
import com.guideservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class FormItemController {

    private final ItemRepository itemRepository;

    @GetMapping("/form/items")
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items" , items);

        return "form/items";
    }
}
