package com.chapter.chapterkeep.ui.screen.bookScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chapter.chapterkeep.R

@Composable
fun AddBookStar(starStates: MutableList<Boolean>) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        AddBookTitle(R.string.addbook_star)
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            starStates.forEachIndexed { index, isYellow ->
                Image(
                    painter = painterResource(
                        if (isYellow) R.drawable.icon_star_yellow else R.drawable.icon_star_gray
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(35.dp)
                        .clickable {
                            starStates[index] = !starStates[index]
                        }
                )

                if (index < starStates.size - 1) {
                    Spacer(modifier = Modifier.width(8.dp)) // 원하는 크기로 설정 (예: 8.dp)
                }
            }
        }
    }
}