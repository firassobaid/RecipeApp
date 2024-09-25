package com.example.recipeapp.recipe.data.repository

import com.example.recipeapp.recipe.data.remote.RecipeApi
import com.example.recipeapp.recipe.domain.model.RecipeResponseItem
import com.example.recipeapp.recipe.domain.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultRecipeRepository @Inject constructor(
    private val apiService: RecipeApi
) : RecipeRepository {
    override suspend fun getRecipes(): Result<List<RecipeResponseItem>> =
        withContext(Dispatchers.IO) {
            try {
                delay(3000)
                val response = apiService.getRecipes()
                Result.success(response)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
}
