package com.example.businesscard2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard2.ui.theme.BusinessCard2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCard2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        imageRes = R.drawable.android_logo,
                        name = "Darren Loeffler",
                        title = "Android Dev Birb"
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    @DrawableRes imageRes: Int,
    name: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        CardHeader(
            imageRes = imageRes,
            name = name,
            title = title
        )
    }
}

@Composable
fun CardHeader(
    @DrawableRes imageRes: Int,
    name: String, title: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(painter = painterResource(id = imageRes), contentDescription = null)
        Text(text = name)
        Text(text = title)
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCard2Theme {
    }
}