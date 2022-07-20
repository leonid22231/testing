package com.example.demo.Controllers;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
@Controller
public class MainController {
    @GetMapping("/Main")
    public String Main() {
        return "index";
    }
    @GetMapping("/Delivery")
    public String Delivery() {
        return "delivery";
    }
    @GetMapping("/Contact")
    public String Contact(){
        return "contact";
    }
    @GetMapping("/About")
    public String About(){
        return "about";

    }
}
