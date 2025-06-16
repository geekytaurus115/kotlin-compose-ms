package com.example.lazy_col_row

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazy_col_row.ui.theme.Lazy_col_rowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lazy_col_rowTheme {
               Scaffold { innerPadding ->
//                TaskListScreenWithScrollbar(
//                    modifier = Modifier.padding(innerPadding)
//                )


                   HomeScreen(
                       modifier = Modifier.padding(innerPadding)
                   )
            }

            }
            }
        }
    }


@Composable
fun TaskListScreen(){
    val tasks = listOf(
        Task("Buy groceries", "Done"),
        Task("Finish Compose project", "In Progress"),
        Task("Read documentation", "Not Started"),
        Task("Water plants", "Done"),
        Task("Call client", "In Progress"),
        Task("Prepare dinner", "Not Started"),
        Task("Go for a walk", "Done"),
                Task("Buy groceries", "Done"),
    Task("Finish Compose project", "In Progress"),
    Task("Read documentation", "Not Started"),
    Task("Water plants", "Done"),
    Task("Call client", "In Progress"),
    Task("Prepare dinner", "Not Started"),
    Task("Go for a walk", "Done"),
    Task("Buy groceries", "Done"),
    Task("Finish Compose project", "In Progress"),
    Task("Read documentation", "Not Started"),
    Task("Water plants", "Done"),
    Task("Call client", "In Progress"),
    Task("Prepare dinner", "Not Started"),
    Task("Go for a walk", "Done")
    )

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
       items(tasks){ task ->
           TaskItem(task)
       }
    }
}


data class Task(val title: String, val status: String)


@Composable
fun TaskItem(task: Task){
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ){
        Row(
           modifier = Modifier
               .fillMaxWidth()
               .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text("📝 ${task.title}")
            Text(getStatusEmoji(task.status) + " " + task.status)
        }
    }
}


fun getStatusEmoji(status: String): String = when (status) {
    "Done" -> "✅"
    "In Progress" -> "⏳"
    else -> "❌"
}


// another one
@Composable
fun TaskListScreenWithScrollbar(modifier: Modifier = Modifier) {
    val tasks = List(30) { index ->
        Task("Task #$index", if (index % 3 == 0) "Done" else if (index % 3 == 1) "In Progress" else "Not Started")
    }

    val listState = rememberLazyListState()

    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 12.dp), // Leave space for scrollbar
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(tasks) { task ->
                TaskItem(task)
            }
        }

        VerticalScrollbar(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .fillMaxHeight()
                .width(4.dp),
            scrollState = listState
        )
    }
}


@Composable
fun VerticalScrollbar(
    modifier: Modifier = Modifier,
    scrollState: LazyListState
) {
    val totalItems = scrollState.layoutInfo.totalItemsCount
    val visibleItems = scrollState.layoutInfo.visibleItemsInfo.size

    if (totalItems == 0 || visibleItems == 0) return

    val firstVisibleItem = scrollState.firstVisibleItemIndex
    val scrollFraction = firstVisibleItem.toFloat() / totalItems
    val thumbHeightFraction = visibleItems.toFloat() / totalItems

    Box(modifier) {
        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(thumbHeightFraction)
                .align(Alignment.TopStart)
                .offset {
                    IntOffset(
                        x = 0,
                        y = (scrollFraction * (scrollState.layoutInfo.viewportEndOffset - 20)).toInt()
                    )
                }
                .background(Color.Gray, shape = RoundedCornerShape(2.dp))
        )
    }
}


// ******* Lazy Row *******

@Composable
fun CategoryRow() {
    val categories = listOf("🔥 Hot", "🎵 Music", "📚 Books", "🎮 Games", "🎬 Movies", "🌍 Travel")

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(categories) { category ->
            CategoryChip(category)
        }
    }
}

@Composable
fun CategoryChip(label: String) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F7FA)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text(
            text = label,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
    ) {
        Text(
            text = "Categories",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )
        CategoryRow()
    }
}
