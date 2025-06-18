package com.example.navigation_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation_compose.ui.theme.Navigation_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation_composeTheme {
//                MyApp() // without argument
                MyAppPassArgument() // with passing argument
            }
        }
    }
}

/*
✅ Step-by-Step Explanation
🔹 Step 1: Entry Point – MainActivity
setContent {
    MyApp()
}
This is the starting point of your app.

setContent {} launches the Compose UI.

Inside it, we call MyApp() which sets up navigation.

🔹 Step 2: Create NavController & NavHost
val navController = rememberNavController()
NavHost(navController, startDestination = "home") {
    composable("home") { HomeScreen(navController) }
    composable("profile") { ProfileScreen() }
}

rememberNavController() creates a controller to manage screen navigation.
NavHost defines the navigation graph (all your app's screens).
startDestination = "home" means the app starts on HomeScreen.
Each composable("route") defines a screen tied to that route.

🔹 Step 3: Define the First Screen – HomeScreen

@Composable
fun HomeScreen(navController: NavController) {
    Button(onClick = { navController.navigate("profile") }) {
        Text("Go to Profile")
    }
}
Displays a button in the center.
When the button is clicked, it navigates to the "profile" route using:
navController.navigate("profile")

🔹 Step 4: Define the Second Screen – ProfileScreen
@Composable
fun ProfileScreen() {
    Text("Welcome to the Profile Screen!")
}
Simple screen showing a welcome message.
This is shown when user navigates from Home → Profile.

🔹 How Navigation Works Internally
App starts → startDestination = "home" → HomeScreen shown.
User clicks button → navController.navigate("profile") triggered.
NavHost matches profile route → ProfileScreen composable is displayed.
Compose rebuilds the screen and shows the new content.

 */


@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("profile") { ProfileScreen() }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { navController.navigate("profile") }) {
            Text("Go to Profile")
        }
    }
}

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Welcome to the Profile Screen!")
    }
}


/*
✅ Goal:
   Navigate from ScreenA to ScreenB
   Pass a string argument (e.g., username)
*/


@Composable
fun MyAppPassArgument() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "screen_a") {
        composable("screen_a") {
            ScreenA(navController)
        }
        composable(
            "screen_b/{username}",
            arguments = listOf(navArgument("username") { type = NavType.StringType })
        ) { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: "NoName"
            ScreenB(username)
        }
    }
}

@Composable
fun ScreenA(navController: NavController) {
    var username by remember { mutableStateOf("JohnDoe") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Enter username") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("screen_b/$username")
        }) {
            Text("Go to Screen B")
        }
    }
}

@Composable
fun ScreenB(username: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Hello, $username!", style = MaterialTheme.typography.headlineMedium)
    }
}