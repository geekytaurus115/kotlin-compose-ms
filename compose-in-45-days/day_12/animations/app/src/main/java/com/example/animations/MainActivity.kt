package com.example.animations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animations.ui.theme.AnimationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    AnimateDpExample(Modifier.padding(innerPadding))

//                    FAQItem(
//                        Modifier.padding(innerPadding),
//                        question = "What is Jetpack Compose?",
//                        answer = "Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android."
//                    )

//                    ProfileSwitcher(Modifier.padding(innerPadding))

//                    MultiPropertyAnimatedCard(Modifier.padding(innerPadding))

                    LoginRegisterFormToggle(Modifier.padding(innerPadding))

                }
            }
        }
    }
}



@Composable
fun AnimateDpExample( modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    // Animate the size between 100.dp and 200.dp based on the expanded state
    val boxSize by animateDpAsState(targetValue = if (expanded) 200.dp else 100.dp)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(boxSize)
                .background(Color.Blue)
                .clickable { expanded = !expanded } // Toggle on click
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { expanded = !expanded }) {
            Text("Toggle Size")
        }
    }
}


/*
✅ Concepts Covered:
AnimatedVisibility: For smooth show/hide of the answer.
animateContentSize: For smooth height/size change during expansion.
 */

@Composable
fun FAQItem(
    modifier: Modifier = Modifier,
    question: String,
    answer: String
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable { expanded = !expanded }
            .animateContentSize(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = question,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            AnimatedVisibility(visible = expanded) {
                Text(
                    text = answer,
                    fontSize = 16.sp
                )
            }
        }
    }
}

/*
✅ Output Summary:
A toggle switch at the top.
On toggle, profile card changes using Crossfade.
 */

@Composable
fun ProfileSwitcher(modifier: Modifier = Modifier) {
    var showFirstProfile by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Show Profile A")

            Spacer(modifier = Modifier.width(20.dp))

            Switch(
                checked = !showFirstProfile,
                onCheckedChange = { showFirstProfile = !it }
            )

            Spacer(modifier = Modifier.width(20.dp))

            Text("Show Profile B")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Crossfade(targetState = showFirstProfile, label = "ProfileCrossfade") { isFirst ->
            if (isFirst) {
                ProfileCard(name = "Alice", title = "Android Developer")
            } else {
                ProfileCard(name = "Bob", title = "UI/UX Designer")
            }
        }
    }
}

@Composable
fun ProfileCard(name: String, title: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE0F7FA)
        ),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Placeholder for profile picture
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(60.dp)
                )
            }

            Text(name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(title, fontSize = 16.sp, color = Color.Gray)
        }
    }
}



/*
✅ Project: Multi-property Animated Card
🎯 What you'll build:
A card that animates background color, corner radius, and elevation when tapped.

🧠 Concept Focus: updateTransition
updateTransition lets you animate multiple values together based on a state change.
It’s perfect for coordinated animations, like a card expanding, changing shape, or color.

🔧 Use Case in Real Life:
Interactive UI Cards – profile previews, product listings, toggle-able panels.
Enhances visual feedback when users interact with UI components.
 */

@Composable
fun MultiPropertyAnimatedCard(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    val transition = updateTransition(targetState = expanded, label = "Card Transition")

    val backgroundColor by transition.animateColor(label = "Background Color") {
        if (it) Color(0xFFBBDEFB) else Color.White
    }

    val cornerRadius by transition.animateDp(label = "Corner Radius") {
        if (it) 24.dp else 8.dp
    }

    val elevation by transition.animateDp(label = "Elevation") {
        if (it) 12.dp else 4.dp
    }

    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable { expanded = !expanded },
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(cornerRadius),
        elevation = CardDefaults.cardElevation(elevation)
    ) {
        Box(
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = if (expanded) "Expanded Card" else "Collapsed Card")
        }
    }
}


/*
✅ Crossfade
✅ AnimatedVisibility
✅ updateTransition (Transition API)
used in a smooth login/register form toggle with animations.
 */
@Composable
fun LoginRegisterFormToggle(modifier: Modifier = Modifier) {
    var isLogin by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Toggle Button
        Button(onClick = { isLogin = !isLogin }) {
            Text(if (isLogin) "Switch to Register" else "Switch to Login")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Smooth Transition between forms using Crossfade
        Crossfade(targetState = isLogin, label = "formCrossfade") { login ->
            if (login) {
                LoginForm()
            } else {
                RegisterForm()
            }
        }
    }
}

@Composable
fun LoginForm() {
    val visibleState = remember { mutableStateOf(true) }
    val transition = updateTransition(targetState = visibleState.value, label = "loginTransition")

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Login", style = MaterialTheme.typography.headlineSmall)

        Spacer(Modifier.height(16.dp))

        AnimatedVisibility(visible = true) {
            Column {
                OutlinedTextField(value = "", onValueChange = {}, label = { Text("Email") })
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(value = "", onValueChange = {}, label = { Text("Password") })
                Spacer(Modifier.height(16.dp))
                Button(onClick = { }) { Text("Login") }
            }
        }
    }
}

@Composable
fun RegisterForm() {
    val visibleState = remember { mutableStateOf(true) }
    val transition = updateTransition(targetState = visibleState.value, label = "registerTransition")

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Register", style = MaterialTheme.typography.headlineSmall)

        Spacer(Modifier.height(16.dp))

        AnimatedVisibility(visible = true) {
            Column {
                OutlinedTextField(value = "", onValueChange = {}, label = { Text("Username") })
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(value = "", onValueChange = {}, label = { Text("Email") })
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(value = "", onValueChange = {}, label = { Text("Password") })
                Spacer(Modifier.height(16.dp))
                Button(onClick = { }) { Text("Register") }
            }
        }
    }
}
