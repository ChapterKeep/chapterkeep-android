package com.chapter.chapterkeep.ui.screen.myScreen

import MoreViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.api.dto.response.PostsData
import com.chapter.chapterkeep.ui.component.Bar.BottomBar
import com.chapter.chapterkeep.ui.component.header.HeaderGreenLogo
import com.chapter.chapterkeep.ui.screen.myScreen.component.MoreItem

@Composable
fun MoreScreen(
    navController: NavHostController,
    type: String
) {
    val viewModel: MoreViewModel = viewModel()

    val posts by viewModel.posts.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    LaunchedEffect(type) {
        viewModel.fetchPosts(type)
    }

    val (titleRes, subtitleRes, emptyMessage) = when (type) {
        "my_write" -> Triple(
            R.string.more_my_title,
            R.string.more_my_subtitle,
            R.string.mypage_profile_my_write_none
        )
        "like_write" -> Triple(
            R.string.more_like_title,
            R.string.more_like_subtitle,
            R.string.mypage_profile_like_write_none
        )
        "comment_write" -> Triple(
            R.string.more_comment_title,
            R.string.more_comment_subtitle,
            R.string.mypage_profile_comment_write_none
        )
        else -> Triple(
            R.string.more_my_title,
            R.string.more_my_subtitle,
            ""
        )
    }

    Scaffold(
        topBar = {
            HeaderGreenLogo()
        },
        bottomBar = {
            BottomBar(4, navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                .padding(paddingValues)
        ) {
            Text(
                text = stringResource(titleRes),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.main_green)
            )
            Spacer(Modifier.height(10.dp))

            Text(
                text = stringResource(subtitleRes),
                fontSize = 15.sp,
                color = colorResource(R.color.gray_800)
            )
            Spacer(Modifier.height(35.dp))

            when {
                isLoading -> Text(text = "로딩 중입니다...")
                !errorMessage.isNullOrEmpty() -> Text(text = errorMessage ?: "오류 발생")
                posts.isEmpty() -> Text(
                    text = stringResource(R.string.more_none),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.gray_800)
                )
                else -> LazyColumn {
                    items(posts) { post ->
                        MoreItem(
                            post = PostsData(
                                post.title,
                                post.createdAt,
                                post.nickname,
                                post.postId
                            ),
                            navController = navController
                        )
                        Spacer(Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MorePreview(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    MoreScreen(navController, "my_write")
}