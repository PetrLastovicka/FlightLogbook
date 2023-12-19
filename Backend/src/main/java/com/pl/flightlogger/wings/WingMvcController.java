package com.pl.flightlogger.wings;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mvc/wings")
@RequiredArgsConstructor
public class WingMvcController {
    private final WingService wingService;
    @GetMapping
    public String allWings(Model model) {
        model.addAttribute("wings", wingService.getAll());
        return "wings";

    }
    @GetMapping("/{id}")
    public String wingDetails(Model model, @PathVariable Long id) {
        model.addAttribute("wing", wingService.getById(id));
        return "wingDetails";
    }
    @GetMapping("/new")
    public String newWingForm(Model model){
        return "wingInput";
    }
    @PostMapping("/new")
    public String newWing(Model model){
        
        return "wingDetails";
    }
}
