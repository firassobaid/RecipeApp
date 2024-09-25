package com.example.recipeapp.base.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeTopBar(
    title: String,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,  // Default to theme primary color
    contentColor: Color = MaterialTheme.colorScheme.onPrimary
) {
    TopAppBar(
        title = {
            Text(
                text = title
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor,  // Set background color
            titleContentColor = contentColor   // Set content (title) color
        )
    )
}

@Preview
@Composable
fun RecipeTopBarPreview() {
    RecipeTopBar(title = "Recipe App")
}
