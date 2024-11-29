package com.geekytaurus.ui_userprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geekytaurus.ui_userprofile.ui.theme.UI_UserProfileTheme
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Facebook
import compose.icons.fontawesomeicons.brands.Linkedin
import compose.icons.fontawesomeicons.brands.Twitter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UI_UserProfileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserProfileUI(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun UserProfileUI(modifier: Modifier){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box{
           Image(painter = painterResource(id = R.drawable.kid_profile_1),
               contentDescription = "Profile Picture",
               modifier = Modifier
                   .size(100.dp)
                   .clip(CircleShape)
                   .border(2.dp, Color.Gray, CircleShape)
           )
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(Color.Red, CircleShape)
                    .align(Alignment.TopEnd)
            ){
                Text(text = "3",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text("John Doe", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text("Android Developer", fontSize = 14.sp, color = Color.Gray)
        Row(
          modifier = Modifier.padding(top = 8.dp)

        ){
         Icon(
             imageVector = FontAwesomeIcons.Brands.Facebook,
             contentDescription = "Facebook", tint = Color.Blue,
             modifier = Modifier.size(24.dp)
         )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                imageVector = FontAwesomeIcons.Brands.Twitter,
                contentDescription = "Twitter", tint = Color.Cyan,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                imageVector = FontAwesomeIcons.Brands.Linkedin,
                contentDescription = "LinkedIn", tint = Color.Blue,
                modifier = Modifier.size(24.dp)
            )
        }
        
    }
}