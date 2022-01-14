package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    public IndexController() {
    }

//    @GetMapping("/index")
//    public String indexPage(){
//        return "index";
//    }

}
