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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.model.BoardRankData

@Composable
fun BoardRank(
    items: List<BoardRankData>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Text(
            text = stringResource(R.string.board_baekiljang),
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
            items(items.size){ index->
                if (index == 0) {
                    Spacer(modifier = Modifier.width(20.dp))
                }
                BoardRankItem(item = items[index])
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoardRankPreview() {
    val sampleItems = listOf(
        BoardRankData(
            imageResId = R.drawable.img_profile_select,
            rank = 1,
            title = "Best Chapter",
            likes = 123,
            userName = "Alice"
        ),
        BoardRankData(
            imageResId = R.drawable.img_profile_select,
            rank = 2,
            title = "Great Read",
            likes = 98,
            userName = "Bob"
        ),
        BoardRankData(
            imageResId = R.drawable.img_profile_select,
            rank = 3,
            title = "Popular Story",
            likes = 76,
            userName = "Charlie"
        )
    )

    BoardRank(items = sampleItems)
}