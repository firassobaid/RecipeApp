package com.example.recipeapp.base.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

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
    Box(modifier = modifier.pullRefresh(pullRefreshState)) {
        if (error) {
                errorContent()
        } else {
            if (empty) {
                emptyContent()
            } else {
                content()
            }
        }
        PullRefreshIndicator(loading, pullRefreshState, Modifier.align(Alignment.TopCenter))
    }
}
