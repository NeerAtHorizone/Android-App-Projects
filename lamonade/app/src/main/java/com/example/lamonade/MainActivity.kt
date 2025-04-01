package com.example.lamonade

import android.os.Bundle
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lamonade.ui.theme.LamonadeTheme
import java.util.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LamonadeTheme {                LamonadeApp()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LamonadePreview() {
    LamonadeTheme {
        LamonadeApp()
    }
}

@Composable
fun LamonadeApp(){
    TreeLamonGlass()
}

@Composable
fun TreeLamonGlass() {
    var nextImage by remember { mutableIntStateOf(0) }
    var squizeCount by remember { mutableIntStateOf(2) }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val imageResource = when (nextImage) {
            0 -> R.drawable.lemon_tree
            in 1..squizeCount -> R.drawable.lemon_squeeze
            squizeCount + 1 -> R.drawable.lemon_drink
            else -> R.drawable.lemon_restart
        }
        val imageText = when (nextImage) {
            0 -> stringResource(id = R.string.lemonTree)
            in 1..squizeCount -> stringResource(id = R.string.lemon)
            squizeCount + 1 -> stringResource(id = R.string.glassOfLemoade)
            else -> stringResource(id = R.string.emptyGlass)
        }
            Text(
                text = "Lemonade",
                fontSize = 32.sp,
                modifier = Modifier
                    .background(Color(200, 250, 100))
                    .fillMaxWidth()
                    .padding(16.dp)
                    .wrapContentSize(Alignment.Center)
            )

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                 horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Button(
                    onClick = {
                        if (nextImage in 0..squizeCount + 1)
                            nextImage++
                        else {
                            nextImage = 0
                            squizeCount = kotlin.random.Random.nextInt(6,10)
                        }
                     },
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ) {
                    Image(painter = painterResource(id = imageResource), contentDescription = null)
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = imageText)
            }





    }
}