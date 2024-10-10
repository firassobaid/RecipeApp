package com.example.recipeapp.details.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.recipeapp.R
import com.example.recipeapp.base.component.RecipeTopBar
import com.example.recipeapp.recipe.domain.model.RecipeResponseItem
import com.example.recipeapp.recipe.presentation.RecipeItem

@Composable
fun RecipeDetailsScreen(
    viewModel: RecipeDetailsViewModel = hiltViewModel(),
    recipe: RecipeResponseItem,
    onBackClick: () -> Unit
) {

    LaunchedEffect(recipe) {
        viewModel.setRecipe(recipe)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            RecipeTopBar(
                title = stringResource(R.string.app_name),
                onBackClick = onBackClick
            )
        }
    ) { paddingValues ->

        val state by viewModel.state.collectAsStateWithLifecycle()

        RecipeDetailsContent(
            modifier = Modifier.padding(paddingValues),
            data = state.data,
        )
    }
}

@Composable
fun RecipeDetailsContent(
    modifier: Modifier = Modifier,
    data: RecipeResponseItem?
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        if (data != null) {
            RecipeItem(recipe = data)
        }
    }
}
