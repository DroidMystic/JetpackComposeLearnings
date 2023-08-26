package com.example.bizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizcard.ui.theme.BizcardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizcardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard(){
    val buttonClickedState = remember{
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(12.dp)),
            elevation = CardDefaults.cardElevation(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)

        )
        {
            Column(modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally){
                CreateImageProfile()
                Divider(modifier= Modifier.height(5.dp), color = Color.Black)
                CreateInfo()
                Button(onClick = {
                    buttonClickedState.value= !buttonClickedState.value
                }) {
                    Text(text = "Portfolio", style = MaterialTheme.typography.labelMedium)
                }
                if(buttonClickedState.value){
                    Content()
                }
                else{
                    Box() {

                    }
                }

            }

        }

    }

}
@Preview
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(3.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxSize(),
            shape = RoundedCornerShape(CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)){
            Portfolio(data = listOf("Project 1",
                "Project 2",
                "Project 3",
                "Project 4",
                "Project 5",
                "Project 6"))


        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data){
            item ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxSize(),
                shape = RectangleShape,
                elevation = CardDefaults.cardElevation(4.dp)
                ){
                Row (modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(7.dp)){
                    CreateImageProfile(modifier = Modifier.size(100.dp))
                    Column(modifier = Modifier.padding(7.dp).align(alignment = CenterVertically)){

                        Text(text=item, fontWeight = FontWeight.Bold)
                        Text(text="A great Project", style = MaterialTheme.typography.bodyMedium)
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
            text = "Sabir K.",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
        )
        Text(
            text = "Android Developer",
            modifier = Modifier.padding(3.dp),
        )
        Text(text = "@DroidMystic",
            modifier = Modifier.padding(3.dp)
            )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.size(100.dp),
        shape = CircleShape,
        border = BorderStroke(1.0.dp, Color.LightGray),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.pfp),
            contentDescription = "profile image",
            modifier = modifier.size(130.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun GreetingPreview() {
    BizcardTheme {
        CreateBizCard()
    }
}