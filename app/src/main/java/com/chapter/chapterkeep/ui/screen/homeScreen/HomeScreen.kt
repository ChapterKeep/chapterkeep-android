package com.chapter.chapterkeep.ui.screen.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    val profileData by viewModel::profileData
    val bookShelfData by viewModel::bookShelfData

    var isUnlocked by remember { mutableStateOf(true) }

    DoubleBackPressToExit()

    LaunchedEffect(Unit) {
        viewModel.clearData()
        viewModel.fetchHomeData()
    }

    Scaffold(
        topBar = {
            HeaderWhiteLogoWithBtn(
                label = if(isUnlocked) R.string.home_open_button else R.string.home_unopen_button,
                image = if(isUnlocked) R.drawable.ic_lock_open_24 else R.drawable.ic_lock_24,
                onClick = {
                    isUnlocked = !isUnlocked
                }
            )
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
            ProfileBar(
                navController = navController,
                userNickName = profileData.nickname,
                userMyself = profileData.introduction,
                userBookCount = bookShelfData.size
            )
            Spacer(Modifier.height(20.dp))

            LazyColumn {
                items(bookShelfData.chunked(3)) { chunk ->
                    BookShelf(
                        books = chunk,
                        onBookClick = { reviewId ->
                            navController.navigate("ViewBook/$reviewId")
                        }
                    )
                }
            }
        }
    }
}