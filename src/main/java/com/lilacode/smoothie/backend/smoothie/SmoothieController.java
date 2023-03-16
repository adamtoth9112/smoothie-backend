package com.lilacode.smoothie.backend.smoothie;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class SmoothieController {

    private final SmoothieService smoothieService;

    public SmoothieController(SmoothieService smoothieService) {
        this.smoothieService = smoothieService;
    }

    @GetMapping("/smoothies")
    public List<Smoothie> getSmoothies() {
        return smoothieService.getSmoothies();
    }

    @PutMapping("/smoothies")
    public List<Smoothie> updateSmoothies(@RequestBody List<Smoothie> newSmoothies) {
        return smoothieService.saveSmoothies(newSmoothies);
    }
}
