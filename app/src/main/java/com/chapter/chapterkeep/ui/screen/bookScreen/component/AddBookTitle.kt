package com.chapter.chapterkeep.ui.screen.bookScreen.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R

@Composable
fun AddBookTitle(
    label : Int
) {
    Text(
        text = stringResource(label),
        color = colorResource(R.color.gray_900),
        fontSize = 16.sp
    )
}