package com.example.ebook.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.ebook.presentation.PdfViewerScreen
import com.example.ebook.presentation.allBooksByCategory.BooksByCategoryScreen
import com.example.ebook.presentation.home.HomeScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    modifier: Modifier,
) {
    NavHost(
        navController = navHostController,
        startDestination = Routes.HomeScreen
    ) {
        // add composable destinations here
        composable<Routes.HomeScreen> {
            HomeScreen(navHostController = navHostController)
        }

        composable<Routes.ShowPdfScreen> {backStackEntry ->

            val data: Routes.ShowPdfScreen = backStackEntry.toRoute()
            PdfViewerScreen(url = data.url)

        }

        composable<Routes.BooksByCategory> {backStackEntry ->
            val data2: Routes.BooksByCategory = backStackEntry.toRoute()
            BooksByCategoryScreen(category = data2.category, navHostController = navHostController)
        }

        
    }
}
