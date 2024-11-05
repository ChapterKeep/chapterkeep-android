package com.chapter.chapterkeep.ui.screen.bookScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.component.CommonButton
import com.chapter.chapterkeep.ui.component.textfield.GrayISBNTextField

@Composable
fun AddBookInfo(
    isbn: String,
    onIsbnChange: (String) -> Unit,
    bookTitle: String,
    bookWriter: String,
    onIsbnSubmit: () -> Unit,
    onImageClick: () -> Unit,
    onSearchClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            AddBookTitle(R.string.addbook_selectbook_title)

            Text(
                text = stringResource(R.string.addbook_selectbook_isbn_search),
                color = colorResource(R.color.gray_800),
                fontSize = 10.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    onSearchClick()
                }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 15.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.img_addbook),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(62.dp, 100.dp)
                    .clickable {
                        onImageClick()
                    }
            )

            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    GrayISBNTextField(
                        value = isbn,
                        onValueChange = onIsbnChange,
                        placeholder = stringResource(R.string.addbook_selectbook_isbn),
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done,
                        shape = 12,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 15.dp)
                    )

                    CommonButton(
                        label = stringResource(R.string.addbook_selectbook_isbn_submit),
                        fontSize = 13,
                        modifier = Modifier.padding(3.dp)
                    ) {
                        onIsbnSubmit()
                    }
                }
                Spacer(Modifier.height(10.dp))

                Text(
                    text = bookTitle,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 5.dp)
                )

                Text(
                    text = bookWriter,
                    fontSize = 12.sp,
                    color = colorResource(R.color.gray_700)
                )
            }
        }
    }
}
