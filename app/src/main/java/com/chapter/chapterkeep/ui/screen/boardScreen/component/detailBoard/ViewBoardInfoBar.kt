package com.chapter.chapterkeep.ui.screen.boardScreen.component.detailBoard

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.component.DropDown2Menu

@Composable
fun ViewBoardInfoBar(
    title: String,
    image: String,
    writer: String,
    date: String,
    navController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            DropDown2Menu(navController)
        }
        Spacer(Modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(R.drawable.img_profile_select),
                contentDescription = "",
                modifier = Modifier
                    .size(35.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.5.dp,
                        color = colorResource(R.color.main_green),
                        shape = CircleShape
                    ),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.width(10.dp))

            Column{
                Text(
                    text = writer,
                    fontSize = 12.sp,
                    color = colorResource(R.color.gray_800)
                )
                Text(
                    text = date,
                    fontSize = 12.sp,
                    color = colorResource(R.color.gray_800)
                )
            }
        }
    }
}

@Preview
@Composable
fun InfoBarPreview() {
    val navController = rememberNavController()

    ViewBoardInfoBar(
        title = "떨어지는 잎",
        image = "",
        writer = "챕터킵 개발자",
        date = "2024-07-04",
        navController = navController
    )
}