package com.example.recipeapp.base.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterialApi::class)
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
    val pullRefreshState = rememberPullRefreshState(loading, onRefresh)
    Box(modifier = modifier.fillMaxSize().pullRefresh(pullRefreshState)) {
        when {
            error -> errorContent()
            empty -> emptyContent()
            else -> content()
        }
        PullRefreshIndicator(
            refreshing = loading,
            state = pullRefreshState,
            modifier = Modifier.align(Alignment.TopCenter),
            backgroundColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
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
