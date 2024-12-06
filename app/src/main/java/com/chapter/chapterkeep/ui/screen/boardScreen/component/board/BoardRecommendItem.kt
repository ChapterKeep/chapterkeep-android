package com.chapter.chapterkeep.ui.screen.boardScreen.component.board

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.model.BoardRecommendData

@Composable
fun BoardRecommendItem(
    item: BoardRecommendData
) {
    val context = LocalContext.current

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
                text = stringResource(R.string.board_department, item.department),
                fontSize = 10.sp,
                color = colorResource(R.color.gray_800)
            )
            Text(
                text = stringResource(R.string.board_rentalCount, item.rentalCount),
                fontSize = 10.sp,
                color = colorResource(R.color.gray_800),
                modifier = Modifier.padding(bottom = 2.dp)
            )
            Text(
                text = item.library_url,
                fontSize = 10.sp,
                color = colorResource(R.color.gray_600),
                maxLines = 2,
                lineHeight = 12.sp,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.library_url))
                    context.startActivity(intent)
                }
            )
        }
    }
}