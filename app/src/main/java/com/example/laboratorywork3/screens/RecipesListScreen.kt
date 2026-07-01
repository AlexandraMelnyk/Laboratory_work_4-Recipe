package com.example.laboratorywork3.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.laboratorywork3.model.Recipe
import com.example.laboratorywork3.viewmodel.RecipeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesListScreen(
    navController: NavController,
    viewModel: RecipeViewModel
) {

    val recipes by viewModel.recipes.collectAsState()

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

                Icon(

                    imageVector = Icons.Default.Add,

                    contentDescription = "Add"

                )

            }

        }

    ) { padding ->

        if (recipes.isEmpty()) {

            Box(

                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),

                contentAlignment = Alignment.Center

            ) {

                Text(

                    text = "Рецептів поки немає"

                )

            }

        } else {

            LazyColumn(

                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),

                contentPadding = PaddingValues(12.dp),

                verticalArrangement = Arrangement.spacedBy(12.dp)

            ) {

                items(recipes) { recipe ->

                    RecipeCard(

                        recipe = recipe,

                        onClick = {

                            navController.navigate(
                                "details/${recipe.id}"
                            )

                        }

                    )

                }

            }

        }

    }

}

@Composable
fun RecipeCard(

    recipe: Recipe,

    onClick: () -> Unit

) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .clickable {

                onClick()

            },

        elevation = CardDefaults.cardElevation(5.dp)

    ) {

        Column(

            modifier = Modifier.padding(16.dp)

        ) {

            Text(

                text = recipe.title,

                style = MaterialTheme.typography.titleLarge

            )

            Spacer(

                modifier = Modifier.height(10.dp)

            )

            Row(

                verticalAlignment = Alignment.CenterVertically

            ) {

                Icon(

                    imageVector = Icons.Default.AccessTime,

                    contentDescription = null,

                    modifier = Modifier.size(20.dp)

                )

                Spacer(

                    modifier = Modifier.size(6.dp)

                )

                Text(

                    text = "${recipe.cookingTime} хв"

                )

            }

        }

    }

}