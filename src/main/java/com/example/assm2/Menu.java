package com.example.assm2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Menu {
    @GetMapping("/View-Menu")
    public String viewMenu() {
        return "Menu/menu";
    }
}
