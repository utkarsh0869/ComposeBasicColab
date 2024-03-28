package com.example.composebasiccolab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasiccolab.ui.theme.ComposeBasicColabTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

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
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    if(shouldShowOnboarding) {
        // we do not want the composable to mutate our state, it would be better to let it notify
        // us when the user clicked on the continue button
        // we can achieve this by passing callbacks down
        // Callbacks are functions that are passed as arguments to other functions and get executed
        // when the event occurs.
        //By passing a function and not a state to OnboardingScreen we are making this composable
        // more reusable and protecting the state from being mutated by other composables.
        // In general, it keeps things simple.
        OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false})
    } else {
        Greetings()
    }
}
@Composable
fun Greetings(names: List<String> = List(100) {"$it"}) {
    Column {
        LazyColumn {
            items(names) {
                Greeting(name = it)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }
    val extraPadding = if (expanded) 48.dp else 0.dp
    Surface(color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello,")
                Text(text = name)
            }
            ElevatedButton(onClick = { expanded = !expanded }) {
                Text(if(expanded) "Show Less" else "Show More")
            }
        }
    }
}


@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onContinueClicked: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    ComposeBasicColabTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}
@Preview(name = "name can be set here too", showBackground = true)
@Composable
fun MyAppPreview() {
    ComposeBasicColabTheme {
        MyApp()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicColabTheme {
        Greetings()
    }
}