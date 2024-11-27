package com.chapter.chapterkeep.ui.screen.boardScreen.component.board

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R

@Composable
fun BoardUserItem(
    title: String,
    heartCount: Int,
    userName: String,
    onClick: ()->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
    ) {
        Spacer(Modifier.height(10.dp))
        Text(
            text = title,
            fontSize = 15.sp
        )
        Spacer(Modifier.height(10.dp))

        Row {
            Image(
                painter = painterResource(R.drawable.ic_heart),
                contentDescription = null,
                modifier = Modifier.size(15.dp),
                colorFilter = ColorFilter.tint(colorResource(R.color.main_pink))
            )
            Spacer(Modifier.width(10.dp))

            Text(
                text = heartCount.toString(),
                fontSize = 10.sp,
                color = colorResource(R.color.main_pink)
            )
            Spacer(Modifier.width(20.dp))

            Text(
                text = userName,
                fontSize = 11.sp,
                color = colorResource(R.color.gray_800)
            )
        }
        Spacer(Modifier.height(10.dp))

        Divider()
    }
}