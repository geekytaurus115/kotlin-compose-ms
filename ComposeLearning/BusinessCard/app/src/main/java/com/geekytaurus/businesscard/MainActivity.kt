package com.geekytaurus.businesscard

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geekytaurus.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   BaseCompose(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}

@Composable
fun BaseCompose(modifier: Modifier = Modifier){
    val fullName = stringResource(R.string.full_name)
    val title = stringResource(R.string.title)
    val profileImage = painterResource(R.drawable.android_logo)

    //contact information
    val contactNumber = stringResource(R.string.contact_number)
    val socialMediaHandle = stringResource(R.string.social_media_handle)
    val emailId = stringResource(R.string.email_id)

   Column(modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
       ) {
       ContactDetails(
           profileImage,
           fullName,
           title
       )

       Spacer(modifier = Modifier.height(200.dp))

       ProfileDetails(
           contactNumber,
           socialMediaHandle,
           emailId
       )
   }
}

}


@Composable
fun ContactDetails(profileImage: Painter, fullName: String, title: String, modifier: Modifier = Modifier) {
Column(modifier,
    horizontalAlignment = Alignment.CenterHorizontally) {
    Box (
        modifier = Modifier
            .size(92.dp)
            .background(color = Color.Black),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = profileImage,
            contentDescription = null,
            modifier.size(72.dp)
        )
    }
    Text(
        text = fullName,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
        )
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF373D3A)
    )
}
}

@Composable
fun ProfileDetails(contactNumber: String, socialMediaHandle: String, emailId: String, modifier: Modifier = Modifier){
    val callLogo = painterResource(R.drawable.baseline_call_24)
    val shareLogo = painterResource(R.drawable.baseline_share_24)
    val emailLogo = painterResource(R.drawable.baseline_email_24)

    Column(
     modifier
 ) {
        Row(
            Modifier.padding(bottom = 10.dp)
        ) {
            Icon(painter = callLogo, contentDescription = null,
                tint = colorResource(R.color.specific))
            Spacer(modifier = Modifier.padding(end = 20.dp))
            Text(text = contactNumber)
        }
        Row (
            Modifier.padding(bottom = 10.dp)
        ){
            Icon(painter = shareLogo, contentDescription = null,
                tint = colorResource(R.color.specific))
            Spacer(modifier = Modifier.padding(end = 20.dp))
            Text(text = socialMediaHandle)
        }
        Row {
            Icon(painter = emailLogo, contentDescription = null,
                tint = colorResource(R.color.specific))
            Spacer(modifier = Modifier.padding(end = 20.dp))
            Text(text = emailId)
        }
 }
}
