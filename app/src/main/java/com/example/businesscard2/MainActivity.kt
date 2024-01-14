package com.example.businesscard2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                        headerImage = R.drawable.android_logo,
                        headerName = R.string.darren_loeffler,
                        headerTitle = R.string.android_dev_birb
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    @DrawableRes headerImage: Int,
    @StringRes headerName: Int,
    @StringRes headerTitle: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        CardHeader(
            image = headerImage,
            name = headerName,
            title = headerTitle
        )
    }
}

@Composable
fun CardHeader(
    @DrawableRes image: Int,
    @StringRes name: Int,
    @StringRes title: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(painter = painterResource(id = image), contentDescription = null)
        Text(text = stringResource(id = name))
        Text(text = stringResource(id = title))
    }
}

@Composable
fun CardContactInfo(
    @StringRes phoneNumber: Int,
    @StringRes socialMediaHandle: Int,
    @StringRes email: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {


    }

}

@Composable
fun ContactItem(
    @DrawableRes icon: Int,
    @StringRes contactInfo: Int
) {
    Row {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null
        )
        Text(
            text = stringResource(id = contactInfo)
        )
    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCard2Theme {
    }
}