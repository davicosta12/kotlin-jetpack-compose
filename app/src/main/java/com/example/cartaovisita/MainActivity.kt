package com.example.cartaovisita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartaovisita.ui.theme.CartaoVisitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartaoVisitaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CartaoVisitaContainer()
                }
            }
        }
    }
}

@Composable
fun CartaoVisitaContainer() {
    Column(
        modifier = Modifier
            .background(Color(0xFF0a374d))
    ) {
        HeaderCard(modifier = Modifier.weight(7f))-
        ContactCard(modifier = Modifier.weight(2f))
    }
}

@Composable
fun HeaderCard(modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(125.dp)
        )
        TextComponent(
            "Treino Kotlin",
            Color.White,
            45.sp,
            FontWeight.Bold,
            Modifier
        )
        TextComponent(
            "Davi Costa",
            Color(0xFF3ddc84),
            25.sp,
            FontWeight.SemiBold,
            Modifier
        )
    }
}

@Composable
fun ContactCard(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Divider(color = Color.Gray, thickness = 1.dp)
        ContactText("+11 (123) 444 555 666", Icons.Rounded.Phone, Color(0xFF3ddc84))
        Divider(color = Color.Gray, thickness = 1.dp)
        ContactText("@AndroidDev", Icons.Rounded.Share, Color(0xFF3ddc84))
        Divider(color = Color.Gray, thickness = 1.dp)
        ContactText("jen.doe@android.com", Icons.Rounded.Send, Color(0xFF3ddc84))
    }
}

@Composable
fun ContactText(text: String, imageVector: ImageVector, tint: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = tint,
            modifier = Modifier.padding(start = 50.dp)
        )
        Spacer(
            modifier = Modifier
                .size(20.dp)
        )
        Text(
            text = text,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun TextComponent(
    text: String,
    color: Color,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    modifier: Modifier
){
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = color,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CartaoVisitaTheme {
        CartaoVisitaContainer()
    }
}