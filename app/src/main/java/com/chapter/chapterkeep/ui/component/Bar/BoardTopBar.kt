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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.R

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
                    TODO("게시판 화면으로 이동")
                }
        )

        Text(
            text = stringResource(R.string.baekiljang_board),
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
                    TODO("백일장 게시판 글 등록 화면으로 이동")
                }
        )
    }
}