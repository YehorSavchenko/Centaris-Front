package frontend.controllers;

import frontend.services.ItemsService;
import model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.logging.Logger;

@Controller
public class ItemController {

    private final ItemsService itemsService;

    public ItemController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/")
    public String redirect(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String getItemList(Model model){
        model.addAttribute("item1", itemsService.sendGetAllItemsRequest().getItems().get(0));
        model.addAttribute("item2", itemsService.sendGetAllItemsRequest().getItems().get(1));
        model.addAttribute("item3", itemsService.sendGetAllItemsRequest().getItems().get(2));
        return "index";
    }

    @GetMapping("/getItemBaseInfo")
    public String getItemBaseInfo(Model model){
        return "index";
    }

    @GetMapping("/{id}")
    public String getItemInfo(@PathVariable(name = "id") long id, Model model){
        model.addAttribute(id);
        Item item = itemsService.getItemById(id);
        model.addAttribute("item", item);
        return "generic";
    }


    @GetMapping("/login")
    public String goToLogin(){
        return "login";
    }

    @GetMapping("/sing-up")
    public String goToSignUp(){
        return "sing-up";
    }
}
