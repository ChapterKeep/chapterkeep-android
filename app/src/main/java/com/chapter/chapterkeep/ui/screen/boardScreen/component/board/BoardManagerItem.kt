package com.chapter.chapterkeep.ui.screen.boardScreen.component.board

import androidx.compose.foundation.Image
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R

@Composable
fun BoardManagerItem(
    title: String,
    heartCount: Int
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_alert),
                contentDescription = null,
                modifier = Modifier.size(16.dp, 20.dp)
            )
            Spacer(Modifier.width(10.dp))

            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
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
                text = stringResource(R.string.baekiljang_manager),
                fontSize = 11.sp,
                color = colorResource(R.color.gray_800)
            )
        }
        Spacer(Modifier.height(10.dp))

        Divider()
    }
}