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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.laboratorywork3.viewmodel.RecipeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsRecipeScreen(
    navController: NavController,
    viewModel: RecipeViewModel,
    recipeId: Int
) {

    val recipe = viewModel.getRecipe(recipeId)

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

                        text = recipe.title,

                        style = MaterialTheme.typography.headlineSmall,

                        fontWeight = FontWeight.Bold

                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(

                        text = "Час приготування:",

                        fontWeight = FontWeight.Bold

                    )

                    Text("${recipe.cookingTime} хв")

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(

                        text = "Складність:",

                        fontWeight = FontWeight.Bold

                    )

                    Text(recipe.difficulty)

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(

                        text = "Інгредієнти:",

                        fontWeight = FontWeight.Bold

                    )

                    Text(recipe.ingredients)

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(

                        text = "Інструкція:",

                        fontWeight = FontWeight.Bold

                    )

                    Text(recipe.instructions)

                }

            }

            Button(

                modifier = Modifier.fillMaxWidth(),

                onClick = {

                    navController.navigate("edit/${recipe.id}")

                }

            ) {

                Text("Редагувати")

            }

            Button(

                modifier = Modifier.fillMaxWidth(),

                onClick = {

                    viewModel.deleteRecipe(recipe.id)

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