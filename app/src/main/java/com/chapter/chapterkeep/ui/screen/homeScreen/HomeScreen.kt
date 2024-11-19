package com.chapter.chapterkeep.ui.screen.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.component.Bar.BottomBar
import com.chapter.chapterkeep.ui.component.Bar.ProfileBar
import com.chapter.chapterkeep.ui.component.DoubleBackPressToExit
import com.chapter.chapterkeep.ui.component.header.HeaderWhiteLogoWithBtn
import com.chapter.chapterkeep.ui.navigate.Routes

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel
) {
    val userNickName by viewModel::userNickName
    val userMyself by viewModel::userMyself
    val userBookCount by viewModel::userBookCount

    DoubleBackPressToExit()

    Scaffold(
        topBar = {
            HeaderWhiteLogoWithBtn(
                label = R.string.home_open_button,
                image = R.drawable.ic_lock_open_24
            ) {
                TODO("책장 공개 비공개")
            }
        },
        bottomBar = {
            BottomBar(2, navController)
        },
        containerColor = colorResource(R.color.main_green).copy(alpha = 0.7f),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Routes.AddBook.route)
                },
                shape = CircleShape,
                containerColor = colorResource(R.color.main_green),
                contentColor = colorResource(R.color.white)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_add),
                    contentDescription = "",
                    modifier = Modifier.size(35.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(20.dp)
        ) {
            ProfileBar(navController, userNickName, userMyself, userBookCount)
            Spacer(Modifier.height(20.dp))

            LazyColumn(){
                item {
                    BookShelf()
                    BookShelf()
                    BookShelf()
                    BookShelf()
                }
            }
        }
    }
}