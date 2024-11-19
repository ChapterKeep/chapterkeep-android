package com.chapter.chapterkeep.ui.screen.bookScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R

@Composable
fun ViewBookQuote(
    quote: String
) {
    Row(
        modifier= Modifier
            .fillMaxWidth()
            .padding(start = 10.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_quote),
            contentDescription = null,
            modifier = Modifier
                .size(16.dp, 22.dp)
                .padding(end = 10.dp)
        )

        Text(
            text = quote,
            fontSize = 15.sp,
            color = colorResource(R.color.gray_600)
        )
    }
}