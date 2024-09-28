package com.example.recipeapp.base.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoadingContentError(
    loading: Boolean,
    error: Boolean,
    empty: Boolean,
    emptyContent: @Composable () -> Unit,
    errorContent: @Composable () -> Unit,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    PullToRefreshBox(
        modifier = modifier.fillMaxSize(),
        isRefreshing = loading,
        onRefresh = onRefresh,
    ) {
        when {
            error -> errorContent()
            empty -> emptyContent()
            else -> content()
        }
    }
}

@Preview
@Composable
fun LoadingPreview() {
    LoadingContentError(
        loading = true,
        error = false,
        empty = false,
        emptyContent = {},
        errorContent = {},
        onRefresh = {},
        content = {}
    )
}
