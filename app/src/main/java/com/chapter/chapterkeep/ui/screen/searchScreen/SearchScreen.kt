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
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.model.BookData
import com.chapter.chapterkeep.model.ProfileData
import com.chapter.chapterkeep.ui.component.BottomBar
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
    // 검색창
    var search by remember {
        mutableStateOf("")
    }
    var searchHasFocus by remember {
        mutableStateOf(false)
    }

    // 탭
    var bookCheck by remember {
        mutableStateOf(true)
    }
    var profileCheck by remember {
        mutableStateOf(false)
    }

    val books = listOf(
        // 더미데이터
        BookData(R.drawable.img_home_book, "Book Title 1", "Author 1"),
        BookData(R.drawable.img_home_book, "Book Title 2", "Author 2"),
        BookData(R.drawable.img_home_book, "Book Title 3", "Author 3"),
        BookData(R.drawable.img_home_book, "Book Title 4", "Author 4"),
        BookData(R.drawable.img_home_book, "Book Title 5", "Author 5"),
        BookData(R.drawable.img_home_book, "Book Title 6", "Author 6"),
    )

    val profiles = listOf(
        // 더미데이터
        ProfileData(R.drawable.img_profile_select, "Author 1", 1),
        ProfileData(R.drawable.img_profile_select, "Author 2", 2),
        ProfileData(R.drawable.img_profile_select, "Author 3", 3),
        ProfileData(R.drawable.img_profile_select, "Author 4", 4),
        ProfileData(R.drawable.img_profile_select, "Author 5", 5),
        ProfileData(R.drawable.img_profile_select, "Author 6", 6)
    )

    Scaffold(
        topBar = {
            HeaderGreenLogo()
        },
        bottomBar = {
            BottomBar(1, navController)
        }
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
                    search = remember { mutableStateOf(search) },
                    searchHasFocus = remember { mutableStateOf(searchHasFocus) },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(10.dp))

                CommonButton(
                    label = stringResource(R.string.search_btn),
                    fontSize = 13
                ) {
                    TODO("검색")
                }
            }

            TabMenu(
                bookCheck = bookCheck,
                profileCheck = profileCheck,
                onChanged = { bookCheck = !bookCheck; profileCheck = !profileCheck }
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(R.color.gray_400))
                    .padding(start = 20.dp, end = 20.dp)
            ) {
                if (bookCheck) {
                    items(
                        count = books.size,
                        key = { item -> item }
                    ) { index ->
                        TabBookItem(
                            image = books[index].image,
                            title = books[index].title,
                            writer = books[index].writer
                        )

                        if (index == books.size - 1) {
                            Spacer(modifier = Modifier.height(20.dp))
                        }
                    }
                } else if (profileCheck) {
                    items(
                        count = profiles.size,
                        key = { item -> item }
                    ) { index ->
                        TabProfileItem(
                            image = profiles[index].image,
                            name = profiles[index].name,
                            writeCount = profiles[index].writeCount
                        )

                        if (index == profiles.size - 1) {
                            Spacer(modifier = Modifier.height(20.dp))
                        }
                    }
                }
            }
        }
    }
}