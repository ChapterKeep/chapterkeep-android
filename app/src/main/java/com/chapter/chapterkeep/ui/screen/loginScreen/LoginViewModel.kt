package com.chapter.chapterkeep.ui.screen.loginScreen

import TokenManager
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

                val token = response.headers()["Authorization"]?.replace("Bearer ", "")
                if (!token.isNullOrEmpty()) {
                    TokenManager.saveToken(token)
                    val savedToken = TokenManager.getToken()
                }

                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody?.code == "S001") {
                        onLoginResult(true, "환영합니다!")
                    } else {
                        onLoginResult(false, responseBody?.message ?: "알 수 없는 오류")
                    }
                } else {
                    onLoginResult(false, "로그인 실패: ${response.message()}")
                }
            } catch (e: Exception) {
                onLoginResult(false, "로그인 중 오류가 발생했습니다: ${e.message}")
            }
        }
    }

    fun clearData(){
        userID = ""
        userPassWord =""
    }
}

