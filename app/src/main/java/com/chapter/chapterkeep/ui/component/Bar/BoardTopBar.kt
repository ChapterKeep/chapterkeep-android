package com.chapter.chapterkeep.ui.component.Bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.navigate.Routes

@Composable
fun BoardTopBar(
    navController: NavHostController,
    boardName: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(R.drawable.ic_navigate_back),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    navController.navigate(Routes.Board.route) {
                        popUpTo(Routes.Board.route){
                            inclusive = true
                        }
                    }
                }
        )

        Text(
            text = boardName,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.main_green)
        )

        Image(
            painter = painterResource(R.drawable.ic_write),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    navController.navigate(route = Routes.AddBaekiljang.route)
                }
        )
    }
}