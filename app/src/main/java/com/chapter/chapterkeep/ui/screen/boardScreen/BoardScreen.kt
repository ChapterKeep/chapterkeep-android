package com.chapter.chapterkeep.ui.screen.boardScreen

import BoardViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.model.BoardRankData
import com.chapter.chapterkeep.model.BoardRecommendData
import com.chapter.chapterkeep.ui.component.Bar.BottomBar
import com.chapter.chapterkeep.ui.component.header.HeaderGreenLogo
import com.chapter.chapterkeep.ui.screen.boardScreen.component.board.BoardRank
import com.chapter.chapterkeep.ui.screen.boardScreen.component.board.BoardRecommend
import com.chapter.chapterkeep.ui.screen.boardScreen.component.board.BoardTypeBox

@Composable
fun BoardScreen(
    navController: NavHostController
) {
    val viewModel: BoardViewModel = viewModel()
    val boardData by viewModel.boardData.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val errorMessage by viewModel.errorMessage.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()

    LaunchedEffect(Unit) {
        viewModel.fetchBoardData()
    }

    Scaffold(
        topBar = {
            HeaderGreenLogo()
        },
        bottomBar = {
            BottomBar(3, navController)
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.img_board_bg),
                contentDescription = null,
                modifier = Modifier
                    .size(
                        width = (LocalConfiguration.current.screenWidthDp / 2).dp,
                        height = 200.dp
                    )
                    .align(Alignment.TopEnd),
                contentScale = ContentScale.Crop
            )
        }

        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Loading...")
            }
            return@Scaffold
        }

        if (errorMessage != null) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(errorMessage ?: "Unknown error")
            }
            return@Scaffold
        }

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            // BoardTypeBox
            BoardTypeBox(navController)
            Spacer(Modifier.height(25.dp))

            // BoardRank
            boardData?.essayPostResDtoList?.let { essayPostList ->
                if (essayPostList.isNotEmpty()) {
                    BoardRank(items = essayPostList.map {
                        BoardRankData(
                            imageResId = R.drawable.img_profile_select,
                            rank = essayPostList.indexOf(it) + 1,
                            postId = it.postId,
                            title = it.postTitle,
                            likes = it.likesCount.toInt(),
                            userName = if (it.anonymous) stringResource(R.string.board_anonymous) else it.nickname
                        )
                    },
                        onItemClick = {postId ->
                            navController.navigate("ViewBaekiljang/$postId")
                        })
                } else {
                    Text(
                        text = stringResource(R.string.board_rank_none),
                        fontSize = 16.sp,
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }
            Spacer(Modifier.height(25.dp))

            // BoardRecommend 추가
            boardData?.rentalCountRecommendResDtoList?.let { rentalCountList ->
                if (rentalCountList.isNotEmpty()) {
                    BoardRecommend(items = rentalCountList.map {
                        BoardRecommendData(
                            title = it.title,
                            department = it.department,
                            rentalCount = it.rentalCount,
                            library_url = it.library_url
                        )
                    })
                } else {
                    Text(
                        text = stringResource(R.string.board_recommend_none),
                        fontSize = 16.sp,
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoardScreenPreview() {
    val navController = rememberNavController()

    BoardScreen(navController = navController)
}