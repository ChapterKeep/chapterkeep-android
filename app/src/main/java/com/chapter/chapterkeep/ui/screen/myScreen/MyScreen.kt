package com.chapter.chapterkeep.ui.screen.myScreen

import MyViewModel
import TokenManager
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.component.Bar.BottomBar
import com.chapter.chapterkeep.ui.component.header.HeaderGreenLogo
import com.chapter.chapterkeep.ui.navigate.Routes
import com.chapter.chapterkeep.ui.screen.myScreen.component.MyPostList
import com.chapter.chapterkeep.ui.screen.myScreen.component.MyProfileRow

@Composable
fun MyScreen(
    navController: NavHostController
) {
    val viewModel: MyViewModel = viewModel()

    val myPageData by viewModel.myPageData.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchMyPageData()
    }

    if (isLoading) {
        Text(text = stringResource(R.string.search_loading))
    } else if (!errorMessage.isNullOrEmpty()) {
        Text(text = stringResource(R.string.search_unknown_error))
    } else {
        val scrollState = rememberScrollState()

        Scaffold(
            topBar = { HeaderGreenLogo() },
            bottomBar = { BottomBar(4, navController) }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                    .padding(paddingValues)
                    .verticalScroll(scrollState)
            ) {
                MyProfileRow(
                    userName = myPageData?.nickname ?: "Unknown",
                    writeAccount = myPageData?.postCount?.toInt() ?: 0,
                    logoutOnClick = {
                        TokenManager.clearToken()
                        navController.navigate(Routes.Login.route) {
                            popUpTo(Routes.Login.route) { inclusive = true }
                        }
                    },
                    deleteOnClick = {
                        navController.navigate(Routes.Login.route) {
                            popUpTo(Routes.Login.route) { inclusive = true }
                        }
                    }
                )
                Spacer(Modifier.height(35.dp))

                MyPostList(
                    title = stringResource(R.string.mypage_profile_my_write),
                    posts = myPageData?.myPosts,
                    onPostClick = { postId ->
                        navController.navigate("ViewBaekiljang/$postId")
                    },
                    onMoreClick = {
                        navController.navigate(Routes.More.createRoute("my_write"))
                    }
                )
                Spacer(Modifier.height(20.dp))

                MyPostList(
                    title = stringResource(R.string.mypage_profile_like_write),
                    posts = myPageData?.likedPosts,
                    onPostClick = { postId ->
                        navController.navigate("ViewBaekiljang/$postId")
                    },
                    onMoreClick = {
                        navController.navigate(Routes.More.createRoute("like_write"))
                    }
                )
                Spacer(Modifier.height(20.dp))

                MyPostList(
                    title = stringResource(R.string.mypage_profile_comment_write),
                    posts = myPageData?.commentedPosts,
                    onPostClick = { postId ->
                        navController.navigate("ViewBaekiljang/$postId")
                    },
                    onMoreClick = {
                        navController.navigate(Routes.More.createRoute("comment_write"))
                    }
                )
            }
        }
    }
}

