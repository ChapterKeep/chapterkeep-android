package com.chapter.chapterkeep.ui.component

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext

@Composable
fun DoubleBackPressToExit() {
    var backPressedTime by remember { mutableStateOf(0L) }
    val context = LocalContext.current

    BackHandler {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            (context as? Activity)?.finish()
        } else {
            Toast.makeText(context, "한번 더 누르면 앱이 종료됩니다", Toast.LENGTH_SHORT).show()
        }
        backPressedTime = System.currentTimeMillis()
    }
}