package com.chapter.chapterkeep.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.R

@Composable
fun DropDownMenu(
    navController: NavHostController
) {
    var expended by rememberSaveable {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .padding(top = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon_dropdown_menu),
            contentDescription = "menu",
            modifier = Modifier
                .size(2.dp, 12.dp)
                .clickable { expended = true }
        )
        DropdownMenu(
            expanded = expended,
            onDismissRequest = { expended = false },
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
        ) {
            DropdownMenuItem(
                text = {
                    Text(
                        text = stringResource(R.string.viewbook_edit),
                        fontSize = 12.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxSize()
                    )
                },
                onClick = {
                    expended = false
                    TODO("수정하기 로직")
                },
                modifier = Modifier
                    .size(90.dp, 20.dp)
                    .align(Alignment.CenterHorizontally)
            )
            DropdownMenuItem(
                text = {
                    Text(
                        text = stringResource(R.string.viewbook_delete),
                        fontSize = 12.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxSize()
                    )
                },
                onClick = {
                    expended = false
                    TODO("삭제하기 로직")
                },
                modifier = Modifier
                    .size(90.dp, 20.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}