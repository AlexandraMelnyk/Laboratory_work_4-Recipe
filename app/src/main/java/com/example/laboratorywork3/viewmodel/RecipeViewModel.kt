package com.example.laboratorywork3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorywork3.data.local.RecipeEntity
import com.example.laboratorywork3.data.repository.RecipeRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val repository: RecipeRepository
) : ViewModel() {

    val recipes = repository.recipes.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun getRecipeById(id: Int) =
        repository.getRecipeById(id)

    fun addRecipe(
        title: String,
        ingredients: String,
        instructions: String,
        cookingTime: Int
    ) {

        val difficulty = when {

            cookingTime <= 30 -> "Легко"

            cookingTime <= 60 -> "Середньо"

            else -> "Складно"

        }

        viewModelScope.launch {

            repository.addRecipe(

                RecipeEntity(

                    title = title,

                    ingredients = ingredients,

                    instructions = instructions,

                    cookingTime = cookingTime,

                    difficulty = difficulty

                )

            )

        }

    }

    fun updateRecipe(

        id: Int,

        title: String,

        ingredients: String,

        instructions: String,

        cookingTime: Int

    ) {

        val difficulty = when {

            cookingTime <= 30 -> "Легко"

            cookingTime <= 60 -> "Середньо"

            else -> "Складно"

        }

        viewModelScope.launch {

            repository.updateRecipe(

                RecipeEntity(

                    id = id,

                    title = title,

                    ingredients = ingredients,

                    instructions = instructions,

                    cookingTime = cookingTime,

                    difficulty = difficulty

                )

            )

        }

    }

    fun deleteRecipe(recipe: RecipeEntity) {

        viewModelScope.launch {

            repository.deleteRecipe(recipe)

        }

    }

}