package com.example.ebook.presentation.category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.ebook.presentation.ViewModel
import com.example.ebook.presentation.effects.categoryShimer
import com.example.ebook.presentation.uiComponent.BookCategoryCard

@Composable
fun CategoryScreen(navHostController: NavHostController) {
    val viewModel: ViewModel = hiltViewModel()

    LaunchedEffect(Unit) {
        viewModel.BringCategories()
    }

    val res = viewModel.state.value

    Column(modifier = Modifier.fillMaxSize()) {
        when {
            res.isLoading -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(10) {
                        categoryShimer()
                    }
                }
            }

            res.error.isNotEmpty() -> {
                Text(text = res.error)
            }

            res.category.isNotEmpty() -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(res.category) {
                        BookCategoryCard(
                            imgUrl = it.categoryImageUrl,
                            category = it.name,
                            navHostController = navHostController
                        )
                    }
                }
            }
        }
    }
}
