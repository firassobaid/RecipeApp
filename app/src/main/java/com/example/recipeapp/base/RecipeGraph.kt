package com.example.recipeapp.base

import android.net.Uri
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.recipeapp.base.util.parcelable
import com.example.recipeapp.details.presentation.RecipeDetailsScreen
import com.example.recipeapp.recipe.domain.model.RecipeResponseItem
import com.example.recipeapp.recipe.presentation.RecipeScreen
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.reflect.typeOf

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
                onItemClick = { recipe ->
                    navController.navigate(RecipeDetailsScreenRoute(recipe))
                }
            )
        }

        composable<RecipeDetailsScreenRoute>(
            typeMap = mapOf(typeOf<RecipeResponseItem>() to RecipeType)
        ) {
            val args = it.toRoute<RecipeDetailsScreenRoute>()
            RecipeDetailsScreen(
                recipe = args.recipe,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Serializable
object RecipeScreenRoute

@Serializable
data class RecipeDetailsScreenRoute(
    val recipe: RecipeResponseItem
)

val RecipeType = object : NavType<RecipeResponseItem>(
    isNullableAllowed = false
) {
    override fun get(bundle: Bundle, key: String): RecipeResponseItem? {
        return bundle.parcelable(key)
    }

    override fun parseValue(value: String): RecipeResponseItem {
        return Json.decodeFromString(value)
    }

    override fun put(bundle: Bundle, key: String, value: RecipeResponseItem) {
        bundle.putParcelable(key, value)
    }

    override fun serializeAsValue(value: RecipeResponseItem): String {
        return Uri.encode(Json.encodeToString(value))
    }
}
