package com.chapter.chapterkeep.ui.screen.boardScreen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.model.BoardRecommendData

@Composable
fun BoardRecommend(
    items: List<BoardRecommendData>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Text(
            text = stringResource(R.string.board_today_recommend),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.main_green),
            modifier = Modifier
                .padding(start = 20.dp)
        )
        Spacer(Modifier.height(20.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            items(items.size) { index ->
                if (index == 0) {
                    Spacer(modifier = Modifier.width(20.dp))
                }

                BoardRecommendItem(item = items[index])
            }
        }
    }
}