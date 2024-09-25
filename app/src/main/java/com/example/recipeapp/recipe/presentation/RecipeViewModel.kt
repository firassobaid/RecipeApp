package com.example.recipeapp.recipe.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.recipe.domain.model.RecipeResponseItem
import com.example.recipeapp.recipe.domain.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {

    private val _state = MutableStateFlow(RecipeState())
    val state: StateFlow<RecipeState> = _state
        .onStart { getRecipes() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            RecipeState(loading = true)
        )

    fun getRecipes() {
        viewModelScope.launch {
            repository.getRecipes()
                .onSuccess { result ->
                    _state.update {
                        it.copy(loading = false, data = result)
                    }
                }
                .onFailure {
                    _state.update {
                        it.copy(loading = false, error = true)
                    }
                }
        }
    }

    fun refresh() {
        _state.update { it.copy(loading = true) }
        getRecipes()
    }
}

data class RecipeState(
    val loading: Boolean = false,
    val error: Boolean = false,
    val data: List<RecipeResponseItem>? = emptyList()
)
