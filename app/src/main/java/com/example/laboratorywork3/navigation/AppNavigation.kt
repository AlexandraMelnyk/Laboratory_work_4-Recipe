package com.example.laboratorywork3.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.laboratorywork3.screens.AddRecipeScreen
import com.example.laboratorywork3.screens.DetailsRecipeScreen
import com.example.laboratorywork3.screens.RecipesListScreen
import com.example.laboratorywork3.viewmodel.RecipeViewModel

@Composable
fun AppNavigation(
    viewModel: RecipeViewModel
) {

    val navController = rememberNavController()

    NavHost(

        navController = navController,

        startDestination = "list"

    ) {

        composable("list") {

            RecipesListScreen(

                navController = navController,

                viewModel = viewModel

            )

        }

        composable("add") {

            AddRecipeScreen(

                navController = navController,

                viewModel = viewModel,

                recipeId = null

            )

        }

        composable(

            route = "details/{recipeId}",

            arguments = listOf(

                navArgument("recipeId") {

                    type = NavType.IntType

                }

            )

        ) {

            val id = it.arguments?.getInt("recipeId") ?: 0

            DetailsRecipeScreen(

                navController = navController,

                viewModel = viewModel,

                recipeId = id

            )

        }

        composable(

            route = "edit/{recipeId}",

            arguments = listOf(

                navArgument("recipeId") {

                    type = NavType.IntType

                }

            )

        ) {

            val id = it.arguments?.getInt("recipeId") ?: 0

            AddRecipeScreen(

                navController = navController,

                viewModel = viewModel,

                recipeId = id

            )

        }

    }

}