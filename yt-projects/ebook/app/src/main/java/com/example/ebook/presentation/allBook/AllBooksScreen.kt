package com.example.ebook.presentation.allBook

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.ebook.presentation.ViewModel
import com.example.ebook.presentation.effects.AnimateShimmer
import com.example.ebook.presentation.uiComponent.BookCart


@Composable
fun AllBooksScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: ViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {

        viewModel.BringAllBooks()
    }

    val res = viewModel.state.value

    when {

        res.isLoading -> {

            Column(
                modifier = modifier.fillMaxSize()
            ) {
                LazyColumn {
                    items(10) {
                        AnimateShimmer()
                    }
                }
            }
        }

        res.error.isNotEmpty() -> {

            Text(text = res.error, modifier = modifier)
        }

        res.items.isNotEmpty() -> {

            Column(
                modifier = modifier.fillMaxSize()
            ) {
                LazyColumn(
                    modifier = modifier.fillMaxSize()
                ) {
                    items(res.items) {

                        BookCart(
                            imgUrl = it.image,
                            title = it.bookName,
                            author = it.bookAuthor,
                            description = it.bookDescription,
                            bookUrl = it.bookUrl,
                            navHostController = navHostController
                        )

                    }
                }
            }
        }

        else ->{
            Text("No book available", modifier = modifier)
        }
    }

}