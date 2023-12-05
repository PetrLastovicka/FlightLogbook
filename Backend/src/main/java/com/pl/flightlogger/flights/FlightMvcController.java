package com.pl.flightlogger.flights;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc/flights")
public class FlightMvcController {
    private final FlightService flightService;
    @GetMapping
    public String allFlights(Model model) {
        model.addAttribute("flights", flightService.getAll());
        return "flights";
    }

}
