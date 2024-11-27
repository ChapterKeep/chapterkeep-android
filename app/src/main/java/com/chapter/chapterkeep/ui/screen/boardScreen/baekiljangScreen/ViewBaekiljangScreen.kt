package com.chapter.chapterkeep.ui.screen.boardScreen.baekiljangScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.navigate.Routes
import com.chapter.chapterkeep.ui.screen.boardScreen.component.detailBoard.ViewBoardInfoBar
import com.chapter.chapterkeep.ui.screen.boardScreen.component.detailBoard.ViewBoardTopBar

@Composable
fun ViewBaekiljangScreen(
    navController: NavHostController
) {
    val title = "떨어지는 잎"
    val image = ""
    val writer = "챕터킵 개발자"
    val date = "2024-07-04"
    val detail = "바람이 스치자마자 나무에서 마지막 잎이 떨어졌다. 하늘을 유영하는 듯 천천히 내려오는 잎을 바라보며 나는 생각했다. 계절이 가고 있구나. 가지를 떠나고 나면 그 잎은 흙이 되고, 나무는 다시 혼자가 된다. 그러나 그 나무는 알까? 새봄이 오면 다시금 새잎을 틔울 수 있다는 걸. 가벼워진 가지는 이 겨울을 온전히 견디며 다시 꽃을 피울 준비를 하고 있다."
    val heartCount = 55

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ){
        ViewBoardTopBar(
            title = stringResource(R.string.baekiljang_board),
            onClick = {
                navController.navigate(Routes.Baekiljang.route) {
                    popUpTo(Routes.Baekiljang.route){
                        inclusive = true
                    }
                }
            }
        )
        Spacer(Modifier.height(20.dp))

        ViewBoardInfoBar(
            title = title,
            image = image,
            writer = writer,
            date = date,
            navController = navController
        )
        Spacer(Modifier.height(20.dp))

        Text(
            text = detail,
            fontSize = 14.sp
        )
        Spacer(Modifier.height(30.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_heart),
                contentDescription = null,
                tint = colorResource(R.color.main_pink)
            )
            Spacer(Modifier.width(8.dp))

            Text(
                text = heartCount.toString(),
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(R.color.main_pink)
            )
        }
    }
}

@Preview
@Composable
fun ViewBaekiljangScreenReview(
) {
    val navController = rememberNavController()
    ViewBaekiljangScreen(navController)
}