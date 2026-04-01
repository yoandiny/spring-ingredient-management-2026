package edu.hei.school.ingredients.controller;

import edu.hei.school.ingredients.entity.Ingredient;
import edu.hei.school.ingredients.service.IngredientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientController {
    IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/ingredients")
    public List<Ingredient> getIngredients() {
        return ingredientService.findAll();
    }
}
