package com.chapter.chapterkeep.ui.screen.bookScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.component.ChangeButton
import com.chapter.chapterkeep.ui.component.header.HeaderGreenLogo
import com.chapter.chapterkeep.ui.navigate.Routes
import com.chapter.chapterkeep.ui.screen.bookScreen.component.AddBookInfo
import com.chapter.chapterkeep.ui.screen.bookScreen.component.AddBookStar
import com.chapter.chapterkeep.ui.screen.bookScreen.component.AddBookTextField

@Composable
fun AddBookScreen(
    navController: NavHostController
) {
    var isbn by remember { mutableStateOf("") }
    var book_title by remember { mutableStateOf("책 제목") }
    var book_writer by remember { mutableStateOf("글쓴이") }

    var title by remember { mutableStateOf("") }
    var quote by remember { mutableStateOf("") }
    var detail by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    var starStates = remember { mutableStateListOf(false, false, false, false, false) }

    val isButtonEnabled by remember {
        derivedStateOf {
            isbn.isNotEmpty() &&
                    starStates.count { it } > 0 &&
                    title.isNotEmpty() &&
                    quote.isNotEmpty() &&
                    detail.isNotEmpty() &&
                    detail.length <= 1000
        }
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
                .verticalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                AddBookInfo(
                    isbn = isbn,
                    onIsbnChange = { isbn = it },
                    bookTitle = book_title,
                    bookWriter = book_writer,
                    onIsbnSubmit = {
                        TODO("ISBN 확인")
                    },
                    onImageClick = {
                        TODO("책 이미지 등록")
                    },
                    onSearchClick = {
                        TODO("ISBN 조회하는 웹 페이지로 이동")
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))

                AddBookStar(starStates = starStates)
                Spacer(modifier = Modifier.height(20.dp))

                AddBookTextField(
                    title = R.string.addbook_title,
                    value = title,
                    onValueChange = { title = it },
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    shape = 12,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))

                AddBookTextField(
                    title = R.string.addbook_quote,
                    value = quote,
                    onValueChange = { quote = it },
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    shape = 12,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))

                AddBookTextField(
                    title = R.string.addbook_detail,
                    value = detail,
                    onValueChange = { detail = it },
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done,
                    shape = 12,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                )
                Text(
                    text = stringResource(R.string.addbook_detail_count, detail.length),
                    fontSize = 12.sp,
                    color = if (detail.length <= 1000) colorResource(R.color.main_green) else Color.Red
                )
                Spacer(modifier = Modifier.height(20.dp))

                ChangeButton(
                    label = stringResource(R.string.addbook_submit),
                    color = { if (isButtonEnabled) R.color.main_green else R.color.gray_200 },
                    fontColor = { if (isButtonEnabled) R.color.white else R.color.gray_700 }
                ) {
                    if(isButtonEnabled){
                        navController.navigate(Routes.Home.route){
                            popUpTo(0) { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                }
            }
        }
    }
}