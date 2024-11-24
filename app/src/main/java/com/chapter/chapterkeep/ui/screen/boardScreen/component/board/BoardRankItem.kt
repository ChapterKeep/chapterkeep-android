package com.chapter.chapterkeep.ui.screen.boardScreen.component.board

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.model.BoardRankData

@Composable
fun BoardRankItem(
    item: BoardRankData
) {
    val isFirstPlace = item.rank == 1

    Box(
        modifier = Modifier.size(135.dp, 170.dp)
    ) {
        if (isFirstPlace) {
            Image(
                painter = painterResource(R.drawable.img_board_rank_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.img_profile_select),
                contentDescription = "",
                modifier = Modifier
                    .size(if (isFirstPlace) 80.dp else 60.dp)
                    .clip(CircleShape)
                    .border(
                        width = 3.dp,
                        color = colorResource(R.color.main_green),
                        shape = CircleShape
                    ),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(77.dp)
                    .border(
                        width = 1.dp,
                        color = colorResource(R.color.gray_600),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(bottom = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = item.title,
                    fontSize = 15.sp
                )
                Spacer(Modifier.height(3.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_heart),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .size(12.dp)
                    )
                    Text(
                        text = item.likes.toString(),
                        fontSize = 8.sp
                    )
                    Spacer(Modifier.width(10.dp))

                    Text(
                        text = item.userName,
                        fontSize = 10.sp,
                        color = colorResource(R.color.gray_800)
                    )
                }
            }
        }

        Text(
            text = item.rank.toString() + stringResource(R.string.board_rank),
            fontSize = 13.sp,
            color = colorResource(R.color.white),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 70.dp)
                .background(
                    color = colorResource(R.color.main_green),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(
                    horizontal = if (isFirstPlace) 15.dp else 12.dp,
                    vertical = if (isFirstPlace) 12.dp else 8.dp
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BoardScreenPreview() {
    BoardRankItem(
        BoardRankData(
            imageResId = R.drawable.img_profile_select,
            rank = 2,
            title = "Best Chapter",
            likes = 123,
            userName = "Alice"
        )
    )
}