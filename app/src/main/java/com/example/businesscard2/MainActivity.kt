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
                        headerName = R.string.darren_loeffler,
                        headerTitle = R.string.android_dev_birb,
                        phoneNumber = R.string.phone_number,
                        socialMediaHandle = R.string.social_media_handle,
                        email = R.string.email
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    @StringRes headerName: Int,
    @StringRes headerTitle: Int,
    @StringRes phoneNumber: Int,
    @StringRes socialMediaHandle: Int,
    @StringRes email: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        CardHeader(
            name = headerName,
            title = headerTitle
        )
        CardContactInfo(
            phoneNumber = phoneNumber,
            socialMediaHandle = socialMediaHandle,
            email = email
        )
    }
}

@Composable
fun CardHeader(
    @StringRes name: Int,
    @StringRes title: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null
        )
        Text(
            text = stringResource(id = name)
        )
        Text(
            text = stringResource(id = title)
        )
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
        ContactItem(icon = , contactInfo = phoneNumber)
        ContactItem(icon = , contactInfo = socialMediaHandle)
        ContactItem(icon = , contactInfo = email)
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