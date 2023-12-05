package com.pl.flightlogger.wings;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
