package com.chapter.chapterkeep.ui.screen.searchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.component.Bar.BottomBar
import com.chapter.chapterkeep.ui.component.CommonButton
import com.chapter.chapterkeep.ui.component.TabMenu
import com.chapter.chapterkeep.ui.component.header.HeaderGreenLogo
import com.chapter.chapterkeep.ui.component.textfield.SearchTextField
import com.chapter.chapterkeep.ui.screen.searchScreen.component.TabBookItem
import com.chapter.chapterkeep.ui.screen.searchScreen.component.TabProfileItem

@Composable
fun SearchScreen(
    navController: NavHostController
) {
    val viewModel: SearchViewModel = viewModel()

    // UI 상태
    val profileResults by viewModel.profileResults.collectAsStateWithLifecycle()
    val bookResults by viewModel.bookResults.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val errorMessage by viewModel.errorMessage.collectAsStateWithLifecycle()

    // 검색 상태
    val search = remember { mutableStateOf("") }
    val searchHasFocus = remember { mutableStateOf(false) }

    // 탭 상태
    var bookCheck by remember { mutableStateOf(true) }
    var profileCheck by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { HeaderGreenLogo() },
        bottomBar = { BottomBar(1, navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            Text(
                text = stringResource(R.string.search_title),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.main_green),
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 10.dp)
            )

            Text(
                text = stringResource(R.string.search_subtitle),
                fontSize = 15.sp,
                color = colorResource(R.color.gray_800),
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 15.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SearchTextField(
                    search = search, // 상위 상태를 전달
                    searchHasFocus = searchHasFocus,
                    searchHint = if (bookCheck) {
                        stringResource(R.string.search_hint_book)
                    } else {
                        stringResource(R.string.search_hint_nickname)
                    },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(10.dp))

                CommonButton(
                    label = stringResource(R.string.search_btn),
                    fontSize = 13
                ) {
                    if (profileCheck) {
                        if (search.value.isNotBlank()) { // 빈 값 검증
                            viewModel.searchByNickname(search.value)
                        } else {
                        }
                    } else {
                        viewModel.searchByTitle(search.value)
                    }
                }
            }

            TabMenu(
                bookCheck = bookCheck,
                profileCheck = profileCheck,
                onChanged = { bookCheck = !bookCheck; profileCheck = !profileCheck }
            )

            if (profileCheck) {
                when {
                    isLoading -> {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = colorResource(R.color.gray_400))
                                .padding(start = 20.dp, end = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Text(
                                text = stringResource(R.string.search_loading),
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                    }

                    errorMessage != null -> {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = colorResource(R.color.gray_400))
                                .padding(start = 20.dp, end = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Text(
                                text = stringResource(R.string.search_unknown_error),
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                    }

                    profileResults.isEmpty() -> {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = colorResource(R.color.gray_400))
                                .padding(start = 20.dp, end = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Text(
                                text = stringResource(R.string.search_no_results),
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                    }

                    else -> {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = colorResource(R.color.gray_400))
                                .padding(start = 20.dp, end = 20.dp)
                        ) {
                            items(
                                count = profileResults.size,
                                key = { profile -> profile }
                            ) { index ->
                                TabProfileItem(
                                    image = R.drawable.img_profile_select, // 실제 URL로 변경 가능
                                    name = profileResults[index].nickname,
                                    writeCount = profileResults[index].bookReviewCount.toInt()
                                )

                                if (index == profileResults.size - 1) {
                                    Spacer(modifier = Modifier.height(20.dp))
                                }
                            }
                        }
                    }
                }
            }

            if (bookCheck) {
                when {
                    isLoading -> {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = colorResource(R.color.gray_400)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = stringResource(R.string.search_loading))
                        }
                    }

                    errorMessage != null -> {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = colorResource(R.color.gray_400)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = errorMessage ?: stringResource(R.string.search_unknown_error))
                        }
                    }

                    bookResults.isEmpty() -> {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = colorResource(R.color.gray_400)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = stringResource(R.string.search_no_results))
                        }
                    }

                    else -> {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = colorResource(R.color.gray_400))
                                .padding(horizontal = 20.dp)
                        ) {
                            items(
                                count = bookResults.size,
                                key = { book -> book }
                            ) { index ->
                                val book = bookResults[index]
                                TabBookItem(
                                    image = book.coverUrl,
                                    title = book.reviewTitle,
                                    writer = book.nickname,
                                    onClick = {
                                        navController.navigate("ViewBook/${book.reviewId}")
                                    }
                                )

                                if (index == bookResults.size - 1) {
                                    Spacer(modifier = Modifier.height(20.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
