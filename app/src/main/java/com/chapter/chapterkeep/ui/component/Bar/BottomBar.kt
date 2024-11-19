package com.chapter.chapterkeep.ui.component.Bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.navigate.Routes

@Composable
fun BottomBar(
    selected: Int,
    navController: NavHostController
) {
    val imageSize : Dp = 25.dp
    val fontSize = 12.sp

    var homeImage = R.drawable.ic_home_gray
    var homeColor = R.color.gray_600
    var searchImage = R.drawable.ic_search_gray
    var searchColor = R.color.gray_600
    var boardImage = R.drawable.ic_board_gray
    var boardColor = R.color.gray_600
    var myImage = R.drawable.ic_my_gray
    var myColor = R.color.gray_600

    when (selected) {
        1 -> {
            searchImage = R.drawable.ic_search_green
            searchColor = R.color.sub_green
        }

        2 -> {
            homeImage = R.drawable.ic_home_green
            homeColor = R.color.sub_green
        }

        3 -> {
            boardImage = R.drawable.ic_board_green
            boardColor = R.color.sub_green
        }

        4 -> {
            myImage = R.drawable.ic_my_green
            myColor = R.color.sub_green
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ){
        Column {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(80.dp)
                ,
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                CreateTap(navController, Routes.Search.route, searchImage, searchColor, imageSize, fontSize, "검색")
                CreateTap(navController, Routes.Home.route, homeImage, homeColor, imageSize, fontSize, "홈")
                CreateTap(navController, Routes.Board.route, boardImage, boardColor, imageSize, fontSize, "게시판")
                CreateTap(navController, Routes.My.route, myImage, myColor, imageSize, fontSize, "MY")
            }
        }
    }
}

@Composable
fun CreateTap(
    navController: NavHostController,
    route:String,
    image:Int,
    textColor:Int,
    imageSize: Dp,
    fontSize: TextUnit,
    text:String
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable {
                navController.navigate(route){
                    popUpTo(route){
                        inclusive = true
                    }
                }
            }
            .size(80.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .size(imageSize)
        )
        Text(
            text = text,
            fontSize = fontSize,
            color = colorResource(id = textColor)
        )
    }
}