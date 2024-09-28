package com.example.recipeapp.base.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ErrorComponent(errorMessage: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(
                modifier = Modifier.align(Alignment.Center),
                onClick = onClick
            ) {
                Text(text = "Retry")
            }
        }
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
        onClick = {}
    )
}

@Preview
@Composable
fun EmptyPreview() {
    EmptyComponent("Empty list")
}
