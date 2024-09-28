package com.example.recipeapp.recipe.presentation

import android.util.Log
import androidx.lifecycle.SavedStateHandle
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
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

const val RECIPE_SAVED_STATE_KEY = "RECIPE_SAVED_STATE_KEY"

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val repository: RecipeRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state =
        MutableStateFlow(
            savedStateHandle.get<String>(RECIPE_SAVED_STATE_KEY)?.let {
                Json.decodeFromString<RecipeState>(it)
            } ?: RecipeState(loading = true)
        )
    val state: StateFlow<RecipeState> = _state
        .onStart { getRecipes() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            RecipeState(loading = true)
        )

    init {
        viewModelScope.launch {
            _state.collect {
                Log.i("RecipeViewModel", "The state is: $it")
                savedStateHandle[RECIPE_SAVED_STATE_KEY] = Json.encodeToString(it)
            }
        }
    }

    private fun getRecipes() {
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
        _state.update { it.copy(loading = true, error = false) }
        getRecipes()
    }
}

@Serializable
data class RecipeState(
    val loading: Boolean = false,
    val error: Boolean = false,
    val data: List<RecipeResponseItem>? = emptyList()
)
