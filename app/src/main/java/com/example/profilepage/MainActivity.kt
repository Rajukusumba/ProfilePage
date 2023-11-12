package com.example.profilepage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilepage.ui.theme.ProfilePageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfilePageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Preview
@Composable
fun CreateCircle() {
 var moneyCounter by remember {
     mutableStateOf(0)
 }
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(16.dp),
        color = Color.Blue
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .size(100.dp)
                    .clickable {
                        moneyCounter += 1
                    },
                elevation = 30.dp,
                shape = CircleShape,
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = "Tap $moneyCounter", modifier = Modifier)
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "$moneyCounter", color = Color.White, style = TextStyle(fontSize = 30.sp
            , fontWeight = FontWeight.Bold))


        }


    }
}

@Composable
fun CreateBizCard() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .fillMaxHeight()
                .padding(12.dp)
                .fillMaxWidth(),
            elevation = 8.dp,
            backgroundColor = Color.White,
            shape = RoundedCornerShape(CornerSize(15.dp)),
        ) {
            Column(
                modifier = Modifier.height(300.dp), verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateImageProfile()
                Divider(
//                    thickness = 2.dp,
//                    color = Color.Blue
                    //startIndent = 123.dp for start after 123 dp
                )
                CreateInfo()
                Button(onClick = {
                    // Log.d("Clicked", "CreateBizCard:Clicked button")
                    buttonClickedState.value = !buttonClickedState.value
                }) {
                    Text(
                        text = "Portfolio",
                        style = MaterialTheme.typography.button
                    )
                }
                if (buttonClickedState.value) {
                    Content()
                } else {
                    CreateCircle()
//                    Box() {
//                    }
                }
            }
        }
    }

}

@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(3.dp)
    ) {
        Surface(
            Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.DarkGray)
        ) {
            Portfolio(
                data = listOf(
                    "Project 1",
                    "Portfilio 2",
                    "Portfolio 3",
                    "Project 1",
                    "Portfilio 2",
                    "Portfolio 3",
                    "Project 1",
                    "Portfilio 2",
                    "Portfolio 3",
                    "Project 1",
                    "Portfilio 2",
                    "Portfolio 3"
                )
            )
        }
    }

}

@Composable
fun Portfolio(data: List<String>) {
    //  Text(text = "Portfolio Projects Here")
    LazyColumn {
        items(data) { item ->
            Card(
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth(),
                border = BorderStroke(5.dp, color = MaterialTheme.colors.surface),
                elevation = 8.dp,
                shape = RectangleShape
            ) {
                  Row(
                    modifier = Modifier
                        .padding()
                        .background(MaterialTheme.colors.surface)
                        .padding(8.dp)
                ) {
                    CreateImageProfile(modifier = Modifier.size(60.dp))
                    Column(
                        modifier = Modifier
                            .padding(6.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "A Great Projecrt", style = MaterialTheme.typography.body2)
                    }

                }

            }

        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            color = MaterialTheme.colors.primaryVariant,
            text = "Raju.K",
            style = MaterialTheme.typography.h4
        )
        Text(
            text = "Mobile Application Developer",
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = "@Effia Soft",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.Green),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "hggj",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )


    }

}

