package com.chapter.chapterkeep.ui.screen.boardScreen.component.detailBoard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R

@Composable
fun AddBoardTopBar(
    title: String,
    onClick: ()->Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.main_green)
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_cancel),
            contentDescription = null,
            modifier = Modifier.clickable {
                onClick()
            }
        )
    }
}

@Preview
@Composable
fun AddBoardTopBarPreview(){
}