package com.chapter.chapterkeep.ui.screen.boardScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.model.BoardRecommendData

@Composable
fun BoardRecommendItem(
    item: BoardRecommendData
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .size(320.dp, 150.dp)
            .border(
                width = 5.dp,
                color = colorResource(R.color.main_deepgreen),
                shape = RoundedCornerShape(12.dp)
            )
            .background(color = Color.White, shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(item.imageResId),
            contentDescription = null,
            modifier = Modifier.size(60.dp, 100.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = item.title,
                fontSize = 15.sp,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(
                text = item.writer,
                fontSize = 10.sp,
                color = colorResource(R.color.gray_800)
            )
            Text(
                text = item.genre,
                fontSize = 10.sp,
                color = colorResource(R.color.gray_800),
                modifier = Modifier.padding(bottom = 2.dp)
            )
            Text(
                text = item.detail,
                fontSize = 10.sp,
                color = colorResource(R.color.gray_600),
                maxLines = 2,
                lineHeight = 12.sp,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BoardRecommendPreview() {
    BoardRecommendItem(
        BoardRecommendData(
            imageResId = R.drawable.img_home_book,
            title = "오늘 하루도, 소심한 고양이",
            writer = "이수민",
            genre = "에세이",
            detail = "오늘 하루도, 소심한 고양이 오늘 하루도, 소심한 고양이 오늘 하루도, 소심한 고양이 오늘 하루도, 소심한 고양이 오늘 하루도, 소심한 고양이 오늘 하루도, 소심한 고양이"
        )
    )
}