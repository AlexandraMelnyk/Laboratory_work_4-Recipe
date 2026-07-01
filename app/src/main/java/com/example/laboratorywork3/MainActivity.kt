package com.example.laboratorywork3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.laboratorywork3.data.local.DatabaseProvider
import com.example.laboratorywork3.data.repository.RecipeRepository
import com.example.laboratorywork3.navigation.AppNavigation
import com.example.laboratorywork3.ui.theme.LaboratoryWork3Theme
import com.example.laboratorywork3.viewmodel.RecipeViewModel
import com.example.laboratorywork3.viewmodel.RecipeViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val database = DatabaseProvider.getDatabase(applicationContext)

        val repository = RecipeRepository(database.recipeDao())

        val factory = RecipeViewModelFactory(repository)

        setContent {

            LaboratoryWork3Theme {

                val recipeViewModel: RecipeViewModel = viewModel(
                    factory = factory
                )

                AppNavigation(recipeViewModel)

            }

        }

    }

}