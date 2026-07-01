package com.example.laboratorywork3.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.laboratorywork3.viewmodel.RecipeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsRecipeScreen(
    navController: NavController,
    viewModel: RecipeViewModel,
    recipeId: Int
) {

    val recipe by viewModel.getRecipeById(recipeId)
        .collectAsStateWithLifecycle(initialValue = null)

    if (recipe == null) {

        Scaffold(

            topBar = {

                TopAppBar(

                    title = {

                        Text("Деталі рецепту")

                    }

                )

            }

        ) { padding ->

            Column(

                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),

                verticalArrangement = Arrangement.Center

            ) {

                Text("Рецепт не знайдено")

                Spacer(modifier = Modifier.height(16.dp))

                Button(

                    onClick = {

                        navController.popBackStack()

                    }

                ) {

                    Text("Назад")

                }

            }

        }

        return

    }

    val currentRecipe = recipe!!

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text("Деталі рецепту")

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

            Card(

                modifier = Modifier.fillMaxWidth(),

                elevation = CardDefaults.cardElevation(5.dp)

            ) {

                Column(

                    modifier = Modifier.padding(16.dp)

                ) {

                    Text(

                        text = currentRecipe.title,

                        style = MaterialTheme.typography.headlineSmall,

                        fontWeight = FontWeight.Bold

                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "Час приготування:",
                        fontWeight = FontWeight.Bold
                    )

                    Text("${currentRecipe.cookingTime} хв")

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "Складність:",
                        fontWeight = FontWeight.Bold
                    )

                    Text(currentRecipe.difficulty)

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "Інгредієнти:",
                        fontWeight = FontWeight.Bold
                    )

                    Text(currentRecipe.ingredients)

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "Інструкція:",
                        fontWeight = FontWeight.Bold
                    )

                    Text(currentRecipe.instructions)

                }

            }

            Button(

                modifier = Modifier.fillMaxWidth(),

                onClick = {

                    navController.navigate("edit/${currentRecipe.id}")

                }

            ) {

                Text("Редагувати")

            }

            Button(

                modifier = Modifier.fillMaxWidth(),

                onClick = {

                    viewModel.deleteRecipe(currentRecipe)

                    navController.popBackStack()

                }

            ) {

                Text("Видалити")

            }

            Button(

                modifier = Modifier.fillMaxWidth(),

                onClick = {

                    navController.popBackStack()

                }

            ) {

                Text("Назад")

            }

        }

    }

}