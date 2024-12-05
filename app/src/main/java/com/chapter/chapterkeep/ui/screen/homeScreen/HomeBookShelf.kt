package com.chapter.chapterkeep.ui.screen.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.api.dto.response.BookShelfData

@Composable
fun BookShelf(
    books: List<BookShelfData>,
    onBookClick: (Long) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(bottom = 30.dp)
            .height(125.dp)
            .fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .padding(start = 20.dp, bottom = 10.dp, end = 20.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp))
                .background(color = Color.White),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            books.forEach{book->
                Image(
                    painter = rememberAsyncImagePainter(book.coverUrl),
                    contentDescription = "",
                    modifier = Modifier
                        .size(62.dp, 100.dp)
                        .clickable {
                            onBookClick(book.reviewId)
                        }
                )
            }
        }
        Image(
            painter = painterResource(R.drawable.img_home_bookshelf),
            contentDescription = "",
            modifier=  Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 10.dp, end = 10.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}