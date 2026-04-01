package edu.hei.school.ingredients.service;

import edu.hei.school.ingredients.entity.Ingredient;
import edu.hei.school.ingredients.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class IngredientService {
    IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> findAll(){
        return ingredientRepository.findAll();
    }
}
