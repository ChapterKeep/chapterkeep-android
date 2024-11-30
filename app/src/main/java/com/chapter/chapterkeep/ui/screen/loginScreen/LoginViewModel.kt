package com.chapter.chapterkeep.ui.screen.loginScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chapter.chapterkeep.api.ServicePool
import com.chapter.chapterkeep.api.dto.request.RequestLoginDto
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    var userID by mutableStateOf("")
    var userPassWord by mutableStateOf("")

    fun updateUserId(id: String) {
        userID = id
    }

    fun updateUserPassword(password: String) {
        userPassWord = password
    }

    fun login(userID: String, password: String, onLoginResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = ServicePool.memberService.postLogin(
                    RequestLoginDto(
                        id = userID,
                        password = password
                    )
                )

                if (response.code == "S001") {
                    onLoginResult(true, "환영합니다!")
                } else {
                    onLoginResult(false, response.message)
                }
            } catch (e: Exception) {
                onLoginResult(false, "로그인 중 오류가 발생했습니다: ${e.message}")
            }
        }
    }
}

