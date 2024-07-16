package com.example.androidtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidtask.product.ProductListContent
import com.example.androidtask.ui.theme.AndroidTaskTheme
import com.example.androidtask.ui.theme.blue
import com.example.androidtask.ui.theme.blueTextColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTaskTheme {
                // A surface container using the 'background' color from the theme
                MainScreenContent()
            }
        }
    }
}

@Composable
fun MainScreenContent() {

    var searchQuery by remember {

        mutableStateOf("")
    }

    Column (modifier = Modifier
        .padding(start = 17.dp, end = 17.dp, top = 8.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.route_logo),
            contentDescription = "route logo" ,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth(.25f)
                )

        Row(modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth(1f),
            verticalAlignment = Alignment.CenterVertically

        ) {

            OutlinedTextField(
                value = searchQuery ,
                onValueChange ={
                    searchQuery = it
                },
                shape = RoundedCornerShape(30.dp),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(0.88f)
                    .fillMaxHeight(0.08f)

                ,
                leadingIcon = {

                    Image(painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "search_icon",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(20.dp))

                },
                placeholder = {

                    Text(text = "What do you search for?", color = blueTextColor)
                },
                colors = OutlinedTextFieldDefaults.colors(

                    focusedContainerColor= Color.Transparent,
                    unfocusedContainerColor= Color.Transparent,
                    disabledContainerColor= Color.Transparent,
                    focusedBorderColor= blue,
                    unfocusedBorderColor = blue,
                    disabledBorderColor = blue
                )

            )

            Spacer(modifier = Modifier.weight(1f))

            Image(painter = painterResource(id = R.drawable.cart_ic),
                contentDescription = "cart_icon",
                modifier = Modifier
                    .size(30.dp)
                    .padding(end = 8.dp)
                    )
        }
        ProductListContent()
    }

}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MainScreenContent()
}