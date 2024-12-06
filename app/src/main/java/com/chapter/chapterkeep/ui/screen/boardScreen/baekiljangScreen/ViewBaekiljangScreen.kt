package com.chapter.chapterkeep.ui.screen.boardScreen.baekiljangScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.navigate.Routes
import com.chapter.chapterkeep.ui.screen.boardScreen.component.detailBoard.ViewBoardInfoBar
import com.chapter.chapterkeep.ui.screen.boardScreen.component.detailBoard.ViewBoardTopBar

@Composable
fun ViewBaekiljangScreen(
    navController: NavHostController,
    postId: Long
) {
    val viewModel: BaekiljangViewModel = viewModel()
    val detail by viewModel.detailBaekiljang.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val errorMessage by viewModel.errorMessage.collectAsStateWithLifecycle()

    LaunchedEffect(postId) {
        viewModel.fetchDetailBaekiljang(postId)
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ){
        ViewBoardTopBar(
            title = stringResource(R.string.baekiljang_board),
            onClick = {
                navController.navigate(Routes.Baekiljang.route) {
                    popUpTo(Routes.Baekiljang.route){
                        inclusive = true
                    }
                }
            }
        )
        Spacer(Modifier.height(20.dp))

        when {
            isLoading -> {
                Text(text = stringResource(R.string.search_loading))
            }

            errorMessage != null -> {
                Text(text = errorMessage ?: stringResource(R.string.search_unknown_error))
            }

            detail != null -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ){
                    ViewBoardInfoBar(
                        title = detail!!.postTitle,
                        image = detail!!.profileUrl,
                        writer = detail!!.nickname,
                        date = detail!!.createdAt,
                        navController = navController
                    )
                    Spacer(Modifier.height(20.dp))

                    Text(
                        text = detail!!.content,
                        fontSize = 14.sp
                    )
                    Spacer(Modifier.height(30.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_heart),
                            contentDescription = null,
                            tint = colorResource(R.color.main_pink)
                        )
                        Spacer(Modifier.width(8.dp))

                        Text(
                            text = detail!!.likesCount.toString(),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(R.color.main_pink)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ViewBaekiljangScreenReview(
) {
    val navController = rememberNavController()
    ViewBaekiljangScreen(navController, 1)
}