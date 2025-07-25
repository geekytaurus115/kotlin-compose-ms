package com.example.ebook.presentation.uiComponent

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.SubcomposeAsyncImage
import com.example.ebook.presentation.navigation.Routes

@Composable
fun BookCategoryCard(
    imgUrl: String?,
    category: String?,
    navHostController: NavHostController
) {
    val safeImgUrl = imgUrl ?: ""
    val safeCategory = category ?: "Unknown"

    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                try {
                    navHostController.navigate(Routes.BooksByCategory(safeCategory))
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
    ) {
        Column(
            modifier = Modifier
                .size(200.dp)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SubcomposeAsyncImage(
                model = safeImgUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp)),
                loading = {
                    Text("Loading...")
                },
                error = {
                    Text("Error loading image")
                }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = safeCategory,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
