package frontend.controllers;

import frontend.services.ItemsService;
import model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class TestController {

    private final ItemsService itemsService;

    public TestController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/")
    public String redirect(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String getItemList(Model model){
        Item item = itemsService.sendGetAllItemsRequest().getItems().get(0);
        System.out.println("chuj:" + item);
        model.addAttribute("item", item);
        return "index";
    }

    @GetMapping("/getItemBaseInfo")
    public String getItemBaseInfo(Model model){
//        Item item = itemsService.sendGetAllItemsRequest().getItems().get(0);
//        System.out.println("chuj:" + item);
//        model.addAttribute("item", item);
        return "index";
    }

    @GetMapping("/generic")
    public String getItemInfo(){
        return "generic";
    }

    @GetMapping("/elements")
    //TODO Nie wiem jak to nazwac
    public String goToElements(){
        return "elements";
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
