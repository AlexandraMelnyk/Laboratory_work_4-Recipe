package com.example.laboratorywork3.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.laboratorywork3.viewmodel.RecipeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesListScreen(
    navController: NavController,
    viewModel: RecipeViewModel
) {

    val recipes by viewModel.recipes.collectAsStateWithLifecycle()

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text("Мої рецепти")

                }

            )

        },

        floatingActionButton = {

            FloatingActionButton(

                onClick = {

                    navController.navigate("add")

                }

            ) {

                Text("+")

            }

        }

    ) { padding ->

        if (recipes.isEmpty()) {

            Column(

                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),

                verticalArrangement = Arrangement.Center

            ) {

                Text(

                    text = "Рецептів поки що немає."

                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(

                    text = "Натисніть '+' для створення."

                )

            }

        } else {

            LazyColumn(

                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(12.dp),

                verticalArrangement = Arrangement.spacedBy(12.dp)

            ) {

                items(recipes) { recipe ->

                    Card(

                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {

                                navController.navigate(
                                    "details/${recipe.id}"
                                )

                            },

                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        )

                    ) {

                        Column(

                            modifier = Modifier.padding(16.dp)

                        ) {

                            Text(

                                text = recipe.title,

                                fontWeight = FontWeight.Bold

                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Row {

                                Text("Час приготування: ")

                                Text("${recipe.cookingTime} хв")

                            }

                        }

                    }

                }

            }

        }

    }

}