package com.chapter.chapterkeep.ui.screen.bookScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.chapter.chapterkeep.R

@Composable
fun ViewBookBar(
    image: String,
    bookTitle: String,
    bookWriter: String
) {
    Row(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .padding(start = 10.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(image),
            contentDescription = null,
            modifier= Modifier
                .padding(end = 20.dp)
                .size(62.dp, 100.dp)
        )

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = bookTitle,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 5.dp)
            )

            Text(
                text = bookWriter,
                fontSize = 12.sp,
                color = colorResource(R.color.gray_700)
            )
        }
    }
}