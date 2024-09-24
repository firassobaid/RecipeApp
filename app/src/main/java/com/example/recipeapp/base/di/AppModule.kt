package com.example.recipeapp.base.di

import com.example.recipeapp.recipe.data.repository.DefaultRecipeRepository
import com.example.recipeapp.recipe.domain.repository.RecipeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RecipeModule {

    @Singleton
    @Binds
    abstract fun bindRecipeRepository(repository: DefaultRecipeRepository): RecipeRepository
}