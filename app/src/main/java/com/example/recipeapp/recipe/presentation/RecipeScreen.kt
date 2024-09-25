package com.example.recipeapp.recipe.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.recipeapp.R
import com.example.recipeapp.base.component.EmptyComponent
import com.example.recipeapp.base.component.ErrorComponent
import com.example.recipeapp.base.component.LoadingContentError
import com.example.recipeapp.base.component.RecipeTopBar
import com.example.recipeapp.recipe.domain.model.RecipeResponseItem

@Composable
fun RecipeScreen(
    viewModel: RecipeViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            RecipeTopBar(
                title = stringResource(R.string.app_name)
            )
        }
    ) { paddingValues ->

        val state by viewModel.state.collectAsStateWithLifecycle()

        RecipeContent(
            modifier = Modifier.padding(paddingValues),
            loading = state.loading,
            error = state.error,
            data = state.data,
            onRefresh = viewModel::refresh
        )
    }
}

@Composable
fun RecipeContent(
    modifier: Modifier = Modifier,
    loading: Boolean,
    error: Boolean,
    data: List<RecipeResponseItem>?,
    onRefresh: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        LoadingContentError(
            loading = loading,
            error = error,
            empty = false,
            errorContent = { ErrorComponent() },
            onRefresh = onRefresh,
            emptyContent = { EmptyComponent() }
        ) {
            LazyColumn(
                modifier = Modifier.align(Alignment.TopCenter)
            ) {
                items(data!!) { item ->
                    RecipeItem(item)
                }
            }
        }
    }
}

@Composable
fun RecipeItem(
    recipe: RecipeResponseItem,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Recipe Icon (Image)
        AsyncImage(
            model = recipe.image,
            contentDescription = null,
        )

        // Title and Subtitle (Name and Description)
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = recipe.name,
                style = MaterialTheme.typography.titleMedium, // Title style
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = recipe.description,
                style = MaterialTheme.typography.bodyMedium, // Subtitle style
                color = Color.Gray
            )
        }
    }
}

@Preview
@Composable
fun RecipePreview() {
    RecipeContent(
        loading = false,
        error = false,
        data = listOf(
            RecipeResponseItem(
                calories = "100",
                carbos = "100",
                country = "USA",
                description = "A delicious American dish.",
                difficulty = 1,
                fats = "10g",
                headline = "Classic Burger",
                id = "1",
                image = "https://example.com/burger.jpg",
                name = "Burger",
                proteins = "20g",
                thumb = "https://example.com/burger_thumb.jpg",
                time = "30 min"
            ),
            RecipeResponseItem(
                calories = "250",
                carbos = "50",
                country = "Italy",
                description = "A classic Italian pasta.",
                difficulty = 2,
                fats = "5g",
                headline = "Spaghetti Carbonara",
                id = "2",
                image = "https://example.com/pasta.jpg",
                name = "Pasta",
                proteins = "15g",
                thumb = "https://example.com/pasta_thumb.jpg",
                time = "45 min"
            )
        )
    )
}

@Preview
@Composable
fun RecipePreviewLoading() {
    RecipeContent(loading = true, error = false, data = emptyList())
}

@Preview
@Composable
fun RecipePreviewError() {
    RecipeContent(loading = false, error = true, data = emptyList())
}