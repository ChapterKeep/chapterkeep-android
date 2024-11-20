package com.chapter.chapterkeep.ui.screen.boardScreen

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.model.BoardRankData
import com.chapter.chapterkeep.model.BoardRecommendData
import com.chapter.chapterkeep.ui.component.Bar.BottomBar
import com.chapter.chapterkeep.ui.component.header.HeaderGreenLogo
import com.chapter.chapterkeep.ui.screen.boardScreen.component.BoardRank
import com.chapter.chapterkeep.ui.screen.boardScreen.component.BoardRecommend
import com.chapter.chapterkeep.ui.screen.boardScreen.component.BoardTypeBox

@Composable
fun BoardScreen(
    navController: NavHostController
) {
    val scrollState = rememberScrollState()

    // rank 샘플 데이터 생성
    val sampleRankItems = listOf(
        BoardRankData(
            imageResId = R.drawable.img_profile_select,
            rank = 1,
            title = "별 헤는 밤",
            likes = 123,
            userName = "책 먹는 고양이"
        ),
        BoardRankData(
            imageResId = R.drawable.img_profile_select,
            rank = 2,
            title = "세상은 요지경",
            likes = 98,
            userName = "책 먹는 하마"
        ),
        BoardRankData(
            imageResId = R.drawable.img_profile_select,
            rank = 3,
            title = "새로운 시작",
            likes = 76,
            userName = "책 읽는 오리"
        )
    )

    // recommend 샘플 데이터
    val sampleRecommendItems = listOf(
        BoardRecommendData(
            imageResId = R.drawable.img_home_book,
            title = "오늘 하루도, 소심한 고양이",
            writer = "이수민",
            genre = "에세이",
            detail = "오늘 하루도, 소심한 고양이의 하루 이야기를 담은 에세이입니다. 고양이는 귀여워."
        ),
        BoardRecommendData(
            imageResId = R.drawable.img_home_book,
            title = "어느 날, 마음이 불편해졌다",
            writer = "김현진",
            genre = "심리",
            detail = "일상 속 마음의 불편함과 위로를 담은 심리 에세이입니다."
        ),
        BoardRecommendData(
            imageResId = R.drawable.img_home_book,
            title = "책과 함께하는 여행",
            writer = "박수영",
            genre = "여행",
            detail = "책과 여행의 만남을 담은 에세이입니다."
        )
    )

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
        
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            // BoardTypeBox
            BoardTypeBox(navController)
            Spacer(Modifier.height(25.dp))

            // BoardRank
            BoardRank(sampleRankItems)
            Spacer(Modifier.height(25.dp))

            // BoardRecommend 추가
            BoardRecommend(items = sampleRecommendItems)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoardScreenPreview() {
    val navController = rememberNavController()

    BoardScreen(navController = navController)
}