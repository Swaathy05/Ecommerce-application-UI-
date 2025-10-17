package com.example.myapplication.ui.theme

import ItemsScreen
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.Flashviewmodel
import com.example.myapplication.ui.StartScreen

enum class FlashScreen {
    Start,
    Items
}

@Composable
fun FlashApp(
    flashviewmodel: Flashviewmodel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = FlashScreen.Start.name) {
        composable(route = FlashScreen.Start.name) {
            StartScreen(
                flashViewModel = flashviewmodel,
                onCategoriesClicked = { category ->
                    navController.navigate("${FlashScreen.Items.name}/$category")
                }
            )
        }

        composable(route = "${FlashScreen.Items.name}/{category}") { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: "Unknown"
            ItemsScreen(navController=navController,category = category)
        }
    }
}
