package com.guideservice.domain.web.form;

import com.guideservice.domain.item.Item;
import com.guideservice.domain.item.ItemRepository;
import com.guideservice.domain.item.ItemType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/form/items")
public class FormItemController {

    private final ItemRepository itemRepository;

    @ModelAttribute("regions")
    public Map<String , String> regions() {
        Map<String , String> regions = new LinkedHashMap<>();
        regions.put("JEJU" , "제주");
        regions.put("SEOUL" , "서울");
        return regions;
        }

    @ModelAttribute("itemTypes")
    public ItemType[] itemTypes() {
        return ItemType.values();
    }

    @GetMapping()
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "form/items";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "form/addForm";
    }

    @PostMapping("/add")
    public String addItem(@Validated @ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        //검증에 실패하면 다시 입력 폼으로
        if (bindingResult.hasErrors()) {
            log.info("errors={}" , bindingResult);
            return "form/addForm";
        }
        
        log.info("item.open{}", item.getOpen());
        log.info("item.regions", item.getRegions());
        log.info("item.itemType", item.getItemType());
        
        // 검증 성공시 수행
        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/form/items/{itemId}";
    }
    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId , Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
    return "form/item";
    }
    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable long itemId , Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item" , item);
        return "form/editForm";
    }
    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId , item);
        return "redirect:/form/items/{itemId}";
    }
}
