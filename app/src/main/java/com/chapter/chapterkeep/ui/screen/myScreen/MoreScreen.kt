package com.chapter.chapterkeep.ui.screen.myScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.model.PostData
import com.chapter.chapterkeep.ui.component.Bar.BottomBar
import com.chapter.chapterkeep.ui.component.header.HeaderGreenLogo
import com.chapter.chapterkeep.ui.screen.myScreen.component.MoreItem

@Composable
fun MoreScreen(
    navController: NavHostController,
    type: String
) {
    val (titleRes, subtitleRes, posts) = when (type) {
        "my_write" -> Triple(
            R.string.more_my_title,
            R.string.more_my_subtitle,
            listOf(
                PostData("내가 쓴 게시글1", "2024-11-25", "작성자 A"),
                PostData("내가 쓴 게시글2", "2024-11-24", "작성자 B")
            )
        )
        "like_write" -> Triple(
            R.string.more_like_title,
            R.string.more_like_subtitle,
            listOf(
                PostData("좋아요 누른 게시글1", "2024-11-25", "작성자 A"),
                PostData("좋아요 누른 게시글2", "2024-11-24", "작성자 B")
            )
        )
        "comment_write" -> Triple(
            R.string.more_comment_title,
            R.string.more_comment_subtitle,
            listOf(
                PostData("댓글 단 게시글1", "2024-11-25", "작성자 A"),
                PostData("댓글 단 게시글2", "2024-11-24", "작성자 B")
            )
        )
        else -> Triple(
            R.string.more_my_title,
            R.string.more_my_subtitle,
            emptyList()
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

            LazyColumn {
                items(posts) { post ->
                    MoreItem(post = post, navController = navController)
                    Spacer(Modifier.height(10.dp))
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