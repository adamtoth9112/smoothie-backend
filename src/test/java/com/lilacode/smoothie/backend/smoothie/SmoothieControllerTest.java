package com.lilacode.smoothie.backend.smoothie;

import com.lilacode.smoothie.backend.ingredient.Ingredient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class SmoothieControllerTest {

    @Mock
    private SmoothieService smoothieService;

    @InjectMocks
    private SmoothieController underTest;

    final String expectedName = "banana";

    @Test
    void itReturnSmoothies() {
        List<Smoothie> smoothies = getSmoothieList();

        given(smoothieService.getSmoothies())
                .willReturn(smoothies);

        List<Smoothie> result = underTest.getSmoothies();

        assertFalse(result.isEmpty());
        assertEquals(expectedName, result.get(0).getName());
    }

    @Test
    void itSavesSmoothies() {
        List<Smoothie> smoothies = getSmoothieList();

        given(smoothieService.saveSmoothies(any()))
                .willReturn(smoothies);

        List<Smoothie> result = underTest.updateSmoothies(smoothies);

        assertFalse(result.isEmpty());
    }

    private List<Smoothie> getSmoothieList() {
        Smoothie smoothie = new Smoothie();
        smoothie.setName(expectedName);
        Ingredient ingredient = new Ingredient();
        ingredient.setName(expectedName);
        ingredient.setAmount(1);
        ingredient.setSmoothie(smoothie);
        smoothie.setIngredients(List.of(ingredient));
        List<Smoothie> smoothies = List.of(smoothie);
        return smoothies;
    }
}