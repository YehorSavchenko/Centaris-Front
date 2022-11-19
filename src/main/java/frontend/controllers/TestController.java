package frontend.controllers;

import frontend.services.ItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    private final ItemsService itemsService;

    public TestController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/getItemList")
    public String getItemList(Model model){
        model.addAttribute("items", itemsService.sendGetAllItemsRequest());
        return "index";
    }
}
