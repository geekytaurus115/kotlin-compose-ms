package com.example.compose45.day_02_fundamentals

import android.content.Intent
import android.net.Uri
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.compose45.R
import androidx.compose.ui.graphics.ColorFilter


@Composable
fun ProfileCardUI(){

    var girl1 = painterResource(R.drawable.girl_kid_profile_1)
    var girl2 = painterResource(R.drawable.girl_kid_profile_2)
    var boy1 = painterResource(R.drawable.boy_kid_profile_1)
    var boy2 = painterResource(R.drawable.boy_kid_profile_2)


    Box (
        //Parent container
        modifier = Modifier.fillMaxSize()
            .background(color = Color.Gray)
    ){
       Column(){
           // Top Box
           Box (
               modifier = Modifier.fillMaxWidth()
                   .weight(1f)
                   .background(brush = Brush.verticalGradient(
                       colors = listOf(
                           Color(0xFFF32E4B),
                           Color(0xFFFFADBA)
                       )
                   ))
           )

           // Bottom Box
           Box(
               modifier = Modifier.fillMaxWidth()
                   .weight(3f)
                   .background(color = Color.White)
           ){

               Row(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.Center
               ){
                   // DP circle
                   Box(
                       modifier = Modifier
                           .size(150.dp)

                           .zIndex(1f)
                           .offset(y = -70.dp)
                           .background(color = Color.Blue, shape = CircleShape)
                           .border(5.dp, color = Color.White, shape = CircleShape)
                           .clip(CircleShape)
                   ){
                       Image(painter = girl1,
                           contentDescription = "profile picture",
                           contentScale = ContentScale.Crop,
                           modifier = Modifier.fillMaxSize()

                       )
                   }
               }


               Column(
                   modifier = Modifier.fillMaxWidth()
                       .padding(10.dp),
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {
                   Spacer(modifier = Modifier.height(80.dp))

                   //Name
                   Text("Lucy Diamond",
                       fontSize = 24.sp,
                       fontWeight = FontWeight.Bold
                   )

                   Spacer(modifier = Modifier.height(8.dp))

                   //Designation
                   Text("Head of Sales",
                       fontSize = 16.sp
                   )

                   Spacer(modifier = Modifier.height(8.dp))

                   //Location
                   Row {
                        Image(painterResource(R.drawable.baseline_location_on_24),
                            contentDescription = "location",
                            modifier = Modifier.size(16.dp)
                            )

                       Spacer(modifier = Modifier.width(3.dp))

                       Text("New York - Stadware Co.")
                   }

                   Spacer(modifier = Modifier.height(24.dp))

                   //Button
                   Button(onClick = {},
                       colors = ButtonDefaults.buttonColors(
                           containerColor = Color(0xFFFA3554)
                       ),
                       modifier = Modifier.fillMaxWidth()
                           .padding(start = 24.dp, end = 24.dp)
                   ) {
                       Text("Exchange Contact",
                           fontWeight = FontWeight.Bold)
                   }

                   Spacer(modifier = Modifier.height(48.dp))

                   // Let's Connect
                   Text("LET'S CONNECT",
                       fontSize = 16.sp,
                       fontWeight = FontWeight.Bold

                   )

                   Spacer(modifier = Modifier.height(18.dp))

                   // Social Icons
                   Row (){
                       //Instagram
                       SocialIcon(
                           iconResId = R.drawable.ic_instagram,
                           contentDescription = "Instagram",
                           url = "https://instagram.com/"
                       )

                       Spacer(modifier = Modifier.width(110.dp))

                       //LinkedIn
                       SocialIcon(
                           iconResId = R.drawable.ic_linkedin,
                           contentDescription = "Linkedin",
                           url = "https://linkedin.com/"
                       )
                   }

                   Spacer(modifier = Modifier.height(36.dp))

                   // Our Team
                   Text("OUR TEAM",
                       fontSize = 16.sp,
                       fontWeight = FontWeight.Bold

                   )

                   Spacer(modifier = Modifier.height(18.dp))

                   // Profiles
                   Row (){
                       ProfileCard(boy1, "Jack", "Software Engineer")
                       Spacer(modifier = Modifier.width(10.dp))
                       ProfileCard(girl2, "Carlie", "HR Head")
                       Spacer(modifier = Modifier.width(10.dp))
                       ProfileCard(boy2, "Raja", "Marketing Director")
                   }

               }
           }




       }
    }
}

@Composable
fun ProfileCard(
    image: Painter,
    name: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .border(3.dp, color = Color(0xFFFC7A51), shape = CircleShape)
                .clip(shape = CircleShape)
                .background(Color.Gray), // fallback bg if image has transparent parts
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = role,
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun SocialIcon(
    iconResId: Int,
    url: String,
    contentDescription: String = "",
    iconSize: Dp = 36.dp,
    iconColor: Color = Color(0xFFFA3554)
) {
    val context = LocalContext.current

    IconButton(
        onClick = {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        },
        modifier = Modifier.size(iconSize)
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = contentDescription,
            tint = iconColor, // shows icon's original colors
            modifier = Modifier.fillMaxSize()
        )
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun PreviewProfileCard(){
//    ProfileCardUI()
//
//}