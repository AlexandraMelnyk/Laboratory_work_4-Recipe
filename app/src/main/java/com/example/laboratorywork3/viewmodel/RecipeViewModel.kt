package com.example.laboratorywork3.viewmodel

import androidx.lifecycle.ViewModel
import com.example.laboratorywork3.model.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecipeViewModel : ViewModel() {

    private val _recipes = MutableStateFlow(

        listOf(

            Recipe(
                1,
                "Паста Карбонара",
                "Паста, яйця, бекон, пармезан",
                "Відварити пасту. Обсмажити бекон. Змішати всі інгредієнти.",
                25,
                "Легко"
            ),

            Recipe(
                2,
                "Цезар з куркою",
                "Курка, салат, сухарики, сир, соус",
                "Обсмажити курку. Змішати всі інгредієнти.",
                15,
                "Легко"
            ),

            Recipe(
                3,
                "Шоколадний торт",
                "Борошно, какао, яйця, масло",
                "Замісити тісто. Випікати 60 хв.",
                60,
                "Середньо"
            )

        )

    )

    val recipes = _recipes.asStateFlow()

    private var nextId = 4

    private fun difficulty(time: Int): String {

        return when {

            time <= 30 -> "Легко"

            time <= 60 -> "Середньо"

            else -> "Складно"
        }

    }

    fun addRecipe(

        title: String,

        ingredients: String,

        instructions: String,

        time: Int

    ) {

        val recipe = Recipe(

            id = nextId++,

            title = title,

            ingredients = ingredients,

            instructions = instructions,

            cookingTime = time,

            difficulty = difficulty(time)

        )

        _recipes.value = _recipes.value + recipe

    }

    fun getRecipe(id: Int): Recipe? {

        return _recipes.value.find {

            it.id == id

        }

    }

    fun deleteRecipe(id: Int) {

        _recipes.value = _recipes.value.filter {

            it.id != id

        }

    }

    fun updateRecipe(

        id: Int,

        title: String,

        ingredients: String,

        instructions: String,

        time: Int

    ) {

        _recipes.value = _recipes.value.map {

            if (it.id == id)

                it.copy(

                    title = title,

                    ingredients = ingredients,

                    instructions = instructions,

                    cookingTime = time,

                    difficulty = difficulty(time)

                )

            else

                it

        }

    }

}