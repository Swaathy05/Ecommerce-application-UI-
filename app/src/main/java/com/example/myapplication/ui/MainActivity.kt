package com.example.myapplication

import ItemsScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.Flashviewmodel
import com.example.myapplication.ui.StartScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

enum class FlashScreen {
    Start,
    Items
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FlashApp()
                }
            }
        }
    }
}

@Composable
fun FlashApp(
    flashViewModel: Flashviewmodel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = FlashScreen.Start.name
    ) {
        composable(route = FlashScreen.Start.name) {
            StartScreen(
                flashViewModel = flashViewModel,
                onCategoriesClicked = { category ->
                    navController.navigate("${FlashScreen.Items.name}/$category")
                }
            )
        }

        composable(route = "${FlashScreen.Items.name}/{category}") { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: "Unknown"
            println("Category received: $category") // Debugging
            ItemsScreen(navController = navController, category = category)
        }
    }
}
