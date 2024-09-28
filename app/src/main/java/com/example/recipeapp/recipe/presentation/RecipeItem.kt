package com.example.recipeapp.recipe.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.recipeapp.recipe.domain.model.RecipeResponseItem

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
        AsyncImage(
            model = recipe.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .padding(end = 16.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = recipe.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = recipe.description,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun RecipeItemPreview() {
    RecipeItem(
        recipe = RecipeResponseItem(
            calories = "100",
            carbos = "100",
            country = "USA",
            description = "A delicious American dish.A delicious American dish." +
                    "A delicious American dish." +
                    "A delicious American dish." +
                    "A delicious American dish." +
                    "A delicious American dish.",
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
        modifier = Modifier
    )

}
