package com.patsi.bean;

import com.patsi.database.configuration.JpaJsonConverter;
import com.patsi.enums.RecipeType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
public class Recipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID recipeID;

    @NotNull
    private String recipeName;
    @Enumerated(EnumType.ORDINAL)
    private RecipeType type;
    // binding persistence
    @Convert(converter = JpaJsonConverter.class)
    @Size(max = 9999)
    private List<Ingredient> ingredient;
    @NotNull
    private String steps;
    private String imgURL;

    //Nested Ingredient Class
    public static class Ingredient {
        public String getIngredientName() {
            return ingredientName;
        }

        public void setIngredientName(String ingredientName) {
            this.ingredientName = ingredientName;
        }

        public String getIngredientAmount() {
            return ingredientAmount;
        }

        public void setIngredientAmount(String ingredientAmount) {
            this.ingredientAmount = ingredientAmount;
        }

        private String ingredientName;
        private String ingredientAmount;
        public Ingredient(String ingredientName, String ingredientAmount) {
            this.ingredientName = ingredientName;
            this.ingredientAmount = ingredientAmount;
        }
    }
    public Recipe() {
    }

    public Recipe(String recipeName, RecipeType type, List<Ingredient> ingredient, String steps) {
        this.recipeName = recipeName;
        this.type = type;
        this.ingredient = ingredient;
        this.steps = steps;
    }


    public UUID getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(UUID recipeID) {
        this.recipeID = recipeID;
    }

    public String getrecipeName() {
        return recipeName;
    }

    public void setrecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public RecipeType getType() {
        return type;
    }

    public void setType(RecipeType type) {
        this.type = type;
    }

    public List<Ingredient> getIngredient() {
        return ingredient;
    }

    public void setIngredient(List<Ingredient>  ingredient) {
        this.ingredient = ingredient;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}