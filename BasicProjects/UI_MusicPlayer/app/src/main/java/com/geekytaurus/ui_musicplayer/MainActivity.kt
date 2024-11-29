package com.geekytaurus.ui_musicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geekytaurus.ui_musicplayer.ui.theme.UI_MusicPlayerTheme
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Backward
import compose.icons.fontawesomeicons.solid.Forward
import compose.icons.fontawesomeicons.solid.Play

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UI_MusicPlayerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MusicPlayer(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MusicPlayer(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.album_art),
                contentDescription = "Album Art",
                modifier = Modifier.size(150.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Song Title", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text("Artist Name", fontSize = 16.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            //    implementation("br.com.devsrsouza.compose.icons.android:font-awesome:1.0.0")
            Icon(
                imageVector = FontAwesomeIcons.Solid.Backward, // FontAwesome SkipPrevious equivalent
                contentDescription = "Previous",
                modifier = Modifier.size(32.dp),
                tint = Color.Black
            )
            Icon(
                imageVector = FontAwesomeIcons.Solid.Play, // FontAwesome Play equivalent
                contentDescription = "Play",
                modifier = Modifier.size(32.dp),
                tint = Color.Black
            )
            Icon(
                imageVector = FontAwesomeIcons.Solid.Forward, // FontAwesome SkipNext equivalent
                contentDescription = "Next",
                modifier = Modifier.size(32.dp),
                tint = Color.Black
            )
        }
    }
}
