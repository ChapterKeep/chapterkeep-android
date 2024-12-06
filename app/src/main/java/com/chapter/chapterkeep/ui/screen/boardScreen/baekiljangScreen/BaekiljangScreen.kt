package com.chapter.chapterkeep.ui.screen.boardScreen.baekiljangScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.component.Bar.BoardTopBar
import com.chapter.chapterkeep.ui.component.CommonButton
import com.chapter.chapterkeep.ui.component.header.HeaderGreenLogo
import com.chapter.chapterkeep.ui.component.textfield.SearchTextField
import com.chapter.chapterkeep.ui.navigate.Routes
import com.chapter.chapterkeep.ui.screen.boardScreen.component.board.BoardManagerItem
import com.chapter.chapterkeep.ui.screen.boardScreen.component.board.BoardUserItem

@Composable
fun BaekiljangScreen(
    navController: NavHostController
) {
    val viewModel: BaekiljangViewModel = viewModel()
    val baekiljangPosts by viewModel.baekiljangPosts.collectAsStateWithLifecycle()
    val searchResults by viewModel.searchResults.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val errorMessage by viewModel.errorMessage.collectAsStateWithLifecycle()

    // 검색창
    val search = remember { mutableStateOf("") }
    val searchHasFocus = remember { mutableStateOf(false) }
    val isSearchMode = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.fetchBaekiljangPosts()
    }

    Scaffold(
        topBar = {
            HeaderGreenLogo()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(20.dp)
        ) {
            BoardTopBar(
                navController = navController,
                boardName = stringResource(R.string.baekiljang_board)
            )
            Spacer(Modifier.height(30.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SearchTextField(
                    search = search,
                    searchHasFocus = searchHasFocus,
                    searchHint = stringResource(R.string.baekiljang_search),
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(10.dp))

                CommonButton(
                    label = stringResource(R.string.search_btn),
                    fontSize = 13
                ) {
                    if (search.value.isNotBlank()) {
                        isSearchMode.value = true
                        viewModel.searchBaekiljangPosts(search.value)
                    } else {
                        viewModel.fetchBaekiljangPosts()
                        isSearchMode.value = false
                    }
                }
            }

            Spacer(Modifier.height(20.dp))
            when {
                isLoading -> {
                    Text(
                        text = stringResource(R.string.search_loading),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }

                errorMessage != null -> {
                    Text(
                        text = errorMessage ?: stringResource(R.string.search_unknown_error),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }

                isSearchMode.value && searchResults.isEmpty() -> {
                    Text(
                        text = stringResource(R.string.search_no_results),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }

                isSearchMode.value -> {
                    LazyColumn {
                        items(
                            count = searchResults.size,
                            key = { index -> index }
                        ) { index ->
                            BoardUserItem(
                                title = searchResults[index].postTitle,
                                heartCount = searchResults[index].likesCount.toInt(),
                                userName = searchResults[index].nickname,
                                onClick = {
                                    navController.navigate(Routes.ViewBaekiljang.createRoute(searchResults[index].postId))
                                }
                            )
                        }
                    }
                }

                baekiljangPosts.isEmpty() -> {
                    Text(
                        text = stringResource(R.string.baekiljang_none),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }

                else -> {
                    LazyColumn {
                        item {
                            BoardManagerItem(
                                title = stringResource(R.string.baekiljang_month_title),
                                heartCount = 100
                            )
                        }

                        items(
                            count = baekiljangPosts.size,
                            key = { index -> index }
                        ) { index ->
                            BoardUserItem(
                                title = baekiljangPosts[index].postTitle,
                                heartCount = baekiljangPosts[index].likesCount.toInt(),
                                userName = baekiljangPosts[index].nickname,
                                onClick = {
                                    navController.navigate(Routes.ViewBaekiljang.createRoute(baekiljangPosts[index].postId))
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BaekiljangScreenPreview() {
    val navController = rememberNavController()

    BaekiljangScreen(navController = navController)
}