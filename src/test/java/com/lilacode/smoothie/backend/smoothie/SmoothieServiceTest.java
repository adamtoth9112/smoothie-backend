package com.lilacode.smoothie.backend.smoothie;

import com.lilacode.smoothie.backend.ingredient.Ingredient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class SmoothieServiceTest {

    @Mock
    private SmoothieRepository smoothieRepository;

    @InjectMocks
    private SmoothieService underTest;

    final String expectedName = "banana";

    @Test
    void itSavesSmoothies() {
        given(smoothieRepository.findByName(any()))
                .willReturn(Optional.empty());

        underTest.saveSmoothies(getSmoothieList());

        then(smoothieRepository)
                .should()
                .save(getSmoothie(1));
    }

    @Test
    void itUpdatesSmoothies() {
        given(smoothieRepository.findByName(any()))
                .willReturn(Optional.of(getSmoothie(5)));
        given(smoothieRepository.save(any()))
                .willReturn(getSmoothie(1));

        List<Smoothie> result = underTest.saveSmoothies(getSmoothieList());

        assertEquals(1, result.get(0).getIngredients().get(0).getAmount());
    }

    private List<Smoothie> getSmoothieList() {
        Smoothie smoothie = getSmoothie(1);
        List<Smoothie> smoothies = List.of(smoothie);
        return smoothies;
    }

    private Smoothie getSmoothie(int amount) {
        Smoothie smoothie = new Smoothie();
        smoothie.setName(expectedName);
        Ingredient ingredient = new Ingredient();
        ingredient.setName(expectedName);
        ingredient.setAmount(amount);
        ingredient.setSmoothie(smoothie);
        smoothie.setIngredients(List.of(ingredient));
        return smoothie;
    }
}