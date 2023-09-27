package com.pl.flightsmaven.wings;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wings")
public class WingController {
   final WingService wingService;
   @GetMapping
   ResponseEntity<?> getAll(){
      return ResponseEntity.status(200).body(wingService.getAll());
   }
   @PostMapping("create")
   ResponseEntity<?> create(@RequestBody NewWingDTO request){
      return ResponseEntity.status(201).body(wingService.create(request));
   }
}
