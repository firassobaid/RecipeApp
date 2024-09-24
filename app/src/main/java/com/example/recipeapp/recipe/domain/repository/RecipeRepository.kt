package com.example.recipeapp.recipe.domain.repository

import com.example.recipeapp.recipe.domain.model.RecipeResponseItem

interface RecipeRepository {
    suspend fun getRecipes(): Result<List<RecipeResponseItem>>
}