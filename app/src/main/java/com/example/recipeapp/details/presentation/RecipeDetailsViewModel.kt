package com.example.recipeapp.details.presentation

import androidx.lifecycle.ViewModel
import com.example.recipeapp.recipe.domain.model.RecipeResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RecipeDetailsViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(RecipeDetailsState())
    val state: StateFlow<RecipeDetailsState> = _state.asStateFlow()

    fun setRecipe(recipe: RecipeResponseItem) {
        _state.update { currentState ->
            currentState.copy(data = recipe)
        }
    }
}

data class RecipeDetailsState(
    val loading: Boolean = false,
    val error: Boolean = false,
    val data: RecipeResponseItem? = null
)
