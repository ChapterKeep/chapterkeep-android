package com.chapter.chapterkeep.ui.screen.bookScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.component.header.HeaderWhiteLogo
import com.chapter.chapterkeep.ui.screen.bookScreen.component.ViewBookBar
import com.chapter.chapterkeep.ui.screen.bookScreen.component.ViewBookBottomBar
import com.chapter.chapterkeep.ui.screen.bookScreen.component.ViewBookQuote
import com.chapter.chapterkeep.ui.screen.bookScreen.component.ViewBookTitleBar

@Composable
fun ViewBookScreen(
    navController: NavHostController,
    reviewId: Long
) {
    val viewModel: ViewBookViewModel = viewModel()

    val image by viewModel::coverUrl
    val bookTitle by viewModel::bookTitle
    val bookWriter by viewModel::bookWriter
    val title by viewModel::reviewTitle
    val date by viewModel::createdAt
    val starStates by viewModel::starStates
    val quote by viewModel::quotation
    val detail by viewModel::content
    val heartCount by viewModel::likeCounts
    val writer by viewModel::nickname

    val isLoading by viewModel::isLoading
    val errorMessage by viewModel::errorMessage

    LaunchedEffect(reviewId) {
        viewModel.fetchBookReview(reviewId)
    }

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text("Loading...", modifier = Modifier.align(Alignment.Center))
        }
        return
    }

    if (errorMessage != null) {
        // 오류 발생 시 메시지 표시
        Box(modifier = Modifier.fillMaxSize()) {
            Text(errorMessage ?: "Unknown error", modifier = Modifier.align(Alignment.Center))
        }
        return
    }

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            HeaderWhiteLogo()
        },
        containerColor = colorResource(R.color.main_darkgreen)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(R.drawable.img_viewbook_background),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 35.dp, horizontal = 30.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        ViewBookBar(
                            image = image,
                            bookTitle = bookTitle,
                            bookWriter = bookWriter
                        )
                        Spacer(Modifier.height(5.dp))

                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            thickness = 1.dp,
                            color = colorResource(R.color.gray_400)
                        )
                        Spacer(Modifier.height(15.dp))

                        ViewBookTitleBar(
                            title = title,
                            date = date,
                            starStates = starStates.toMutableList(),
                            navController = navController
                        )
                        Spacer(Modifier.height(8.dp))

                        ViewBookQuote(quote = quote)
                        Spacer(Modifier.height(15.dp))
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                            .verticalScroll(scrollState)
                    ) {
                        Text(
                            text = detail,
                            fontSize = 15.sp
                        )
                    }

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        thickness = 1.dp,
                        color = colorResource(R.color.gray_400)
                    )
                    Spacer(Modifier.height(15.dp))

                    ViewBookBottomBar(
                        heartCount = heartCount,
                        writer = writer
                    )
                }
            }
        }
    }
}
