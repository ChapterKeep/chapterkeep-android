package com.chapter.chapterkeep.ui.screen.boardScreen.component.board

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.navigate.Routes


@Composable
fun BoardTypeBox(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
    ) {
        Text(
            text = stringResource(R.string.board_board),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.main_green)
        )
        Spacer(Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = colorResource(R.color.gray_600),
                    shape = RoundedCornerShape(12.dp)
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(20.dp)
        ) {
            BoardTypeRow(
                boardName = stringResource(R.string.board_genre),
                onClick = {
                    TODO("게시판으로 화면전환")
                }
            )
            Spacer(Modifier.height(15.dp))
            BoardTypeRow(
                boardName = stringResource(R.string.board_oneline),
                onClick = {
                    TODO("게시판으로 화면전환")
                }
            )
            Spacer(Modifier.height(15.dp))
            BoardTypeRow(
                boardName = stringResource(R.string.board_baekiljang),
                onClick = {
                    navController.navigate(Routes.Baekiljang.route)
                }
            )
            Spacer(Modifier.height(15.dp))
            BoardTypeRow(
                boardName = stringResource(R.string.board_genre),
                onClick = {
                    TODO("게시판으로 화면전환")
                }
            )
        }
    }
}