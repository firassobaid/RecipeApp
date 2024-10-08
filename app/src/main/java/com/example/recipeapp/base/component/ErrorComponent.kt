package com.example.recipeapp.base.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ErrorComponent(modifier: Modifier = Modifier, errorMessage: String) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = errorMessage,
            color = MaterialTheme.colorScheme.error
        )
    }
}

@Composable
fun EmptyComponent(emptyMessage: String) {
    Text(text = emptyMessage)
}

@Preview
@Composable
fun ErrorPreview() {
    ErrorComponent(
        errorMessage = "An error occurred, please retry",
    )
}

@Preview
@Composable
fun EmptyPreview() {
    EmptyComponent("Empty list")
}
