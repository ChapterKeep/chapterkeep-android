package com.chapter.chapterkeep.ui.screen.myScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.model.PostData
import com.chapter.chapterkeep.ui.component.Bar.BottomBar
import com.chapter.chapterkeep.ui.component.header.HeaderGreenLogo
import com.chapter.chapterkeep.ui.navigate.Routes
import com.chapter.chapterkeep.ui.screen.myScreen.component.MyPostList
import com.chapter.chapterkeep.ui.screen.myScreen.component.MyProfileRow

@Composable
fun MyScreen(
    navController: NavHostController
) {
    var userName by remember{
        mutableStateOf("책 먹는 하마")
    }

    var writeAccount by remember{
        mutableStateOf(8)
    }

    val myposts = listOf(
        PostData(
            title = "내가 쓴 게시글1",
            time = "2024-11-25",
            writer = "작성자 A"
        ),
        PostData(
            title = "내가 쓴 게시글2",
            time = "2024-11-24",
            writer = "작성자 B"
        )
    )

    val mylikeposts = listOf(
        PostData(
            title = "좋아요 누른 게시글1",
            time = "2024-11-25",
            writer = "작성자 A"
        ),
        PostData(
            title = "좋아요 누른 게시글2",
            time = "2024-11-24",
            writer = "작성자 B"
        )
    )

    val mycommentposts = listOf(
        PostData(
            title = "댓글 단 게시글1",
            time = "2024-11-25",
            writer = "작성자 A"
        ),
        PostData(
            title = "댓글 단 게시글2",
            time = "2024-11-24",
            writer = "작성자 B"
        )
    )

    val scrollState = rememberScrollState()
    
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
                .verticalScroll(scrollState)
        ) {
            MyProfileRow(
                userName = userName,
                writeAccount = writeAccount,
                logoutOnClick = {
                    navController.navigate(Routes.Login.route){
                        popUpTo(Routes.Login.route){
                            inclusive = true
                        }
                    }
                },
                deleteOnClick = {
                    navController.navigate(Routes.Login.route){
                        popUpTo(Routes.Login.route){
                            inclusive = true
                        }
                    }
                }
            )
            Spacer(Modifier.height(35.dp))

            MyPostList(
                title = stringResource(R.string.mypage_profile_my_write),
                posts = myposts
            )
            Spacer(Modifier.height(20.dp))

            MyPostList(
                title = stringResource(R.string.mypage_profile_like_write),
                posts = mylikeposts
            )
            Spacer(Modifier.height(20.dp))

            MyPostList(
                title = stringResource(R.string.mypage_profile_comment_write),
                posts = mycommentposts
            )
        }
    }
}

@Preview
@Composable
fun MyPreview(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    MyScreen(navController)
}