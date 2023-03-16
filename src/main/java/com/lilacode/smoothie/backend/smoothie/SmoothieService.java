package com.lilacode.smoothie.backend.smoothie;

import com.lilacode.smoothie.backend.ingredient.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SmoothieService {

    private final SmoothieRepository smoothieRepository;
    private final IngredientRepository ingredientRepository;

    public SmoothieService(SmoothieRepository smoothieRepository, IngredientRepository ingredientRepository) {
        this.smoothieRepository = smoothieRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<Smoothie> getSmoothies() {
        return smoothieRepository.findAll();
    }

    public List<Smoothie> saveSmoothies(List<Smoothie> newSmoothies) {
        return newSmoothies.stream().peek(s -> System.out.println("NEW: " + s))
                .map(newSmoothie -> smoothieRepository.findByName(newSmoothie.getName())
                        .map(smoothie -> {
                            System.out.println("Found: " + smoothie);
                            smoothie.setDescription(newSmoothie.getDescription());
                            smoothie.setIngredients(newSmoothie.getIngredients());
                            return smoothieRepository.save(smoothie);
                        })
                        .orElseGet(() -> smoothieRepository.save(newSmoothie)))
                .collect(Collectors.toList());
    }
}
