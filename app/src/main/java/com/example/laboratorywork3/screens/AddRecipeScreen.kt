package com.example.laboratorywork3.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.laboratorywork3.viewmodel.RecipeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddRecipeScreen(
    navController: NavController,
    viewModel: RecipeViewModel,
    recipeId: Int?
) {

    val recipeFlow = remember(recipeId) {
        recipeId?.let { viewModel.getRecipeById(it) }
    }

    val recipe by recipeFlow?.collectAsStateWithLifecycle(initialValue = null)
        ?: remember { mutableStateOf(null) }

    var title by remember { mutableStateOf("") }
    var ingredients by remember { mutableStateOf("") }
    var instructions by remember { mutableStateOf("") }
    var cookingTime by remember { mutableStateOf("") }

    LaunchedEffect(recipe) {

        recipe?.let {

            title = it.title
            ingredients = it.ingredients
            instructions = it.instructions
            cookingTime = it.cookingTime.toString()

        }

    }

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    if (recipeId == null)
                        Text("Новий рецепт")
                    else
                        Text("Редагування рецепту")

                }

            )

        }

    ) { padding ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),

            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {

            OutlinedTextField(

                value = title,

                onValueChange = {

                    title = it

                },

                label = {

                    Text("Назва рецепту")

                },

                modifier = Modifier.fillMaxWidth()

            )

            OutlinedTextField(

                value = ingredients,

                onValueChange = {

                    ingredients = it

                },

                label = {

                    Text("Інгредієнти")

                },

                modifier = Modifier.fillMaxWidth()

            )

            OutlinedTextField(

                value = instructions,

                onValueChange = {

                    instructions = it

                },

                label = {

                    Text("Інструкція")

                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)

            )

            OutlinedTextField(

                value = cookingTime,

                onValueChange = {

                    cookingTime = it

                },

                label = {

                    Text("Час приготування (хв)")

                },

                modifier = Modifier.fillMaxWidth()

            )

            Button(

                modifier = Modifier.fillMaxWidth(),

                onClick = {

                    val time = cookingTime.toIntOrNull() ?: 0

                    if (recipeId == null) {

                        viewModel.addRecipe(

                            title = title,

                            ingredients = ingredients,

                            instructions = instructions,

                            cookingTime = time

                        )

                    } else {

                        viewModel.updateRecipe(

                            id = recipeId,

                            title = title,

                            ingredients = ingredients,

                            instructions = instructions,

                            cookingTime = time

                        )

                    }

                    navController.popBackStack()

                }

            ) {

                if (recipeId == null)

                    Text("Зберегти")

                else

                    Text("Оновити")

            }

            Button(

                modifier = Modifier.fillMaxWidth(),

                onClick = {

                    navController.popBackStack()

                }

            ) {

                Text("Скасувати")

            }

        }

    }

}