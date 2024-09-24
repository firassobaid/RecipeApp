package com.example.recipeapp.base

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipeapp.recipe.presentation.RecipeScreen
import kotlinx.serialization.Serializable

@Composable
fun RecipeGraph(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RecipeScreenRoute,
        modifier = modifier
    ) {
        composable<RecipeScreenRoute> {
            RecipeScreen(

            )
        }
    }
}

@Serializable
object RecipeScreenRoute
