package com.example.businesscard2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                        email = R.string.email,
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        CardHeader(
            name = headerName,
            title = headerTitle,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.weight(1f))

        CardContactInfo(
            phoneNumber = phoneNumber,
            socialMediaHandle = socialMediaHandle,
            email = email,
            modifier = Modifier.weight(1f)
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
            modifier = Modifier
                .background(Color.Cyan)
                .width(115.dp),
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
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.background(Color.Red).padding(bottom = 16.dp)
    ) {
        ContactItem(
            icon = R.drawable.call_black_24dp ,
            contactInfo = phoneNumber
        )
        ContactItem(
            icon = R.drawable.share_black_24dp,
            contactInfo = socialMediaHandle
        )
        ContactItem(
            icon = R.drawable.email_black_24dp,
            contactInfo = email
        )
    }
}

@Composable
fun ContactItem(
    @DrawableRes icon: Int,
    @StringRes contactInfo: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(bottom = 12.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.padding(end = 24.dp)
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