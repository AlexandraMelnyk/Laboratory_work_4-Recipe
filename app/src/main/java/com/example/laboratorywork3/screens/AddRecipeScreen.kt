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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.laboratorywork3.viewmodel.RecipeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddRecipeScreen(
    navController: NavController,
    viewModel: RecipeViewModel,
    recipeId: Int?
) {

    var title by remember {
        mutableStateOf("")
    }

    var ingredients by remember {
        mutableStateOf("")
    }

    var instructions by remember {
        mutableStateOf("")
    }

    var cookingTime by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(recipeId) {

        if (recipeId != null) {

            val recipe = viewModel.getRecipe(recipeId)

            recipe?.let {

                title = it.title
                ingredients = it.ingredients
                instructions = it.instructions
                cookingTime = it.cookingTime

            }

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

                modifier = Modifier.fillMaxWidth(),

                label = {

                    Text("Назва рецепту")

                }

            )

            OutlinedTextField(

                value = ingredients,

                onValueChange = {

                    ingredients = it

                },

                modifier = Modifier.fillMaxWidth(),

                label = {

                    Text("Інгредієнти")

                }

            )

            OutlinedTextField(

                value = instructions,

                onValueChange = {

                    instructions = it

                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),

                label = {

                    Text("Інструкція")

                }

            )

            OutlinedTextField(

                value = cookingTime.toString(),

                onValueChange = {

                    cookingTime = it.toIntOrNull() ?: 0

                },

                modifier = Modifier.fillMaxWidth(),

                label = {

                    Text("Час приготування (хв)")

                }

            )

            Button(

                onClick = {

                    if (recipeId == null) {

                        viewModel.addRecipe(

                            title,

                            ingredients,

                            instructions,

                            cookingTime

                        )

                    } else {

                        viewModel.updateRecipe(

                            recipeId,

                            title,

                            ingredients,

                            instructions,

                            cookingTime

                        )

                    }

                    navController.popBackStack()

                },

                modifier = Modifier.fillMaxWidth()

            ) {

                if (recipeId == null)

                    Text("Зберегти")

                else

                    Text("Оновити")

            }

            Button(

                onClick = {

                    navController.popBackStack()

                },

                modifier = Modifier.fillMaxWidth()

            ) {

                Text("Скасувати")

            }

        }

    }

}