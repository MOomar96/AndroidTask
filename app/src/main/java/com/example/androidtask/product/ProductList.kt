package com.example.androidtask.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.androidtask.R
import com.example.androidtask.ui.theme.blueBorder
import com.example.androidtask.ui.theme.blueTextColor

@Composable
fun ProductListContent(viewModel: ProductViewModel = hiltViewModel()) {

    LaunchedEffect(key1 = Unit){
        viewModel.getProductsFromRepository()
    }


    //if (!viewModel.productsList.isEmpty()){
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 18.dp, ),
            horizontalArrangement = Arrangement.spacedBy(17.dp)
        ) {
            items(viewModel.productsList.size) {
                Box(
                    modifier = Modifier
                        .padding(bottom = 17.dp)
                        .size(220.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .border(3.dp, blueBorder, RoundedCornerShape(10.dp))
                        .background(Color.Transparent, RoundedCornerShape(10.dp))

                ) {


                    Column(
                    ) {
                        AsyncImage(
                            model = viewModel.productsList[it]!!.thumbnail,
                            contentDescription = "updateCartProduct image",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxWidth(1f)
                                .height(110.dp)
                        )

                        Column(
                            modifier = Modifier
                                .padding(top = 10.dp, bottom = 10.dp, start = 8.dp, end = 8.dp)
                        ) {

                            Text(
                                text = viewModel.productsList[it]!!.title ?: "",
                                fontSize = 14.sp,
                                color = blueTextColor,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = viewModel.productsList[it]!!.description ?: "",
                                fontSize = 14.sp,
                                color = blueTextColor,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )

                            Text(
                                text = "EGP ${viewModel.productsList[it]!!.price ?: ""}",
                                fontSize = 14.sp,
                                color = blueTextColor,
                                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(1f),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "Review (${viewModel.productsList[it]!!.rating})")
                                Image(
                                    painter = painterResource(id = R.drawable.rating_stars),
                                    contentDescription = "rating star",
                                    modifier = Modifier
                                        .padding(start = 2.dp)
                                        .size(15.dp)
                                )
                            }

                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier
                            .padding(end = 6.dp, bottom = 10.dp, top = 6.dp)
                            .fillMaxSize(1f)
                    ) {

                        val favoriteClicked = remember {
                            mutableStateOf(false)
                        }
                        Image(
                            painter = if (favoriteClicked.value == false) painterResource(id = R.drawable.favorite_unselected_ic)
                            else painterResource(id = R.drawable.favorite_selected_ic),
                            contentDescription = "",
                            modifier = Modifier
                                .size(28.dp)

                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Image(
                            painter = painterResource(id = R.drawable.circle_plus_ic),
                            contentDescription = "",
                            modifier = Modifier
                                .size(28.dp)

                        )
                    }
                }
            }
        }
    }
//}

@Preview (showBackground = true , showSystemUi = true)
@Composable
fun ProductListContactPreview() {
    ProductListContent()
}