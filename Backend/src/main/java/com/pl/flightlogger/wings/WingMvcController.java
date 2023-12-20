package com.pl.flightlogger.wings;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("title", "Add your new wing");
        return "newWing";
    }
    @PostMapping("/new")
    public String newWing(Model model, @RequestBody @Valid NewWingDTO request){
      Wing wing = wingService.create(request);
        model.addAttribute("wing", wing);
        return "created";
    }

    @GetMapping("/edit/{id}")
    public String editWingForm(Model model,@PathVariable Long id){
        model.addAttribute("title", "Edit your wing");
        model.addAttribute("wing", wingService.getById(id));
        return "wingInput";
    }
}
