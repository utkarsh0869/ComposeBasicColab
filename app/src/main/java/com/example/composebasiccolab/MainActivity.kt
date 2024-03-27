package com.example.composebasiccolab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasiccolab.ui.theme.ComposeBasicColabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicColabTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Column {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            color = Color.LightGray,
        ) {
            Column {
                Greeting(name = "Hello Android!")
                Spacer(modifier = Modifier.height(16.dp))
                Greeting(name = "Welcome to Jetpack Compose!")
            }
        }
        Greeting2()
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Greeting2() {
    Column(
        modifier = Modifier
            .padding(all = 8.dp)
            .background(Color.LightGray)
            .fillMaxWidth()

    ) {
        Text("This is greetings 2!")
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComposeBasicColabTheme {
//        Greeting("Androids")
//    }
//}

@Preview(name = "name can be set here too", showBackground = true)
@Composable
fun MyAppPreview() {
    ComposeBasicColabTheme {
        MyApp()
    }
}