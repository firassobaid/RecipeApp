package com.example.recipeapp.base.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorComponent() {
    Text(text = "Something went wrong")
}


@Composable
fun EmptyComponent() {
    Text(text = "Empty state")
}