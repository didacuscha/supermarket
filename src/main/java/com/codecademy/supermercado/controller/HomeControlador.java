package com.codecademy.supermercado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControlador {
    @GetMapping("/")
    public String redirectToUsuarios() {
        return "redirect:/usuarios";
    }

    @RequestMapping("/**")
    public String handleNotFound() {
        return "redirect:/usuarios";
    }
}
