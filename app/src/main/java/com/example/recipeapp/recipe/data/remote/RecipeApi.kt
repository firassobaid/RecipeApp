package com.example.recipeapp.recipe.data.remote

import com.example.recipeapp.recipe.domain.model.RecipeResponseItem
import retrofit2.http.GET

interface RecipeApi {
    @GET("recipes.json")
    suspend fun getRecipes(): List<RecipeResponseItem>
}