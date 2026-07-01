package com.example.laboratorywork3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.laboratorywork3.ui.theme.LaboratoryWork3Theme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.laboratorywork3.navigation.AppNavigation
import com.example.laboratorywork3.viewmodel.RecipeViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            LaboratoryWork3Theme {

                val recipeViewModel: RecipeViewModel = viewModel()

                AppNavigation(recipeViewModel)

            }
        }
    }
}